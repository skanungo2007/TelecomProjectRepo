package dataClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcel {
	
	static String filePath = System.getProperty("user.dir") + "\\src/test/java\\dataClass";
	
	static String fileName = "TelecomProjectValues2.xlsx";
	
	
	
	/*
	@DataProvider(name="customerData")
	public static Object[][] readCustomerData() throws IOException {
		
		
		String sheetName = "customerDetails";
		
		File file = new File(filePath + "\\" + fileName);
		
		FileInputStream fis = new FileInputStream(file);
		
		Workbook workbook = null;
		
		
		
		String extension = fileName.substring(fileName.indexOf("."));
		
		if(extension.equalsIgnoreCase(".xlsx")) {
			
			workbook = new XSSFWorkbook(fis);
			
		} else if(extension.equalsIgnoreCase(".xls")) {
			
			workbook = new HSSFWorkbook(fis);
			
		} else {
			
			System.out.println("Not a valid extension");
		}
		
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		
		Row row = sheet.getRow(0);
		
		int numberOfRows = sheet.getPhysicalNumberOfRows() - 1 ;
		int numberOfColumn = row.getPhysicalNumberOfCells();
		
		//System.out.println(numberOfRows);
		//System.out.println(numberOfColumn);
		
		Object data[][] = new Object[1][5];
		
		//for(int i=1; i<numberOfRows; i++) {
			
			//take values from 2nd row so adding +1
			//Change row number for next value
			
			row = sheet.getRow(1);
			
			
			
			Cell fname = row.getCell(0);
			Cell lname = row.getCell(1);
			Cell addrs = row.getCell(2);
			Cell email = row.getCell(3);
			Cell phone = row.getCell(4);
			
			
			
			data[0][0] = fname.getStringCellValue();
			data[0][1] = lname.getStringCellValue();
			data[0][2] = addrs.getStringCellValue();
			data[0][3] = email.getStringCellValue();
			data[0][4] = phone.getStringCellValue();
			
			

		
		return data;
	}
	*/	
	
	@DataProvider(name="customerData")
	public static Object[][] readCustomerData() throws IOException {
		
		
		String sheetName = "customerDetails";
		
		File file = new File(filePath + "\\" + fileName);
		
		FileInputStream fis = new FileInputStream(file);
		
		Workbook workbook = null;
		
		
		
		String extension = fileName.substring(fileName.indexOf("."));
		
		if(extension.equalsIgnoreCase(".xlsx")) {
			
			workbook = new XSSFWorkbook(fis);
			
		} else if(extension.equalsIgnoreCase(".xls")) {
			
			workbook = new HSSFWorkbook(fis);
			
		} else {
			
			System.out.println("Not a valid extension");
		}
		
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		
		Row row = sheet.getRow(0);
		
		int numberOfRows = sheet.getPhysicalNumberOfRows() - 1 ;
		int numberOfColumn = row.getPhysicalNumberOfCells();
		
		System.out.println(numberOfRows);
		System.out.println(numberOfColumn);
		
		Object data[][] = new Object[numberOfRows][numberOfColumn];
		
		//i=1 as we need to take values from the first row
		
		for(int i=0; i<numberOfRows; i++) {
			
			//i+1 as we are reading values from first row
			row = sheet.getRow(i+1);
			
			
			
			Cell fname = row.getCell(0);
			Cell lname = row.getCell(1);
			Cell addrs = row.getCell(2);
			Cell email = row.getCell(3);
			Cell phone = row.getCell(4);
			
			
			
			data[i][0] = fname.getStringCellValue();
			data[i][1] = lname.getStringCellValue();
			data[i][2] = addrs.getStringCellValue();
			data[i][3] = email.getStringCellValue();
			data[i][4] = phone.getStringCellValue();
			
		}

		
		return data;
	}
		
	
	@DataProvider(name="tariff")
	public static Object[][] getTariffDetails() throws IOException {
		
		String sheetName = "tariffDetails";
		
		File file = new File(filePath + "\\" + fileName);
		
		FileInputStream fis = new FileInputStream(file);
		
		Workbook workbook = null;
		
		
		
		String extension = fileName.substring(fileName.indexOf("."));
		
		if(extension.equalsIgnoreCase(".xlsx")) {
			
			workbook = new XSSFWorkbook(fis);
			
		} else if(extension.equalsIgnoreCase(".xls")) {
			
			workbook = new HSSFWorkbook(fis);
			
		} else {
			
			System.out.println("Not a valid extension");
		}
		
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		Row row = sheet.getRow(0);
		
		int numberOfRows = sheet.getPhysicalNumberOfRows() - 1;
		int numberOfColumn = row.getPhysicalNumberOfCells();
		
		Object data[][] = new Object[numberOfRows][numberOfColumn];
		
		
		for(int i=0; i<numberOfRows; i++) {
			
			row = sheet.getRow(i+1);
			
			Cell rental = row.getCell(0);
			Cell localMin = row.getCell(1);
			Cell intMin = row.getCell(2);
			Cell smsPack = row.getCell(3);
			Cell localCharge = row.getCell(4);
			Cell intCharge = row.getCell(5);
			Cell smsCharge = row.getCell(6);
			
			data[i][0] = rental.getNumericCellValue();
			data[i][1] = localMin.getNumericCellValue();
			data[i][2] = intMin.getNumericCellValue();
			data[i][3] = smsPack.getNumericCellValue();
			data[i][4] = localCharge.getNumericCellValue();
			data[i][5] = intCharge.getNumericCellValue();
			data[i][6] = smsCharge.getNumericCellValue();
			
		}
		
		
		return data;
		
	}
	
	/*
	@DataProvider(name="tariff")
	public static Object[][] getTariffDetails() throws IOException {
		
		String sheetName = "tariffDetails";
		
		File file = new File(filePath + "\\" + fileName);
		
		FileInputStream fis = new FileInputStream(file);
		
		Workbook workbook = null;
		
		
		
		String extension = fileName.substring(fileName.indexOf("."));
		
		if(extension.equalsIgnoreCase(".xlsx")) {
			
			workbook = new XSSFWorkbook(fis);
			
		} else if(extension.equalsIgnoreCase(".xls")) {
			
			workbook = new HSSFWorkbook(fis);
			
		} else {
			
			System.out.println("Not a valid extension");
		}
		
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		Row row = sheet.getRow(0);
		
		int numberOfRows = sheet.getPhysicalNumberOfRows() - 1;
		int numberOfColumn = row.getPhysicalNumberOfCells();
		
		Object data[][] = new Object[1][7];
		
		
		row = sheet.getRow(1);
		
		Cell rental = row.getCell(0);
		Cell localMin = row.getCell(1);
		Cell intMin = row.getCell(2);
		Cell smsPack = row.getCell(3);
		Cell localCharge = row.getCell(4);
		Cell intCharge = row.getCell(5);
		Cell smsCharge = row.getCell(6);
		
		data[0][0] = rental.getNumericCellValue();
		data[0][1] = localMin.getNumericCellValue();
		data[0][2] = intMin.getNumericCellValue();
		data[0][3] = smsPack.getNumericCellValue();
		data[0][4] = localCharge.getNumericCellValue();
		data[0][5] = intCharge.getNumericCellValue();
		data[0][6] = smsCharge.getNumericCellValue();
		
		return data;
		
	}
	
	*/
}


