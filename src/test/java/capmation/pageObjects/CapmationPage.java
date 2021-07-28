package capmation.pageObjects;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import capmation.common.WebElementFunctions;

public class CapmationPage {
	WebDriver ldriver;
	public CapmationPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//Capmation Logo
	@FindBy(xpath="//div//a[@class='site-header__logo']")
	@CacheLookup
	WebElement capmationLogo;

	//Let's get started logo
	@FindBy(xpath="//div[@class='footer-cta']//a")
	@CacheLookup
	WebElement getStartedLogo;

	//Services Link
	@FindBy(xpath="//header//a[@href='https://capmation.com/services/']")
	@CacheLookup
	WebElement linkServices;

	//Data Analytics/Data Modernization Link
	@FindBy(xpath="//div//a[@href='#data-analytics-data-warehousing']")
	@CacheLookup
	WebElement linkDataAnalytics;

	//Contact Link
	@FindBy(xpath="//header//a[@href='https://capmation.com/contact/']")
	@CacheLookup
	WebElement linkContact;

	//Text Fields
	//Name Text Field
	@FindBy(xpath="//input[@name='input_1']")
	@CacheLookup
	WebElement fieldName;

	//Email Text Field
	@FindBy(xpath="//input[@name='input_3']")
	@CacheLookup
	WebElement fieldEmail;

	//Phone Text Field
	@FindBy(xpath="//input[@name='input_2']")
	@CacheLookup
	WebElement fieldPhone;

	//Verification Question
	@FindBy(xpath="//select[@name='input_6']")
	@CacheLookup
	WebElement ddQuestion;

	//Verification Answer = Eighteen
	@FindBy(xpath="//option[@value='Eighteen']")
	@CacheLookup
	WebElement ddAnswer;

	//Message Text Box
	@FindBy(xpath="//div//textarea[@name='input_4']")
	@CacheLookup
	WebElement textBox;

	//Recaptcha CheckBox
	@FindBy(xpath="//span//div[@class='recaptcha-checkbox-border']")
	@CacheLookup
	WebElement chckBoxRecaptcha;

	//Checked Recaptcha
	@FindBy(xpath="//span//div[@style='display: none; animation-play-state: running; opacity: 1;']")
	@CacheLookup
	WebElement checkedRecaptcha;

	//Button Submit
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement btnSubmit;

	WebElementFunctions func = new WebElementFunctions();

	//Verify if capmation logo is displayed
	public boolean logoDisplayed(){
		return func.waitElementDisplayed(capmationLogo, ldriver);
	}

	//click services tab
	public void clickServicesLink(){
		linkServices.click();
	}

	//click services tab
	public void clickContactLink(){
		linkContact.click();
	}

	//Verify that Data Analytics/Data Modernization link is displayed
	public boolean linkDataAnalyticsDisplayed(){
		return func.waitElementDisplayed(linkDataAnalytics, ldriver);
	}

	//Verify that Name Field is displayed
	public boolean nameFieldDisplayed(){
		return func.waitElementDisplayed(fieldName, ldriver);
	}

	//Get link address from Data Analytics Link
	public String getLinkFromDataAnalytics(){
		return linkDataAnalytics.getAttribute("href");
	}

	//Scroll To Name Field
	public void scrollToNameField(){
		((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", fieldName);
	}

	//Set Name
	public void setName(String name){
		fieldName.clear();
		fieldName.sendKeys(name);
	}

	//Get name entered on name field
	public String getName(){
		return fieldName.getAttribute("value");
	}

	//Set Email
	public void setEmail(String email){
		fieldEmail.clear();
		fieldEmail.sendKeys(email);
	}

	//Get email entered on email field
	public String getEmail(){
		return fieldEmail.getAttribute("value");
	}

	//Set Phone
	public void setPhone(String phone){
		fieldPhone.clear();
		fieldPhone.sendKeys(phone);
	}

	//Get phone entered on phone field
	public String getPhoneNum(){
		return fieldPhone.getAttribute("value");
	}

	//Select Verification Answer
	public void selectVerificationAnswer(){
		ddQuestion.click();
		ddAnswer.click();
	}

	//Scroll to lets get started
	public void scrollToCapmationLogo(){
		((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", capmationLogo);
	}

	//Scroll to lets get started
	public void scrollToLetsGetStarted(){
		((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", getStartedLogo);
	}

	//Scroll to Data Analytics/DAta Modernization
	public void scrollToDataAnalytics(){
		((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", linkDataAnalytics);
	}

	//Scroll to Recaptcha
	public void scrollToRecaptcha(){
		((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", chckBoxRecaptcha);
	}

	//Click Recaptcha
	public void checkRecaptchaVerification(){
		chckBoxRecaptcha.click();
		func.waitElementDisplayed(checkedRecaptcha, ldriver);
	}





	//xpath://span//div[@style='display: none; animation-play-state: running; opacity: 1;']

}
