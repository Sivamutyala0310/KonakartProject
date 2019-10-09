package com.atmecs.konakart.helperpages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.atmecs.atmecswebsite.validatetest.ValidateResult;
import com.atmecs.konakart.dataallocators.KonaKartValidationDataAllocators;
import com.atmecs.konakart.dataallocators.konaKartXpathDataAllocators;
import com.atmecs.konakart.pageactions.PageActions;
import com.atmecs.konakart.pageactions.PageActionsScrollDown;
import com.atmecs.konakart.reports.LogReports;
import com.atmecs.konakart.testbase.InvokeBrowser;

public class HelperHeroImagePage extends InvokeBrowser {
	static konaKartXpathDataAllocators xpathData = new konaKartXpathDataAllocators();
	static KonaKartValidationDataAllocators validationData = new KonaKartValidationDataAllocators();

	static LogReports log = new LogReports();
	static String actualData;

	public static void validateHeroImage() throws Exception {
		xpathData.getData();
		validationData.getData();
		PageActions.clickElement(driver, xpathData.getSelectHeroImageXpath());
		PageActionsScrollDown.PageScrollDown(driver);

		actualData = PageActions.fetchAttributeText(driver, xpathData.getValidateProductDescriptionTab());
		ValidateResult.validateData(actualData, validationData.getExpectedProductDescription(),
				"validated Product Description tab");

		PageActions.clickElement(driver, xpathData.getValidateSpecificationsTab());
		actualData = PageActions.fetchAttributeText(driver, xpathData.getValidateSpecificationsTab());
		ValidateResult.validateData(actualData, validationData.getExpectedspecificationsTab(),
				"validated Product Specifications tab");

		PageActions.clickElement(driver, xpathData.getValidateCustomerReviewsTab());
		PageActionsScrollDown.PageScrollDown(driver);

		PageActions.clickElement(driver, xpathData.getSelectReviewSort());
		PageActions.selectDropDown(driver, xpathData.getSelectReviewSort(), "Most recent first");
		actualData = PageActions.fetchAttributeText(driver, xpathData.getValidateCustomerReviewDetails());
		ValidateResult.validateData(actualData, validationData.getExpectedFilterRecentDate(),
				"validated MostRecentFirst field");

		PageActions.selectDropDown(driver, xpathData.getSelectReviewSort(), "Oldest first");
		actualData = PageActions.fetchAttributeText(driver, xpathData.getValidateCustomerReviewDetails());
		ValidateResult.validateData(actualData, validationData.getExpectedFilterPastdate(),
				"validated MostRecentFirst field");

		PageActions.selectDropDown(driver, xpathData.getSelectReviewSort(), "Rating: high to low");

		List<WebElement> size = PageActions.findListOfElements(driver, "//div[@id='product-reviews-area']");

		System.out.println(size.size());
		System.out.println(size);
		if (size.size() == 4) {
			validateStarRatingOfCoffeeFilter();
		} else {
			HelperKindleImage.validateStarRatingOfKindleFilter();
		}

		PageActions.selectDropDown(driver, xpathData.getSelectReviewSort(), "Rating: low to high");
		List<WebElement> sizes = PageActions.findListOfElements(driver, "//div[@id='product-reviews-area']");
		if (sizes.size() == 4) {
			validateStarRatingOfCoffeeFilter();
		} else {
			HelperKindleImage.validateStarRatingOfKindleFilter();
		}

	}

	public static void validateStarRatingOfCoffeeFilter() throws Exception {
		List<WebElement> totalLH1RatingSize = PageActions.findListOfElements(driver, xpathData.getfirstStarRating());
		List<WebElement> totalLH2RatingSize = PageActions.findListOfElements(driver, xpathData.getSecondStarRating());
		List<WebElement> totalLH3RatingSize = PageActions.findListOfElements(driver, xpathData.getThirdStarRating());
		List<WebElement> totalLH4RatingSize = PageActions.findListOfElements(driver, xpathData.getFouthStarRating());

		if (totalLH1RatingSize.size() >= totalLH2RatingSize.size()
				&& totalLH2RatingSize.size() >= totalLH3RatingSize.size()
				&& totalLH3RatingSize.size() >= totalLH4RatingSize.size()) {
			log.info("Star rating validated Successfully: & they are in HIGH To Low order" + " "
					+ totalLH1RatingSize.size() + " " + "star" + " " + totalLH2RatingSize.size() + " " + "star" + " "
					+ totalLH3RatingSize.size() + " " + "star" + " " + totalLH4RatingSize.size() + " " + "star" + " ");
		} else if (totalLH1RatingSize.size() <= totalLH2RatingSize.size()
				&& totalLH2RatingSize.size() <= totalLH3RatingSize.size()
				&& totalLH3RatingSize.size() <= totalLH4RatingSize.size()) {
			log.info("Star rating validated Successfully: & they are in LOW To HIGH order" + " "
					+ totalLH1RatingSize.size() + " " + "star" + " " + totalLH2RatingSize.size() + " " + "star" + " "
					+ totalLH3RatingSize.size() + " " + "star" + " " + totalLH4RatingSize.size() + " " + "star" + " ");
		}

	}
}
