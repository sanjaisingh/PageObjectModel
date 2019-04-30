package com.selenium.facebook.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.base.BaseClass;
import com.selenium.facebook.utility.AppConstants;

public class LaunchPage extends BaseClass {

	public LaunchPage(WebDriver _driver, ExtentTest test)
	{
		super(_driver, test);
	}
	
	public LoginPage gotoLoginPage()
	{
		test.log(LogStatus.INFO, "Opening URL:- " +AppConstants.BASE_URL);
		driver.get(AppConstants.BASE_URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.PASS, "URL opened");
		LoginPage loginPage = new LoginPage(driver, test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}
}
