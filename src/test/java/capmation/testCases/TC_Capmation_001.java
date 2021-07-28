package capmation.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import capmation.common.CommonFunctions;
import capmation.pageObjects.CapmationPage;
import capmation.pageObjects.GoogleSearchPage;

public class TC_Capmation_001 extends BaseClass {
	
	//Test if page is successfully redirected to Services Page when Service Link is clicked
	@Test(priority = 0)
	public void testClickServicesLinkFunctionality(){

		CommonFunctions cf = new CommonFunctions();
		CapmationPage cp = new CapmationPage(driver);

		cf.navigateToCapmationPage();
		
		logger.info("SUCCESSFULLY NAVIGATED TO CAPMATION WEBSITE");

		cp.scrollToLetsGetStarted();
		logger.info("Scroll to Bottom of Page");

		cp.scrollToCapmationLogo();
		logger.info("Scroll to Top of Page");

		cp.clickServicesLink();
		logger.info("Clicked Services Tab");

		//Verify that Data Analytics Tab Is Displayed
		try{
			Assert.assertTrue(cp.linkDataAnalyticsDisplayed());
			logger.info("Successfully redirected to Services Page... Data Analytics/Data Modernization Link is Displayed");
		}catch (AssertionError ex){
			logger.info("Failed to navigate to Services Page");
			throw new AssertionError(ex);
		}
	}

	//Test that click on Contact Link redirects to Contact Page by checking if name field is displayed
	@Test(priority = 1)
	public void testClickContactLinkFunctionality(){

		CapmationPage cp = new CapmationPage(driver);

		cp.clickContactLink();
		logger.info("Clicked Contact Link");

		cp.scrollToNameField();
		logger.info("Scroll to View Name Field");

		//Verify Successfully redirected to contact page by checking if name field is displayed
		try{
			Assert.assertTrue(cp.nameFieldDisplayed());
			logger.info("Successfully redirected to Contact Page... Name Field is Displayed");
		}catch (AssertionError ex){
			logger.info("Failed to navigate to Contact Page");
			throw new AssertionError(ex);
		}
	}

	//Test if name entered into name field matches name displayed on field
	@Test(priority = 2)
	public void testVerifyTextEnteredInNameField(){

		CapmationPage cp = new CapmationPage(driver);

		cp.setName(name);
		logger.info("Name Entered: " + name);

		//Verify name on text field matches name entered
		try{
			Assert.assertEquals(name, cp.getName());
			logger.info("Name Entered: " + name + ", matches the name displayed on text field: " + cp.getName());
		}catch (AssertionError ex){
			logger.info("Name Displayed: " + cp.getName() + ", doesn't match the name entered: " + name);
			throw new AssertionError(ex);
		}
	}

	//Test if email entered into email field matches email displayed on field
	@Test(priority = 3)
	public void testVerifyTextEnteredInEmailField(){

		CapmationPage cp = new CapmationPage(driver);

		cp.setEmail(email);
		logger.info("Email Entered: " + email);

		//Verify email on text field matches email entered
		try{
			Assert.assertEquals(email, cp.getEmail());
			logger.info("Email Entered: " + email + ", matches the email displayed on text field: " + cp.getEmail());
		}catch (AssertionError ex){
			logger.info("Email Displayed: " + cp.getEmail() + ", doesn't match the email entered: " + email);
			throw new AssertionError(ex);
		}
	}

	//Test if phone entered into phone field matches phone displayed on field
	@Test(priority = 3)
	public void testVerifyTextEnteredInPhoneField(){

		CapmationPage cp = new CapmationPage(driver);

		cp.setPhone(phoneNum);
		logger.info("Phone Entered: " + phoneNum);

		//Verify phone on text field matches phone entered
		try{
			Assert.assertEquals(phoneNum, cp.getPhoneNum());
			logger.info("Phone number Entered: " + phoneNum + ", matches the phone number displayed on text field: " + cp.getPhoneNum());
		}catch (AssertionError ex){
			logger.info("Phone number Displayed: " + cp.getPhoneNum() + ", doesn't match the phone number entered: " + phoneNum);
			throw new AssertionError(ex);
		}
	}
	

		
}
