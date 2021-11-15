package APIFunctions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class InsertSingleWorkingHeroRecord {
	
public static String PostSingleRecord(String body, int reponse) {		
		RestAssured.baseURI = "http://localhost:8080/";
		String Response = given().header("Content-Type", "application/json").body
				(body).when().post("/calculator/insert").then().statusCode(reponse).
				log().all().extract().asPrettyString();					
		return(Response);
	}

public static void VerifyResponse(String TestCase, String Response, String Expected){
	
	System.out.println("Test Case:"+ TestCase + " The Response Expected: " + Expected + " Actual: " + Response);	
	assertTrue(Response == Expected);	
	
}

}
