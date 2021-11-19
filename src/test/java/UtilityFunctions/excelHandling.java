package UtilityFunctions;

import java.io.File;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class excelHandling {
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static String excelFilePath;

	public void readTestData(String sheeetName) throws IOException {
		try {
			sheet = getSheetData(sheeetName);
		} catch (Exception e) {
			System.out.println("exception" + e.getMessage());
		}
	}

	public String getCellData(int rowNumber, int colName) {
		return (sheet.getRow(rowNumber).getCell(colName).getRichStringCellValue().toString());
	}

	public XSSFSheet getSheetData(String sName) throws InvalidFormatException, IOException {
		try {
			excelFilePath = new File("src/test/java/TestData/Oppenheimer Project - TestCases.xlsx").getAbsolutePath();
			OPCPackage pkg = OPCPackage.open(new File(excelFilePath));
			workbook = new XSSFWorkbook(pkg);
			sheet = workbook.getSheet(sName);
			workbook.close();

		} catch (Exception e) {
			System.out.println("exception" + e.getMessage());
		}
		return (sheet);
	}
	
	public void CloseWorkBook() throws IOException
	{
		workbook.close();
	}
}
