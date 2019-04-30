package com.selenium.facebook.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.facebook.pages.LaunchPage;
import com.selenium.facebook.pages.LoginPage;
import com.selenium.facebook.pages.session.LandingPage;
import com.selenium.facebook.utility.BrowserFactory;

public class ProfileTest extends BrowserFactory{

	@Test
	public void testProfile() throws Exception
	{
		initBrowser("chrome");
		LaunchPage launchPage = new LaunchPage(driver, test);
		PageFactory.initElements(driver, launchPage);
		LoginPage loginPage = launchPage.gotoLoginPage();
		Object page = loginPage.doLogin();
		if(page instanceof LoginPage)
			Assert.fail("Login Failed");
		else
			System.out.println("Seccess");
		
		LandingPage landingPage = (LandingPage)page;		
		landingPage.quitApplication();
	}
	
	
}
