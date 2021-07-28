package capmation.common;

import capmation.pageObjects.GoogleSearchPage;
import capmation.testCases.BaseClass;

public class CommonFunctions extends BaseClass{
	
	//SUPER USER ROLE COMMON FUNCTIONS
	
	//Navigation Functions
			public void navigateToCapmationPage()
			{
				GoogleSearchPage gsp = new GoogleSearchPage(driver);

				gsp.searchCapmation(searchTerm);

				gsp.clickFirstSearchResult();
			}
}
