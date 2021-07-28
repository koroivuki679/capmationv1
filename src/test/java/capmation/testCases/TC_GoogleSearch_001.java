package capmation.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import capmation.pageObjects.CapmationPage;
import capmation.pageObjects.GoogleSearchPage;

public class TC_GoogleSearch_001 extends BaseClass {
	
	//Test if search results are displayed for keyword: capmation
	@Test(priority = 0)
	public void testGoogleSearchResults(){

		GoogleSearchPage gsp = new GoogleSearchPage(driver);
		
		logger.info("GOOGLE SEARCH PAGE OPENED");

		gsp.searchCapmation(searchTerm);
		logger.info("Search Term entered: " + searchTerm);

		logger.info(gsp.searchResultsDisp() + " Results Displayed");

		try{
			Assert.assertTrue(gsp.isAllSearchResultsDisp());
			logger.info("Results Displayed as expected");
		}catch (AssertionError ex){
			logger.info("Failed to locate search results");
			throw new AssertionError(ex);
		}
	}
	
	//Test if click action on first results redirects to Capmation Inc Website
	@Test (priority=1)
	public void  testRedirectToCapmation()
	{
		GoogleSearchPage gsp = new GoogleSearchPage(driver);
		CapmationPage cp = new CapmationPage(driver);

		String firstResult = gsp.getSearchResultText();
		gsp.clickFirstSearchResult();
		logger.info("Clicked on First Result Displayed: " + firstResult);

		try{
			Assert.assertTrue(cp.logoDisplayed());
			logger.info("Capmation Logo is displayed... successfully navigated to Capmation Website");
		}catch (AssertionError ex){
			logger.info("Failed to redirect to Capmation Website");
			throw new AssertionError(ex);
		}
	}
		
}
