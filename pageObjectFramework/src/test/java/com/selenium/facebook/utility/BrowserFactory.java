package com.selenium.facebook.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BrowserFactory {
	
	public Xls_Reader excelReader = new Xls_Reader(System.getProperty("user.dir")+"//excelData//data.xlsx");	
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	public WebDriver driver;
	public void initBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", AppConstants.CHROME_DRIVER);
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", AppConstants.IE_DRIVER);
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", AppConstants.FIREFOX_DRIVER);
			driver = new FirefoxDriver();
		}		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void failTestCase(String failMessage)
	{
		test.log(LogStatus.INFO, failMessage);
		Assert.fail(failMessage);
	}
}
