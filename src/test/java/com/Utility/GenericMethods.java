package com.Utility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericMethods extends Reports {

	public static int screenCount;
	
	public static void click(WebElement element, String ButtonName) {
		explicityWait();
		elementToBeClick(element);
	}
		
	public static void explicityWait() {
		
	}
	
	public static void elementToBeClick(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2000);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Exception e) {
//			failTest("Waited for 200 Seconds "+element +e.getMessage());
		}
		
	}
	
	public static void failTest(String message) {
		logger.log(Status.FAIL, message);
		logger.info("Current Page :"+driver.getTitle());
		takescreenshot();
//		userlogout();
		Assert.fail();
		
	}
	
	public static void takescreenshot() {
		screenCount++;
		String path = "./ExtentReport/Screenshot/"+screenCount+".jpg";
		getScreen(path);
		String screenLocation ="Screenshots/"+screenCount + ".jpg";
//		logger.fail(new LoggingLink(screenlocation));
	}	
	public static void failTest(String message,Exception e) {
		logger.log(Status.FAIL, message);
		logger.info("Current Page :"+driver.getTitle());
		takescreenshot();
//		userlogout();
		Assert.fail(message,e);
	}
	
	public static void getScreen(String path) {
		try {
			File destination= new File(path);
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, destination.getAbsoluteFile());
		}catch(Exception e) {
			
		}
	}
	
	public static void browserType(String browser) {

		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();;
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver();
		}
		else if(browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else { driver =null;}

	}
}
