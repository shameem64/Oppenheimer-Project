package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import APIFunctions.apiMethods;

public class UserStory2 extends BeforeAndAfterTestRun{
	
	@Test (groups = { "APITestCase", "Regression" })
	public static void TC0001() throws IOException {
		String testCaseName = exl.getCellData(9, 1);
		String xmlInput = exl.getCellData(9, 8);
		String ResponseMessage = exl.getCellData(9, 9);
		
		System.out.println(testCaseName + ": XML Input" + xmlInput);
		String Reponse = apiMethods.PostMultipleRecord(testEnvironment.url(),xmlInput, InsertSuccessResponseCode);
		apiMethods.VerifyResponse(testCaseName, Reponse, ResponseMessage);
	}
	
	@Test (groups = { "APITestCase", "Regression" })
	public static void TC0002() throws IOException {
		String testCaseName = exl.getCellData(10, 1);
		String xmlInput = exl.getCellData(10, 8);
		String ResponseMessage = exl.getCellData(10, 9);
		
		System.out.println(testCaseName + ": XML Input" + xmlInput);
		String Reponse = apiMethods.PostMultipleRecord(testEnvironment.url(),xmlInput, InsertSuccessResponseCode);
		apiMethods.VerifyResponse(testCaseName, Reponse, ResponseMessage);
	}

}
