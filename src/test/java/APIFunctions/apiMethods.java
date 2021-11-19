package APIFunctions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class apiMethods {

	public static String PostSingleRecord(String baseURL, String body, int expStatusCode) {
		Response postResponse;
		String Response = "";
		int statusCode;
		SoftAssert softAssertion = new SoftAssert();
		try {
			RestAssured.baseURI = baseURL;
			postResponse = given().header("Content-Type", "application/json").body(body).when()
					.post(config.endPointInsertSingleRecord);

			statusCode = postResponse.statusCode();
			Response = postResponse.getBody().asPrettyString();

			if (statusCode == expStatusCode) {
				{
					System.out.println("Passed: The Status Code Expected: " + expStatusCode + " Actual: " + statusCode);					
				}
			} else {
				System.out.println("Failed: The Status Code Expected: " + expStatusCode + " Actual: " + statusCode);
				softAssertion.assertTrue(false);
			}
		} catch (Exception e) {
			System.out.println("exception" + e.getMessage());
		}
		if (Response.contains("message")) {
			Response = Response.substring(Response.indexOf("message") + 9, Response.indexOf("path") - 1);
		}
		return (Response);
	}

	public static String PostMultipleRecord(String baseURL, String body, int reponse) {
		String Response = "";
		try {
			RestAssured.baseURI = baseURL;
			Response = given().header("Content-Type", "application/json").body(body).when()
					.post(config.endPointInsertMultipleRecord).then().statusCode(reponse).extract().asPrettyString();
		} catch (Exception e) {
			System.out.println("exception" + e.getMessage());
		}
		if (Response.contains("message")) {
			Response = Response.substring(Response.indexOf("message") + 9, Response.indexOf("path") - 1);

		}
		return (Response);
	}

	public static void VerifyResponse(String TestCase, String Response, String Expected) {
		SoftAssert softAssertion = new SoftAssert();

		if (Response.contains(Expected)) {
			System.out.println(
					"Test Case Passed:" + TestCase + " The Response Expected: " + Expected + " Actual: " + Response);
		} else {
			System.out.println(
					"Test Case Failed:" + TestCase + " The Response Expected: " + Expected + " Actual: " + Response);
			softAssertion.assertTrue(false);
		}

		// assertTrue(Response == Expected);
	}

	public static void RakeDatabase(String baseURL, int reponse) {
		String Response = "";

		try {
			RestAssured.baseURI = baseURL;
			Response = given().header("Content-Type", "application/json").when().post(config.rakeDB).then()
					.statusCode(reponse).extract().asPrettyString();
			System.out.println(Response);
		} catch (Exception e) {
			System.out.println("exception" + e.getMessage());
		}
	}

	public static void getSingleTaxReliefAndVerify(String testIdName, String baseURL, String tax) {
		
		String Response = "", resTax = null;
		int resTaxInt, expTaxInt;
		SoftAssert softAssertion = new SoftAssert();
		try {
			
			Response = getTaxRelief(testIdName,baseURL);
			resTax = Response.substring(Response.indexOf("\"relief\": \"") + 9, Response.indexOf("}") - 1);
			resTax = resTax.substring(2, resTax.indexOf("."));
			resTaxInt = Integer.parseInt(resTax);
			expTaxInt = Integer.parseInt(tax);
			if (resTaxInt == expTaxInt) {
				System.out.println("Test Case Passed:" + " The Tax Expected: " + tax + " Actual: " + resTax);
			} else {
				System.out.println("Test Case Failed:" + " The tax Expected: " + tax + " Actual: " + resTax);
				softAssertion.assertTrue(false);
			}
		} catch (Exception e) {
			System.out.println("exception" + e.getMessage());
		}

	}
	
	public static String getTaxRelief(String testIdName, String baseURL) {
		Response taxresponse = null ;
		try {
			RestAssured.baseURI = baseURL;
			taxresponse = given().header("Content-Type", "application/json").when().get(config.getTaxRelief);			
				
		}catch (Exception e) {
			System.out.println("exception" + e.getMessage());
		}
		System.out.println(testIdName + ": " + taxresponse.getBody().asPrettyString());
		return(taxresponse.getBody().asPrettyString());
		
	}
	
	public static void verifyTaxReliefFormat(String Expected, String Actual)
	{
		if(Expected.equals(Actual)) 
		{
			System.out.println("Test Case Passed:" + " The tax relief format Expected: " + Expected + " Actual: " + Actual);
		}
		else {
			System.out.println("Test Case Failed:" + " The tax relief format Expected: " + Expected + " Actual: " + Actual);
			Assert.assertTrue(false);
			
		}
	}
	
	public static void verifynatidFormat(String Expected, String Actual)
	{
		String resTax = Actual.substring(Actual.indexOf("\"natid\": \"") + 10,Actual.indexOf(",")-1);		
		
		if(Expected.equals(resTax)) 
		{
			System.out.println("Test Case Passed:" + " The natid Expected: " + Expected + " Actual: " + resTax);
		}
		else {
			System.out.println("Test Case Failed:" + " The natid Expected: " + Expected + " Actual: " + resTax);
			Assert.assertTrue(false);
			
		}
	}
	
}
