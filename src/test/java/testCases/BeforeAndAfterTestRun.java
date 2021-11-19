package testCases;

import java.io.File;
import java.io.IOException;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import APIFunctions.environment;
import UtilityFunctions.excelHandling;
import WebUIFunctions.pages.UploadWorkingHeroDetailsFromCSVFile;

public class BeforeAndAfterTestRun {
	
	public static environment testEnvironment;
	public static int InsertSuccessResponseCode = 202;
	public static int InsertFailResponseCode = 500;
	public static excelHandling exl = new excelHandling();
	static UploadWorkingHeroDetailsFromCSVFile UploadWorkingHeroDetailsPage;
	static WebDriver driver;
	

	@BeforeTest
	@Parameters({ "environment" })
	public void TestSetting(String environemnt) throws IOException {
		try {
			ConfigFactory.setProperty("env", environemnt);
			testEnvironment = ConfigFactory.create(environment.class);
			System.out.println("Test Environment URL used: " + testEnvironment.url());
			// Read test data
			exl.readTestData("TestCase");
			String DriverPath = new File("src/test/java/Resource/chromedriver.exe").getAbsolutePath();
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver();

		} catch (Exception e) {
			System.out.println("exception" + e.getMessage());
		}
	}
	
	
	

}
