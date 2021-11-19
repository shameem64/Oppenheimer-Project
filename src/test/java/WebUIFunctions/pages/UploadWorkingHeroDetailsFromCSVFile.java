package WebUIFunctions.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import APIFunctions.apiMethods;
import testCases.BeforeAndAfterTestRun;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;

public class UploadWorkingHeroDetailsFromCSVFile extends BeforeAndAfterTestRun {
	String OpenFilePathAutoIt = new File("src/test/java/Resource/FileUpload.exe").getAbsolutePath();
	String DriverPath = new File("src/test/java/Resource/chromedriver.exe").getAbsolutePath();
	String csvFilePathTC = "";
	WebDriver driver;
	SoftAssert softAssertion = new SoftAssert();
	By browseButton = By.xpath("//*[@id=\"contents\"]/div[1]/div[2]");
	By refreshButton = By.xpath("//*[@id=\"contents\"]/button[1]");
	By refreTableCol = By.xpath("//*[@id=\"contents\"]/div[2]/table/tbody/tr");
	By refreTableRow = By.xpath("//*[@id=\"contents\"]/div[2]/table/tbody/tr/td");
	By Summary = By.xpath("//*[@id=\"contents\"]/div[3]/div/p");
	By dispenseNowbtn = By.xpath("//*[@id=\"contents\"]/a[2]");	
	By dispensedMsg = By.xpath("//*[@id=\"app\"]/div/main/div/div/div");	

	public UploadWorkingHeroDetailsFromCSVFile(WebDriver driver) {
		this.driver = driver;
	}
	
	public void NavigateToURL() throws InterruptedException, IOException {	
	driver.get(testEnvironment.url());
	}

	public void NavigateToURLandUpload(String TCname) throws InterruptedException, IOException {
		apiMethods.RakeDatabase(testEnvironment.url(), 200);
		driver.get(testEnvironment.url());		
		csvFilePathTC = new File("src/test/java/TestData/" + TCname).getAbsolutePath();
		driver.manage().window().maximize();
		driver.findElement(browseButton).click();
		Thread.sleep(2000);
		OpenFilePathAutoIt = OpenFilePathAutoIt + " " + csvFilePathTC;
		Runtime.getRuntime().exec(OpenFilePathAutoIt);
		Thread.sleep(2000);
		driver.findElement(refreshButton).click();
		Thread.sleep(2000);
	}

	public void VerifyUploadData(String expectedRowData, String expSummay) throws InterruptedException, IOException {

		List refreTableColList = driver.findElements(refreTableCol);
		List refreTableRowList = driver.findElements(refreTableRow);
		
		String[] arrOfStr = expectedRowData.split(";");
		String expected, ActualName, ActualRelief, ExpectedName, ExpectedRelief;

		if (arrOfStr.length == refreTableColList.size()) {
			for (int i = 1; i <= arrOfStr.length - 1; i++) {
				expected = arrOfStr[i-1];
				ActualName = driver.findElement(By.xpath("//*[@id=\"contents\"]/div[2]/table/tbody/tr["+i+ "]/td[1]"))
						.getText();
				ActualRelief = driver.findElement(By.xpath("//*[@id=\"contents\"]/div[2]/table/tbody/tr["+i+"]/td[2]"))
						.getText();
				ExpectedName = expected.substring(0, expected.indexOf(":"));
				ExpectedRelief = expected.substring(expected.indexOf(":") + 1);
				if (ActualName.equals(ExpectedName) &  ActualRelief.equals(ExpectedRelief)) {
					System.out.println("Passed: The expected name in row " + i + " Expected: " + ExpectedName
							+ " Actual:" + ActualName);
					System.out.println("Passed: The expected Relef in row " + i + " Expected: " + ExpectedRelief
							+ " Actual:" + ActualRelief);
				} else {
					System.out.println("Failed: The expected name in row " + i + " Expected: " + ExpectedName
							+ " Actual:" + ActualName);
					System.out.println("Failed: The expected Relef in row " + i + " Expected: " + ExpectedRelief
							+ " Actual:" + ActualRelief);
					softAssertion.assertTrue(false);
				}
			}

		} else
		{
			System.out.println("Failed: Numebr of rows does not match : Expected : " + arrOfStr.length + " Actual:"
					+ refreTableColList.size());
		softAssertion.assertTrue(false);
		}		
	}

	public void dispenseNowAndVerify(String TName, String expMsg)
	{
		String dispenseMessageActual;
		driver.findElement(dispenseNowbtn).click();
		dispenseMessageActual = driver.findElement(dispensedMsg).getText();
		if(dispenseMessageActual.equals(expMsg))
		{
			System.out.println("TName:"+TName+ " Passed: The cash dispensed message: "+ dispenseMessageActual);
		}
		else
		{
			System.out.println("TName:"+TName+ " Failed: The cash dispensed message: "+ dispenseMessageActual);			
		}
		
	}
}
