package testCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Test;

import APIFunctions.apiMethods;
import UtilityFunctions.excelHandling;

public class UserStory1 extends BeforeAndAfterTestRun{	 
	
	@Test (groups = { "APITestCase", "Regression" })
	public static void TC0001() throws IOException {
		String testCaseName = exl.getCellData(1, 1);
		String xmlInput = exl.getCellData(1, 8);
		String ResponseMessage = exl.getCellData(1, 9);
		System.out.println(testCaseName + ": XML Input" + xmlInput);
		String Reponse = apiMethods.PostSingleRecord(testEnvironment.url(),xmlInput, InsertSuccessResponseCode);
		apiMethods.VerifyResponse(testCaseName, Reponse, ResponseMessage);
	}
	
	@Test (groups = { "APITestCase", "Regression" })
	public static void TC0002() throws IOException {
		String xmlInput = exl.getCellData(2, 8);
		String ResponseMessage = exl.getCellData(2, 9);
		System.out.println("US1-TC0002: XML Input" + xmlInput);
		String Reponse = apiMethods.PostSingleRecord(testEnvironment.url(),xmlInput, InsertSuccessResponseCode);
		apiMethods.VerifyResponse("US1-TC0002", Reponse,ResponseMessage);
	}
	
	@Test (groups = { "APITestCase", "Regression" })
	public static void TC0003() throws IOException, InvalidFormatException {		
		excelHandling eHandler = new excelHandling();
		XSSFSheet testData;
		int rowCount;
		String Reponse;
		
		testData =  eHandler.getSheetData("TD-US1-TC0003");
		String xmlInput, testIdName, expectedMessage; 
		
		rowCount = testData.getPhysicalNumberOfRows();

		for(int i=1; i<rowCount; i++ )
		{
			System.out.println("test start: " + i);
			xmlInput = eHandler.getCellData(i, 6);
			testIdName = eHandler.getCellData(i, 0);
			expectedMessage = eHandler.getCellData(i, 7);
			
			System.out.println(testIdName + ": XML Input" + xmlInput);
			apiMethods.RakeDatabase(testEnvironment.url(),200);
			Reponse = apiMethods.PostSingleRecord(testEnvironment.url(),xmlInput, InsertFailResponseCode);			 
			apiMethods.VerifyResponse(testIdName, Reponse, expectedMessage);			
		}	
		
	}
	
	@Test (groups = { "APITestCase", "Regression" })
	public static void TC0004() throws IOException {
		String xmlInput = exl.getCellData(4, 8);
		String ResponseMessage = exl.getCellData(4, 9);
		System.out.println("US1-TC0004: XML Input" + xmlInput);
		String Reponse = apiMethods.PostSingleRecord(testEnvironment.url(),xmlInput, InsertFailResponseCode);
		apiMethods.VerifyResponse("US1-TC0004", Reponse,ResponseMessage);
	}
	
	@Test (groups = { "APITestCase", "Regression" })
	public static void TC0005() throws IOException {
		String xmlInput = exl.getCellData(5, 8);
		String ResponseMessage = exl.getCellData(5, 9);
		System.out.println("US1-TC0005: XML Input" + xmlInput);
		String Reponse = apiMethods.PostSingleRecord(testEnvironment.url(),xmlInput, InsertFailResponseCode);
		apiMethods.VerifyResponse("US1-TC0005", Reponse,ResponseMessage);
	}
	
	@Test (groups = { "APITestCase", "Regression" })
	public static void TC0006() throws IOException {
		String xmlInput = exl.getCellData(6, 8);
		String ResponseMessage = exl.getCellData(6, 9);
		System.out.println("US1-TC0006: XML Input" + xmlInput);
		String Reponse = apiMethods.PostSingleRecord(testEnvironment.url(),xmlInput, InsertFailResponseCode);
		apiMethods.VerifyResponse("US1-TC0006", Reponse,ResponseMessage);
	}
	
	@Test (groups = { "APITestCase", "Regression" })
	public static void TC0007() throws IOException {
		
		String xmlInput = exl.getCellData(7, 8);
		String ResponseMessage = exl.getCellData(7, 9);
		System.out.println("US1-TC0005: XML Input" + xmlInput);
		String Reponse = apiMethods.PostSingleRecord(testEnvironment.url(),xmlInput, InsertFailResponseCode);
		apiMethods.VerifyResponse("US1-TC0007", Reponse,ResponseMessage);
	}
	
	@Test (groups = { "APITestCase", "Regression" })
	public static void TC0008() throws IOException {
		String xmlInput = exl.getCellData(8, 8);
		String ResponseMessage = exl.getCellData(8, 9);
		System.out.println("US1-TC0005: XML Input" + xmlInput);
		String Reponse = apiMethods.PostSingleRecord(testEnvironment.url(),xmlInput, InsertFailResponseCode);
		apiMethods.VerifyResponse("US1-TC0008", Reponse,ResponseMessage);
	}
}
  