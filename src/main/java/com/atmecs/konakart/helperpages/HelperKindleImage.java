package com.atmecs.konakart.helperpages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.atmecs.konakart.dataallocators.konaKartXpathDataAllocators;
import com.atmecs.konakart.pageactions.PageActions;
import com.atmecs.konakart.reports.LogReports;
import com.atmecs.konakart.testbase.InvokeBrowser;

public class HelperKindleImage extends InvokeBrowser
{
	static LogReports log=new LogReports();
	static konaKartXpathDataAllocators xpathData=new konaKartXpathDataAllocators ();
		public static void validateStarRatingOfKindleFilter() throws Exception 
		{
			 xpathData.getData();
			List<WebElement> totalLH1RatingSize= PageActions.findListOfElements(driver,xpathData.getfirstStarRating());
			List<WebElement> totalLH2RatingSize= PageActions.findListOfElements(driver, xpathData.getSecondStarRating());
			List<WebElement> totalLH3RatingSize= PageActions.findListOfElements(driver,xpathData.getThirdStarRating());
			
			
			 if(totalLH1RatingSize.size()>=totalLH2RatingSize.size()&&totalLH2RatingSize.size()>=totalLH3RatingSize.size()) 
			  {
				  log. info("Star rating validated Successfully: & they are in HIGH To Low order"+" "
			  +totalLH1RatingSize.size()+" "+"star"+" "+totalLH2RatingSize.size()+" "
			  +"star"+" "+totalLH3RatingSize.size()+" "+"star" );
				  }
			  else if(totalLH1RatingSize.size()<=totalLH2RatingSize.size()&&totalLH2RatingSize.
			  size()<=totalLH3RatingSize.size())
			  { log.info("Star rating validated Successfully: & they are in LOW To HIGH order"+" "
			  +totalLH1RatingSize.size()+" "+"star"+" "+totalLH2RatingSize.size()+" "
			  +"star"+" "+totalLH3RatingSize.size()+" "+"star");
			  }
			  else
			  {
				  log.info("check no.of star ratings: some problem occured");
			  }
		}
	}
