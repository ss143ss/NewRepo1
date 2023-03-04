package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.Utility.*;
public class TestClass extends GenericMethods {

	WebDriver driver;
	@Test(invocationCount = 0,enabled = false)
	public void TC1() {

		browserType("Chrome");
		driver.get("https://www.google.com"); 
	}
	
	@Test(invocationCount = 1)
	public void TC2() {
		browserType("Firefox");
		driver.get("https://www.amazon.com"); 
	}

}

