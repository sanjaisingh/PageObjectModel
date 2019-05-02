package com.selenium.facebook.utility;

import java.util.Hashtable;

public class DataUtil {

	public static Object[][] getData(Xls_Reader excelReader, String testCaseName)
	{
		String sheetName = "LoginSheet";
		int testStartFromRowNum = 1;

		// Get all rows
		while(!excelReader.getCellData(sheetName, 0, testStartFromRowNum).equals(testCaseName))
		{
			testStartFromRowNum++;
		}
		System.out.println("Actual test start from row: " + testStartFromRowNum);
		
		int colStartFromRowNum = testStartFromRowNum + 1;
		int dataStartFromRowNum = testStartFromRowNum + 2;
		int totalRows = 0;
		
		// Calculate total rows of data...
		while(!excelReader.getCellData(sheetName, 0, dataStartFromRowNum + totalRows).equals(""))
		{
			totalRows++;
		}
		System.out.println("Total rows of data are: " + totalRows);

		// Calculate total columns of data...
		int totalCols = 0;
		while(!excelReader.getCellData(sheetName, totalCols, colStartFromRowNum).equals(""))
		{
			totalCols++;
		}
		System.out.println("Total columns of data are: " + totalCols);		
		
		// Read test data from excel file
		
		Object[][] dataObject = new Object[totalRows][1];
		Hashtable<String, String> hashTable = null;
		int tableRows = 0;
		for(int rows = dataStartFromRowNum; rows < dataStartFromRowNum + totalRows; rows++)
		{
			hashTable = new Hashtable<String, String>();
			for(int cols = 0; cols < totalCols; cols++)
			{				
				String key = excelReader.getCellData(sheetName, cols, colStartFromRowNum);
				String value = excelReader.getCellData(sheetName, cols, rows);
				hashTable.put(key, value);
			}
			dataObject[tableRows][0] = hashTable;
			tableRows++;
		}
		return dataObject;
	}
}
