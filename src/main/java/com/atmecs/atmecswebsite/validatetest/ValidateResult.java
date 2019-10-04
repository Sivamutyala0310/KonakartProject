package com.atmecs.atmecswebsite.validatetest;

import org.openqa.selenium.Dimension;
import org.testng.Assert;

import com.atmecs.konakart.reports.LogReports;



public class ValidateResult
{
	static LogReports report = new LogReports();

	
	public static boolean validateData(String actual, String expected, String message) {
		try {
			Assert.assertEquals(actual,expected);
			report.info("Passed : " + message + ": " + "Actual data : " + actual + "   " + "Expected data :" + expected);
			return true;
		} catch (AssertionError assertionError) {
			report.info("failed: " + message + ": " + "Actual data : " + actual + "   " + "Expected :" + expected);
			return false;
		}
	}


	public static boolean validateDimensionData(Dimension actual, Object expected, String message) 
	{
		
		try {
			Assert.assertEquals(actual,expected);
			report.info("Passed : " + message + ": " + "Actual data : " + actual + "   " + "Expected data:" + expected);
			return true;
		} catch (AssertionError assertionError) {
			report.info("passed: " + message + ": " + "Actual data : " + actual + "   " + "Expected data:" + expected);
			return false;
		}
	}


	public static boolean validateData(int actual , String expected, String message) 
	{
		try {
			Assert.assertEquals(actual,expected);
			report.info("Passed : " + message + ": " + "Actual data : " + actual + "   " + "Expected data:" + expected);
			return true;
		} catch (AssertionError assertionError) {
			
			report.info("passed: " + message + ": " + "Actual data : " + actual + "   " + "Expected data:" + expected);
			return false;
		}
		

	}
}
