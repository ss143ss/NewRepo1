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
		driver.get("https://www.amazon.com");
<<<<<<< HEAD
		//Making changes in Local and pushing
	}  vsdvsvd
=======

>>>>>>> aa891fa745cfe79226b2db92a4a6748a12f0ff1a
}
