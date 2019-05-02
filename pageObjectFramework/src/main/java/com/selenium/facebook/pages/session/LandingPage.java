package com.selenium.facebook.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.selenium.facebook.base.BaseClass;
import com.selenium.facebook.utility.AppConstants;

public class LandingPage extends BaseClass{

	@FindBy(xpath=AppConstants.PROFILE_LINK)
	WebElement profileLink;
	
	public LandingPage(WebDriver _driver, ExtentTest test)
	{
		super(_driver, test);
	}
	
	public LandingPage quitApplication() throws Exception
	{
		//profileLink.click();
		
		driver.quit();
		LandingPage landingPage = new LandingPage(driver, test);		
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}
}
