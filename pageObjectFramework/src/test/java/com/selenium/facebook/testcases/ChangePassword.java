package com.selenium.facebook.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pages.LaunchPage;
import com.selenium.facebook.pages.LoginPage;
import com.selenium.facebook.pages.session.LandingPage;
import com.selenium.facebook.utility.BrowserFactory;
import com.selenium.facebook.utility.DataUtil;

public class ChangePassword extends BrowserFactory {

	String testCaseName = "ChangePassword";
	
	@Test(dataProvider = "getData")
	public void changePasswordTest(Hashtable<String, String> table)
	{
		test = extent.startTest("Change Password Test");
		
		if(table.get("Runmode").equalsIgnoreCase("N"))
		{
			test = extent.startTest("Skipping the testcase as RUNMODE: " +table.get("Runmode"));
			throw new SkipException("Skipping the testcase as RUNMODE: " +table.get("Runmode"));
		}
		test = extent.startTest("Test started");
		initBrowser("chrome");
		test.log(LogStatus.INFO, "Browser opened");
		LaunchPage launchPage = new LaunchPage(driver, test);
		PageFactory.initElements(driver, launchPage);		
		LoginPage loginPage = launchPage.gotoLoginPage();
		loginPage.takeScreenshot();
		test.log(LogStatus.INFO, "Logging in");
		Object page = loginPage.doLogin(table.get("Username"), table.get("OldPassword"));
		
		if(page instanceof LoginPage)
		{
			loginPage.takeScreenshot();
			failTestCase("Could not Login");
		}
		
		LandingPage landingPage = (LandingPage)page;
		landingPage.getMenu().gotoSetting();
		test.log(LogStatus.PASS, "Test Passed");
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
	

	@DataProvider(name = "getData")
	public Object[][] readData() throws IOException
	{
		return DataUtil.getData(excelReader, testCaseName);
	}
}
