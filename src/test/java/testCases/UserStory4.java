package testCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Test;

import APIFunctions.apiMethods;
import UtilityFunctions.excelHandling;

public class UserStory4 extends BeforeAndAfterTestRun {

	@Test(groups = { "APITestCase", "Regression" })
	public static void TC0001() throws IOException {
		String testCaseName = exl.getCellData(20, 1);
		String xmlInput = exl.getCellData(20, 8);
		String ResponseMessage = exl.getCellData(20, 9);
		System.out.println(testCaseName + ": XML Input" + xmlInput);
		apiMethods.RakeDatabase(testEnvironment.url(), 200);
		apiMethods.PostSingleRecord(testEnvironment.url(), xmlInput, InsertSuccessResponseCode);
		String TaxRelief = apiMethods.getTaxRelief(testCaseName, testEnvironment.url());
		apiMethods.verifyTaxReliefFormat(ResponseMessage, TaxRelief);
	}
	
	@Test(groups = { "APITestCase", "Regression" })
	public static void TC0002() throws IOException {
		String testCaseName = exl.getCellData(21, 1);
		String xmlInput = exl.getCellData(21, 8);
		String ResponseMessage = exl.getCellData(21, 9);
		System.out.println(testCaseName + ": XML Input" + xmlInput);
		apiMethods.RakeDatabase(testEnvironment.url(), 200);
		apiMethods.PostSingleRecord(testEnvironment.url(), xmlInput, InsertSuccessResponseCode);
		String TaxRelief = apiMethods.getTaxRelief(testCaseName, testEnvironment.url());
		apiMethods.verifynatidFormat(ResponseMessage, TaxRelief);
	}

	@Test(groups = { "APITestCase", "Regression" })
	public static void TC0003() throws IOException, InvalidFormatException {
		excelHandling eHandler = new excelHandling();
		XSSFSheet testData;
		int rowCount;
		String expTax;

		testData = eHandler.getSheetData("TD-US4-TC0003");
		String xmlInput, testIdName;
		rowCount = testData.getPhysicalNumberOfRows();
		for (int i = 1; i < rowCount; i++) {
			System.out.println("test start: " + i);
			xmlInput = eHandler.getCellData(i, 10);
			testIdName = eHandler.getCellData(i, 0);
			expTax = eHandler.getCellData(i, 9);
			System.out.println(testIdName + ": XML Input" + xmlInput);
			apiMethods.RakeDatabase(testEnvironment.url(), 200);
			apiMethods.PostSingleRecord(testEnvironment.url(), xmlInput, InsertSuccessResponseCode);
			apiMethods.getSingleTaxReliefAndVerify(testIdName, testEnvironment.url(), expTax);
		}

	}

}
