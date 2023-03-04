package com.Utility;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
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
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else { driver =null;}

	}
	
	public void clickOutsidepage()
	{
		Actions act= new Actions(driver);
		act.moveByOffset(0, 0).click().build().perform();
		
	}
	
	public static FirefoxOptions FirefoxOpions() {
		FirefoxOptions opt = new FirefoxOptions();
		Proxy proxy = new Proxy();
		proxy.setProxyType(ProxyType.AUTODETECT);
		opt.setProxy(proxy);
		opt.setCapability("marionette", true);
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.cache.disk.enable", false);
		return opt;
		
	}
	
	public void clear(WebElement ele, String elementName) {
		
		try{
			ele.clear();
		}catch(Exception s) {
			// need to implement
		}
	}
	
	public void ScrollToElement(WebElement ele, String ElementName) {
		Actions act = new Actions(driver);
		act.moveToElement(ele);
	}
	
	public void getWindowMaxize() {
		driver.manage().window().maximize();
	}
	
	public void resizeWindow(int x,int y) {
		Dimension dimension = new Dimension(x,y);
		driver.manage().window().setSize(dimension);
	}
		
	public void clearText(WebElement ele) {
		ele.clear();
	}
	
	public void clearTextKey(WebElement ele) {
		//
	}
	
	public void switchToWindow(String windowToSwitch) {
		Set<String> windows = driver.getWindowHandles();
		boolean val= false;
		if(windows.size()>1	) {
			for(String wind:windows) {
				if(wind.equalsIgnoreCase(windowToSwitch)) {
					driver.switchTo().window(windowToSwitch);
					val= true;
					logger.info("Switched to Window with Title : "+driver.getTitle());
					break;
				}
			}
		}
		if(val==false) {
			System.out.println("No Multiple Windows Exists");
			logger.info("No Window available.");
			failTest("No Window available.");
		}
	}
	
	public boolean verifyText(WebElement ele, String value) {
		 return (ele.getText().equalsIgnoreCase(value));
	}
	
	public void SwitchToFrame(String SwitchBy) {
		switch(SwitchBy){
//		case "
	}
		   		
	}
	
	public void windowRefresh() {
		driver.navigate().refresh();
	}
	
	public String getWindowTitle() {
		return driver.getTitle();
	}
	
	public boolean validateErrorMsgText(WebElement errorElement,String expectedErrorMsg) {
		boolean val = false;
		try {
			val = errorElement.getText().equalsIgnoreCase(expectedErrorMsg);
		}catch(Exception e) {
			logger.info("E..");
		}
		return val;
	}
	
	public String StringToSubString(String str,int indexFrom,int IndexTo) {
		if(str.length()>0 && indexFrom < IndexTo) {
			return str.substring(indexFrom, IndexTo);
		}
		else {
			return null;
		}
	}
	
	public int stringToIntegerValue(String str) {
		return Integer.parseInt(str);
	}
}
