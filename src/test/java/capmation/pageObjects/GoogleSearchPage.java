package capmation.pageObjects;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import capmation.common.WebElementFunctions;

public class GoogleSearchPage {
	WebDriver ldriver;
	public GoogleSearchPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Google Search Field
	@FindBy(xpath="//div//input[@type='text']")
	@CacheLookup
	WebElement searchField;
	
	//First Link
	@FindBy(xpath="//h3[@class='LC20lb DKV0Md']")
	@CacheLookup
	List<WebElement> searchResults;

	WebElementFunctions func = new WebElementFunctions();

	public void searchCapmation(String searchTerm){
		searchField.clear();
		searchField.sendKeys(searchTerm, Keys.ENTER);
	}

	//Wait for search results to be displayed and return number of search results displayed
	public int searchResultsDisp(){
		int [] count = func.getElementsCount(searchResults, ldriver);
		return count[1]; // return number of search results displayed
	}

	//Verify if all search results are displayed
	public boolean isAllSearchResultsDisp(){
		return func.searchResultsDisplayed(searchResults, ldriver);
	}

	//click on first result
	public void clickFirstSearchResult(){
		searchResults.get(0).click();
	}

	//Get Text Displayed of First Result Displayed
	public String getSearchResultText(){
		return searchResults.get(0).getText();
	}

}
