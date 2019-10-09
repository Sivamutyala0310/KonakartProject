package com.atmecs.konakart.pageactions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.atmecs.konakart.waits.Waits;


public class PageActions
{
		static WebElement element;
		static String text;

		public static void clickElement(WebDriver driver, String xpath) {
			driver.findElement(By.xpath(xpath)).click();
		}

		public static void sendKeys(WebDriver driver, String xpath, String keysToSend) {

			driver.findElement(By.xpath(xpath)).sendKeys(keysToSend);
		}

		public static void performActionEnter(WebDriver driver) {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
		}

		public static void performActionMove(WebDriver driver, WebElement element) {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		}

		public static void selectDropDown(WebDriver driver, String xpath,String dropDownValue) {
			Select select = new Select(driver.findElement(By.xpath(xpath)));
			select.selectByVisibleText(dropDownValue);;
		}

		public static String alertFindElement(WebDriver driver, String xpath) {
			driver.findElement(By.xpath(xpath));
			text = handlingAlert(driver);
			return text;

		}

		public static Dimension fetchAttributeSize(WebDriver driver, String xpath) {
			Waits.explicitWait(driver, xpath);
			Dimension value = driver.findElement(By.xpath(xpath)).getSize();
			return value;
		}

		public static String handlingAlert(WebDriver driver) {
			text = driver.switchTo().alert().getText();
			return text;
		}

		public static WebElement findElement(WebDriver driver, String xpath) {
			element = driver.findElement(By.xpath(xpath));
			performActionMove(driver, element);
			return element;
		}

		public static String fetchAttributeValue(WebDriver driver, String xpath) {
			Waits.explicitWait(driver, xpath);
			String value = driver.findElement(By.xpath(xpath)).getAttribute("validationMessage");
			return value;
		}

		public static String fetchAttributeText(WebDriver driver, String xpath) {
			Waits.explicitWait(driver, xpath);
			String value = driver.findElement(By.xpath(xpath)).getText();
			return value;
		}

		public static String fetchHtmlAttributeValue(WebDriver driver, String xpath) {
			Waits.explicitWait(driver, xpath);
			String value = driver.findElement(By.xpath(xpath)).getAttribute("innerHTML");
			return value;
		}
		
		public static void navigateBack(WebDriver driver)
		{
			driver.navigate().back();
		}
		
		public static List<WebElement> findListOfElements(WebDriver driver,String Xpath) throws Exception
		{
			Thread.sleep(2000);
		List<WebElement> starRating=driver.findElements(By.xpath(Xpath));
		return starRating;
		}

	}

