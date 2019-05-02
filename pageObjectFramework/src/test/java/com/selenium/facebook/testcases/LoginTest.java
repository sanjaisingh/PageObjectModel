package com.selenium.facebook.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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

public class LoginTest extends BrowserFactory {
	
	String testCaseName = "Login";
	
	@Test(dataProvider="getData")
	public void setupLogin(Hashtable<String, String> table) throws Exception
	{	
		if(table.get("Runmode").equalsIgnoreCase("N"))
		{
			test = extent.startTest("Skipping the testcase as RUNMODE: " +table.get("Runmode"));
			throw new SkipException("Skipping the testcase as RUNMODE: " +table.get("Runmode"));
		}
		test = extent.startTest("Login test started");
		test.log(LogStatus.INFO, "Browser opened");
		initBrowser("chrome");		
		LaunchPage launchPage = new LaunchPage(driver, test);
		PageFactory.initElements(driver, launchPage);		
		LoginPage loginPage = launchPage.gotoLoginPage();
		loginPage.takeScreenshot();
		test.log(LogStatus.INFO, "Logging in");
		Object page = loginPage.doLogin(table.get("Username"), table.get("Password"));
		test.log(LogStatus.PASS, "Test Passed");
		String actualResult = "";
		if(page instanceof LandingPage)
			actualResult = "Success";
		else
		{
			loginPage.takeScreenshot();
			actualResult = "Failed";
		}
		Assert.assertEquals(actualResult, table.get("expectedResult"));
		test.log(LogStatus.INFO, "Success");
		LandingPage landingPage = (LandingPage)page;
		landingPage.takeScreenshot();		
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
	
	@DataProvider(name = "getData")
	public Object[][] readData() throws IOException
	{
		return DataUtil.getData(excelReader, testCaseName);
	}
}
