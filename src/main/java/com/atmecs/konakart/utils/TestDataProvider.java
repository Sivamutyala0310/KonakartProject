package com.atmecs.konakart.utils;

import org.testng.annotations.DataProvider;

import com.atmecs.konakart.constants.ConstantFilePaths;

public class TestDataProvider 
{
	@DataProvider(name = "testdata")
	public Object[][] testData() {
		ExcelFileReader file = new ExcelFileReader(ConstantFilePaths.TESTDATA_FILE);
		int sheetIndex = 0;
		int rowCount = file.totalRowsinSheet(sheetIndex);
		int colCount = file.totalColsinSheet(sheetIndex);

		Object[][] data = new Object[rowCount][colCount];

		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			for (int colIndex = 0; colIndex < colCount; colIndex++) {

				data[rowIndex][colIndex] = ExcelFileReader.getData(sheetIndex, rowIndex + 1, colIndex);
			}
		}
		return data;
	}
}
