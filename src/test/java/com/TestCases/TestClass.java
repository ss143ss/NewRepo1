package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {

	@Test
	public void TC1() {
		WebDriverManager.chromedriver().setup();;
		WebDriver driver = new ChromeDriver();
<<<<<<< HEAD
		driver.get("https://www.amazon.com"); 
		//////////////////////////cdcptfgnmc
		 
=======

		driver.get("https://www.amazon.com");  //dssds
>>>>>>> c53ba4871ebd323e0ba497e306c7365f6c83479b
	}






}
