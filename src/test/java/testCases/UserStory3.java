package testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import WebUIFunctions.pages.UploadWorkingHeroDetailsFromCSVFile;

public class UserStory3 extends BeforeAndAfterTestRun{	 
	
	@Test (groups = { "WebTestCase", "Regression" })
	public static void TC0001() throws IOException, InterruptedException {
		
		String expectedRowData = exl.getCellData(23, 8);
		String expectedSummary = exl.getCellData(23, 9);
		UploadWorkingHeroDetailsPage = new UploadWorkingHeroDetailsFromCSVFile(driver);	
		String TCname = "US3-TC001.csv";
		UploadWorkingHeroDetailsPage.NavigateToURLandUpload(TCname);
		UploadWorkingHeroDetailsPage.VerifyUploadData(expectedRowData,expectedSummary);		
	}

}
