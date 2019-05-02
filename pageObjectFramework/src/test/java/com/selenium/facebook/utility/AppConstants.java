package com.selenium.facebook.utility;

public class AppConstants {
	
	// Application Credentials
	public static final String APP_USERNAME = "sanjai1184@gmail.com";
	public static final String APP_PASSWORD = "xxxxxxxxxxxx";
	
	// Home Page URL
	public static final String BASE_URL = "https://www.facebook.com/";
	
	// Browser Path	
	public static final String CHROME_DRIVER = "E:\\jarFiles\\chromedriver.exe";
	public static final String IE_DRIVER = "E:\\jarFiles\\IEDriverServer.exe";
	public static final String FIREFOX_DRIVER = "E:\\jarFiles\\geckodriver.exe";

	public static final String DATA_XLS_LOCATION = "System.getProperty(user.dir)//excelData//data.xlsx";
	
	// Locators Path	
	// Login Page
	public static final String LOGIN_USERNAME = "email";
	public static final String LOGIN_PASSWORD = "pass";
	public static final String LOGIN_SUBMIT = "//*[@value='Log In']";
	
	// Profile Page
	public static final String PROFILE_LINK = "//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span";
}
