package com.atmecs.konakart.dataallocators;

import java.io.IOException;
import java.util.Properties;
import com.atmecs.konakart.constants.ConstantFilePaths;
import com.atmecs.konakart.utils.ReadLocatorsFile;


public class konaKartXpathDataAllocators 
{
	String selectFieldSearchDropdownXpath;
	String inputFieldSearchButtonXpath;
	String clickOnSearchFieldXpath;
	String validatingProductTitle;
	String validatingProductError;
	String selectHeroImageXpath;
	String validateProductDescriptionTab;
	String validateSpecificationsTab;
	String validateCustomerReviewsTab;
	String selectReviewSort;
	String validateCustomerReviewDetails;
	String firstStarRating;
	String secondStarRating;
	String thirdStarRating;
	String  fouthStarRating;
	Properties properties;

	public void getData() throws IOException {
		properties = ReadLocatorsFile.loadProperty(ConstantFilePaths.LOCATORS_FILE);
		
		setSelectFieldSearchDropdownXpath();
		setInputFieldSearchButtonXpath();
		setClickOnSearchFieldXpath();
		setValidatingProductTitle();
		setValidatingProductError();
		setValidateCustomerReviewsTab();
		setSelectHeroImageXpath();
		setValidateProductDescriptionTab();
		setValidateSpecificationsTab();
		setValidateCustomerReviewsTab();
		setSelectReviewSort();
		setValidateCustomerReviewDetails();
		setfirstStarRating();
		setSecondStarRating();
		setThirdStarRating();
		setFouthStarRating();
	}
	
	
		
		public String getSecondStarRating() {
		return secondStarRating;
	}



	public void setSecondStarRating() {
		secondStarRating =properties.getProperty("secondStarRating") ;
	}



	public String getThirdStarRating() {
		return thirdStarRating;
	}



	public void setThirdStarRating() {
		thirdStarRating =properties.getProperty("thirdStarRating") ;
	}



	public String getFouthStarRating() {
		return fouthStarRating;
	}



	public void setFouthStarRating() {
		fouthStarRating =properties.getProperty("fourthStarRating");
	}



		public String getfirstStarRating() {
		return firstStarRating;
	}



	public void setfirstStarRating() {
		firstStarRating =properties.getProperty("firstStarRating") ;
	}



		public String getSelectReviewSort() {
		return selectReviewSort;
	}

	public void setSelectReviewSort() {
		selectReviewSort =properties.getProperty("selectReviewSort");
	}



	public String getValidateCustomerReviewDetails() {
		return validateCustomerReviewDetails;
	}



	public void setValidateCustomerReviewDetails() {
		validateCustomerReviewDetails =properties.getProperty("validateCustomerReviewDetails") ;
	}



		public String getSelectHeroImageXpath() {
		return selectHeroImageXpath;
	}

	public void setSelectHeroImageXpath() {
		selectHeroImageXpath =properties.getProperty("selectHeroImageXpath");;
	}

	public String getValidateProductDescriptionTab() {
		return validateProductDescriptionTab;
	}

	public void setValidateProductDescriptionTab() {
		validateProductDescriptionTab = properties.getProperty("validateProductDescriptionTab");;
	}

	public String getValidateSpecificationsTab() {
		return validateSpecificationsTab;
	}

	public void setValidateSpecificationsTab() {
		validateSpecificationsTab = properties.getProperty("validateSpecificationsTab");;
	}

	public String getValidateCustomerReviewsTab() {
		return validateCustomerReviewsTab;
	}

	public void setValidateCustomerReviewsTab() {
		validateCustomerReviewsTab =properties.getProperty("validateCustomerReviewsTab");  ;
	}

		public String getValidatingProductError() {
		return validatingProductError;
	}

	public void setValidatingProductError() {
		validatingProductError = properties.getProperty("validatingProductError"); ;
	}

		public String getValidatingProductTitle() {
		return validatingProductTitle;
	}

	public void setValidatingProductTitle() {
		validatingProductTitle = properties.getProperty("validatingProductTitle");
	}

		public String getSelectFieldSearchDropdownXpath() {
		return selectFieldSearchDropdownXpath;
	}

	public void setSelectFieldSearchDropdownXpath() {
		selectFieldSearchDropdownXpath = properties.getProperty("selectFieldSearchDropdownXpath");
	}

	public String getInputFieldSearchButtonXpath() {
		return inputFieldSearchButtonXpath;
	}

	public void setInputFieldSearchButtonXpath() {
		inputFieldSearchButtonXpath = properties.getProperty("inputFieldSearchButtonXpath");
	}
	public String getClickOnSearchFieldXpath() {
		return clickOnSearchFieldXpath;
	}

	public void setClickOnSearchFieldXpath() {
		clickOnSearchFieldXpath =  properties.getProperty("clickOnSearchFieldXpath");
	}

		public static void main(String[] args) throws IOException {
			konaKartXpathDataAllocators  keys = new konaKartXpathDataAllocators ();
			keys.getData();
		}

}
