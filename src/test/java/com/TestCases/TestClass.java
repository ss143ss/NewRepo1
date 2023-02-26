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
	}//eeeeeeeeeeee1234
=======
	}//e
>>>>>>> e038e1ab8f2e4a984df7b5d8a12db26c34cd8f96

//loal changesfdffdf
}
