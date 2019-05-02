package com.selenium.facebook.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.common.TopMenus;

public class BaseClass {

	public WebDriver driver;
	public TopMenus menu;
	public ExtentTest test;
	
	public BaseClass(WebDriver _driver, ExtentTest test)
	{
		this.driver = _driver;
		this.test = test;
		menu = new TopMenus(_driver, test);
		PageFactory.initElements(driver, menu);
	}
	
	public void inputText(WebElement element, String string)
	{
		element.sendKeys(string);
	}
	
	public void clickElement(WebElement element)
	{
		element.click();
	}
	
	public void takeScreenshot()
	{
		Date currentDateTime = new Date();
		String screenshotName = currentDateTime.toString().replace(":", "_").replace(" ", "_") + ".png";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destiFile = System.getProperty("user.dir") + "//screenshots//" + screenshotName;
		try {
			FileUtils.copyFile(sourceFile, new File(destiFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(destiFile));
	}
	
	public TopMenus getMenu()
	{
		return menu;
	}
}
