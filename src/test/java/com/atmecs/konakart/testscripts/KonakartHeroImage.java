package com.atmecs.konakart.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.konakart.helperpages.HelperHeroImagePage;
import com.atmecs.konakart.reports.ExtentReport;
import com.atmecs.konakart.reports.LogReports;
import com.atmecs.konakart.testbase.InvokeBrowser;

public class KonakartHeroImage extends InvokeBrowser {
	ExtentReport report = new ExtentReport();
	LogReports log = new LogReports();
	String actualData;

	@BeforeTest
	public void startReports() {
		startReport();
	}
   @Test
	public  void validateHeroImagePage() throws Exception {

		ExtentReport.logger = extent.startTest("validateHeroImagePage");
		HelperHeroImagePage.validateHeroImage();
		

	}
}
