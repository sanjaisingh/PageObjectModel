package com.selenium.facebook.utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {

	public  FileInputStream fileLocation = null;
	XSSFWorkbook workbook = null;
	XSSFSheet sheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;
	public  String filePath;	
	
	public Xls_Reader(String filePath)
	{
		this.filePath = filePath;
		try {
			fileLocation = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fileLocation);
			sheet = workbook.getSheetAt(0);
			fileLocation.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}		

	public String getCellData(String sheetName, int colNum, int rowNum)
	{
		try
		{
			if(rowNum <= 0)
				return "";
			int index = workbook.getSheetIndex(sheetName);
			if(index == -1)
				return "";	
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row == null)
				return "";
			cell = row.getCell(colNum);
			if(cell == null)
				return "";
		
			if(cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA )
			{			  
				String cellText = String.valueOf(cell.getNumericCellValue());
				return cellText;
			}
			else if(cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else 
				return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
		}
	}
	
	/*
	@DataProvider(name = "dataSet")
	public Object[][] readDataExcel() throws IOException	
	{
		String sheetName = "datasheet";	
		XSSFWorkbook book = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/data.xlsx")));
		XSSFSheet sheet = book.getSheet(sheetName);
		System.out.println(book.getSheetIndex("sheet2"));
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		Object[][] dataTable = new Object[rowCount][1];
		Hashtable<String, String> table = null;
		
		for(int rows = 0; rows < rowCount; rows++)
		{
			table = new Hashtable<String, String>();
			for(int cols = 0; cols < colCount; cols++)
			{				
				String key = sheet.getRow(0).getCell(cols).getStringCellValue();
				String value = sheet.getRow(rows+1).getCell(cols).getStringCellValue();
				table.put(key, value);
			}
			dataTable[rows][0] = table;
		}
		return dataTable;
	}*/
}
