package com.selenium.facebook.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pages.LaunchPage;
import com.selenium.facebook.pages.LoginPage;
import com.selenium.facebook.pages.session.LandingPage;
import com.selenium.facebook.utility.BrowserFactory;

public class LoginTest extends BrowserFactory {
	
	@Test
	public void doLogin() throws Exception
	{		
		test = extent.startTest("Login test started");
		test.log(LogStatus.INFO, "Browser opened");
		initBrowser("chrome");		
		LaunchPage launchPage = new LaunchPage(driver, test);
		PageFactory.initElements(driver, launchPage);		
		LoginPage loginPage = launchPage.gotoLoginPage();
		test.log(LogStatus.INFO, "Logging in");
		Object page = loginPage.doLogin();
		test.log(LogStatus.PASS, "Test Passed");
		if(page instanceof LoginPage)
			Assert.fail("Login Failed");
		else
			System.out.println("Seccess");
		
		LandingPage landingPage = (LandingPage)page;		
		landingPage.quitApplication();
	}
	
	@AfterMethod
	public void flushReport()
	{
		if(extent != null) 
		{
			extent.endTest(test);
			extent.flush();
		}
	}
}
