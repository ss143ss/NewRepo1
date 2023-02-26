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
 
	}
=======
		
		 


		driver.get("https://www.amazon.com");  
//Resolve Conflicting
		}
>>>>>>> 86fca9a9cdba15b8329a1be90e029754764c7792






}
