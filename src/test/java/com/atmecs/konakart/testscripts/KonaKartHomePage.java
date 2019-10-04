package com.atmecs.konakart.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.atmecswebsite.validatetest.ValidateResult;
import com.atmecs.konakart.constants.ConstantFilePaths;
import com.atmecs.konakart.helperpages.HelperSearchPage;
import com.atmecs.konakart.reports.ExtentReport;
import com.atmecs.konakart.reports.LogReports;
import com.atmecs.konakart.testbase.InvokeBrowser;
import com.atmecs.konakart.utils.ExcelReader;
import com.atmecs.konakart.utils.TestDataProvider;

public class KonaKartHomePage extends InvokeBrowser {
	ExtentReport report = new ExtentReport();
	LogReports log = new LogReports();
	String actualData;
	int rowValue = 0;
	int colValue = 0;
	int rowCount = 1;

	@BeforeTest
	public void startReports() {
		startReport();
	}

	@Test(dataProvider = "testdata", dataProviderClass = TestDataProvider.class)
	public void performSearchPage(String productType, String productName) throws Exception 
	{
		ExtentReport.logger = extent.startTest("validateSearchPage");
		if (rowCount < 8) {
			rowCount++;
			actualData = HelperSearchPage.searchFunction(productType, productName);
			validateSearchPage(actualData);
		} 
		else if (rowCount <= 8) {
			actualData = HelperSearchPage.searchErrorFunction(productType, productName);
			validateSearchPage(actualData);
		}
	}

	public void validateSearchPage(String actualData) throws Exception {
		String[][] expectedData = ExcelReader.getData(ConstantFilePaths.ValidationDATA_FILE);
		rowValue++;
		ValidateResult.validateData(actualData, expectedData[rowValue][colValue], "validated product titles");
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
	}

}
