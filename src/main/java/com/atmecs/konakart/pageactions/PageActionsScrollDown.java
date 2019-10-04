package com.atmecs.konakart.pageactions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageActionsScrollDown 
{
public static void homePageScrollDown(WebDriver driver) {
		
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.scrollBy(0,1200)");
	}
	
	public static void PageScrollDown(WebDriver driver) {
		
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.scrollBy(0,700)");
	}
	
public static void scrollDownToBottom(WebDriver driver) {
		
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
}
