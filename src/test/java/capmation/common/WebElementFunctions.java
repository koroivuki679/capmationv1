package capmation.common;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementFunctions {
	
	public WebElementFunctions() {
	  }

	//Verify if Element is Clickable
	public boolean waitElementDisplayed(WebElement element, WebDriver ldriver)
	{
		boolean isDisplayed = true;
		//wait till element is clickable and displayed
		try {
			WebDriverWait wait = new WebDriverWait(ldriver, 5);
			wait.until(ExpectedConditions.visibilityOf(element));

		}
		catch (Exception ex)
		{
			System.out.print("Element not Displayed" + ex + "\n");
			isDisplayed = false;
		}
		return isDisplayed;
	}

	public int [] getElementsCount(List <WebElement> webElementList, WebDriver driver)
	{
		int elementCount = 0;
		int []count = new int[2];
		WebDriverWait wait = new WebDriverWait(driver, 3);

		for(int i = 0; i < webElementList.size(); i++) {
			try {
				wait.until(ExpectedConditions.visibilityOf(webElementList.get(i)));
				if (webElementList.get(i).isDisplayed())
				{
					elementCount++;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		count[0] = elementCount;
		count[1] = webElementList.size();
		return count;
	}

	public boolean searchResultsDisplayed(List <WebElement> webElementList, WebDriver driver){
		boolean isResultsDisplayed = false;
		int [] count = getElementsCount(webElementList, driver);
		if(count[0] == count [1]){
			isResultsDisplayed = true;
		}
		return isResultsDisplayed;
	}

}
