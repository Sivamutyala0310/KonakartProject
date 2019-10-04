package com.atmecs.konakart.helperpages;

import com.atmecs.konakart.dataallocators.konaKartXpathDataAllocators;
import com.atmecs.konakart.pageactions.PageActions;
import com.atmecs.konakart.reports.LogReports;
import com.atmecs.konakart.testbase.InvokeBrowser;

public class HelperSearchPage extends InvokeBrowser
{
	static konaKartXpathDataAllocators xpathData=new konaKartXpathDataAllocators ();
	LogReports log = new LogReports();
	static String actualData;
	
	
	public static String searchFunction(String dropDownValue, String SearchValue) throws Exception
	{
		xpathData.getData();
		
		PageActions.clickElement(driver, xpathData.getSelectFieldSearchDropdownXpath());
		PageActions.selectDropDown(driver, xpathData.getSelectFieldSearchDropdownXpath(),dropDownValue);
		PageActions.sendKeys(driver, xpathData.getInputFieldSearchButtonXpath(), SearchValue);
		PageActions.clickElement(driver, xpathData.getClickOnSearchFieldXpath());
		actualData=PageActions.fetchAttributeText(driver, xpathData.getValidatingProductTitle());
		return actualData;
	}
	
	public static String searchErrorFunction(String dropDownValue, String SearchValue) throws Exception
	{
		PageActions.clickElement(driver, xpathData.getSelectFieldSearchDropdownXpath());
		PageActions.selectDropDown(driver, xpathData.getSelectFieldSearchDropdownXpath(),dropDownValue);
		PageActions.sendKeys(driver, xpathData.getInputFieldSearchButtonXpath(), SearchValue);
		PageActions.clickElement(driver, xpathData.getClickOnSearchFieldXpath());
		actualData=PageActions.fetchAttributeText(driver, xpathData.getValidatingProductError());
		return actualData;
	}
}
