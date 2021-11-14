package APIFunctions;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class InsertMultipleWorkingHeroRecord {
	
public static void PostMultipleRecord(String body, int reponse) {
		
		RestAssured.baseURI = "http://localhost:8080/";
		given().header("Content-Type", "application/json").body
				(body).when().post("/calculator/insert")
		.then().log().all().assertThat().statusCode(reponse);
	}

}
