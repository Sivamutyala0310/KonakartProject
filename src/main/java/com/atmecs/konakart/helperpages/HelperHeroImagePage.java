package com.atmecs.konakart.helperpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.atmecswebsite.validatetest.ValidateResult;
import com.atmecs.konakart.dataallocators.konaKartXpathDataAllocators;
import com.atmecs.konakart.pageactions.PageActions;
import com.atmecs.konakart.pageactions.PageActionsScrollDown;
import com.atmecs.konakart.reports.LogReports;
import com.atmecs.konakart.testbase.InvokeBrowser;

public class HelperHeroImagePage extends InvokeBrowser
{
	static konaKartXpathDataAllocators xpathData=new konaKartXpathDataAllocators ();
	LogReports log = new LogReports();
	static String actualData;
	static int count=0;
 public static void  validateHeroImage() throws Exception
 {
	 xpathData.getData();
	 PageActions.clickElement(driver,xpathData.getSelectHeroImageXpath());
	 PageActionsScrollDown.PageScrollDown(driver);
	 Thread.sleep(2000);

	 actualData= PageActions.fetchAttributeText(driver, xpathData.getValidateProductDescriptionTab());
	 ValidateResult.validateData(actualData, "Product Description", "validated Product Description");
	 Thread.sleep(2000);
	 
	 PageActions.clickElement(driver, xpathData.getValidateSpecificationsTab());
	 actualData= PageActions.fetchAttributeText(driver, xpathData.getValidateSpecificationsTab());
	 ValidateResult.validateData(actualData, "Specifications", "validated Product Specifications");
	 
	 PageActions.clickElement(driver, xpathData.getValidateCustomerReviewsTab());
	 PageActionsScrollDown.PageScrollDown(driver);
	 Thread.sleep(2000);
	 
	 PageActions.clickElement(driver, xpathData.getSelectReviewSort());
	 PageActions.selectDropDown(driver, xpathData.getSelectReviewSort(), "Most recent first");
	 actualData= PageActions.fetchAttributeText(driver,xpathData.getValidateCustomerReviewDetails() );
	 ValidateResult.validateData(actualData, "Thursday 7 July 2016", "validated MostRecentFirst field");
	 
	 PageActions.selectDropDown(driver, xpathData.getSelectReviewSort(), "Oldest first");
	 actualData= PageActions.fetchAttributeText(driver,xpathData.getValidateCustomerReviewDetails() );
	 ValidateResult.validateData(actualData, "Friday 6 December 2013", "validated MostRecentFirst field");
	 
	 PageActions.selectDropDown(driver, xpathData.getSelectReviewSort(), "Rating: high to low");
	List<WebElement> total1= driver.findElements(By.xpath("(//div[@class='product-review']//div[@class='rating'])[1]//span[contains(@class,\"full\")]"));
	List<WebElement> total2= driver.findElements(By.xpath("(//div[@class='product-review']//div[@class='rating'])[2]//span[contains(@class,\"full\")]"));
	List<WebElement> total3= driver.findElements(By.xpath("(//div[@class='product-review']//div[@class='rating'])[3]//span[contains(@class,\"full\")]"));
	List<WebElement> total4= driver.findElements(By.xpath("(//div[@class='product-review']//div[@class='rating'])[4]//span[contains(@class,\"full\")]"));
	System.out.println(total1.size());
	System.out.println(total2.size());
	System.out.println(total3.size());
	System.out.println(total4.size());
	
	 
	 
	 
	 
 }
}
