package com.atmecs.konakart.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;

import com.atmecs.konakart.constants.ConstantFilePaths;
import com.atmecs.konakart.reports.ExtentReport;
import com.atmecs.konakart.reports.LogReports;
import com.atmecs.konakart.utils.ReadLocatorsFile;

public class InvokeBrowser extends ExtentReport
{
	LogReports log = new LogReports();
	Properties baseProperty;
	String url;
	String browser;
	
	@BeforeMethod
	public void initializeBrowser() throws Exception
	{
		baseProperty = ReadLocatorsFile.loadProperty(ConstantFilePaths.CONFIG_FILE);

		url = baseProperty.getProperty("url");
		
		browser = baseProperty.getProperty("browserType");

		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ConstantFilePaths.CHROME_FILE);
			driver = new ChromeDriver();
			log.info("Chrome browser  started");
		} 
		else if (browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", ConstantFilePaths.FIREFOX_FILE);
			driver = new FirefoxDriver();
			log.info("Firefox browser  started");
		}
		else if (browser.equalsIgnoreCase("IE")) 
		{
			System.setProperty("webdriver.ie.driver", ConstantFilePaths.IE_FILE);
			driver = new InternetExplorerDriver();
			log.info("IE browser  started");
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}



