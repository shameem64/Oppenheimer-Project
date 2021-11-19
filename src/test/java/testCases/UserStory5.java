package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import APIFunctions.apiMethods;
import WebUIFunctions.pages.UploadWorkingHeroDetailsFromCSVFile;

public class UserStory5 extends BeforeAndAfterTestRun{	
	@Test (groups = { "WebTestCase", "Regression" })
	public static void TC0001() throws IOException, InterruptedException {		
		
		UploadWorkingHeroDetailsPage = new UploadWorkingHeroDetailsFromCSVFile(driver);
		String TCname = "US5-TC001.csv";
		UploadWorkingHeroDetailsPage.NavigateToURLandUpload(TCname);
		UploadWorkingHeroDetailsPage.dispenseNowAndVerify("US5-TC001","Cash dispensed");				
	}
	
	@Test (groups = { "WebTestCase", "Regression" })
	public static void TC0002() throws IOException, InterruptedException {		
		
		apiMethods.RakeDatabase(testEnvironment.url(),200);
		UploadWorkingHeroDetailsPage.NavigateToURL();
		UploadWorkingHeroDetailsPage.dispenseNowAndVerify("US5-TC002","No Cash to dispense");				
	}
}
