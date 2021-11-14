package APIFunctions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

import io.restassured.RestAssured;

public class InsertSingleWorkingHeroRecord {
	
public static String PostSingleRecord(String body, int reponse) {		
		RestAssured.baseURI = "http://localhost:8080/";
		String Response = given().header("Content-Type", "application/json").body
				(body).when().post("/calculator/insert")
		.then().log().all().assertThat().statusCode(reponse).extract().toString();		
		return(Response);
	}

public static void VerifyResponse(String Response, String Expected){
	
	if(Response == Expected)
	{
		assertTrue(true);
	}
	else {assertTrue(false);}
	
}

}
