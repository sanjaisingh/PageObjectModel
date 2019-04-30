package com.selenium.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.base.BaseClass;
import com.selenium.facebook.pages.session.LandingPage;
import com.selenium.facebook.utility.AppConstants;

public class LoginPage extends BaseClass{

	@FindBy(id=AppConstants.LOGIN_USERNAME)
	public WebElement txtUsername;
	
	@FindBy(id=AppConstants.LOGIN_PASSWORD)
	public WebElement txtPassord;
	
	@FindBy(xpath=AppConstants.LOGIN_SUBMIT)
	public WebElement btnLogin;
	
	public LoginPage(WebDriver _driver, ExtentTest test)
	{
		super(_driver, test);
	}
	
	public Object doLogin()
	{
		boolean loginSuccess = true;
		test.log(LogStatus.INFO, "Entering Login Credentials");		
		inputText(txtUsername, AppConstants.APP_USERNAME);
		inputText(txtPassord, AppConstants.APP_PASSWORD);
		test.log(LogStatus.INFO, "Clicking on Login button");
		clickElement(btnLogin);
		test.log(LogStatus.PASS, "Login successfully");
		
		if(loginSuccess)
		{
			LandingPage landingPage = new LandingPage(driver, test);		
			PageFactory.initElements(driver, landingPage);
			return landingPage;
		}
		else 
		{
			LoginPage loginPage = new LoginPage(driver, test);		
			PageFactory.initElements(driver, loginPage);
			return loginPage;
		}
	}
}
