package com.selenium.facebook.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class TopMenus {
	
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath="//*[@id='userNavigationLabel']")
	WebElement accountSettingMenu;
	
	@FindBy(xpath="//span[text()='Settings']")
	WebElement settingMenu;
	
	public TopMenus(WebDriver _driver, ExtentTest test)
	{
		this.driver = _driver;
		this.test = test;
	}
	
	public void logoutApplication()
	{
		
	}
	
	public void gotoSetting()
	{
		accountSettingMenu.click();
		settingMenu.click();
	}

}
