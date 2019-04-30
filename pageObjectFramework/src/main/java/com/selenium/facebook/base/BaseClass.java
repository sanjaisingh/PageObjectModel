package com.selenium.facebook.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.selenium.facebook.common.TopMenus;

public class BaseClass {

	public WebDriver driver;
	public TopMenus menu;
	public ExtentTest test;
	
	public BaseClass(WebDriver _driver, ExtentTest test)
	{
		this.driver = _driver;
		this.test = test;
		menu = PageFactory.initElements(_driver, TopMenus.class);
	}
	
	public void inputText(WebElement element, String string)
	{
		element.sendKeys(string);
	}
	
	public void clickElement(WebElement element)
	{
		element.click();
	}
	
	public TopMenus getMenu()
	{
		return menu;
	}
}
