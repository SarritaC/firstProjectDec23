package com.codefios.ebilling.smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	static WebDriver driver;
	static int abc;
	
	
	public static void main(String[] args) {
		
		setUp();
		System.out.println(abc);
		loginTest();
		tearDown();
		
		setUp();
		negetiveLoginTest();
		tearDown();
		
	}

	public static void setUp() {
		abc = 5;
		// Set System property
		// Absolute path
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shihab\\Selenium_Oct23\\crm\\driver\\chromedriver.exe");

		// Relative path
//		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

		// Launch browser
		//object variable 
		driver = new ChromeDriver();
		
		// delete cookies
		driver.manage().deleteAllCookies();

		// go to the website
		driver.get("https://codefios.com/ebilling/login");

		// max window
		driver.manage().window().maximize();
	}

	public static void tearDown() {
		driver.close();
	}

	public static void loginTest() {
		// identify element and perform action
		driver.findElement(By.id("user_name")).sendKeys("demo@codefios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.id("login_submit")).click();
	}

	public static void negetiveLoginTest() {
		// identify element and perform action
		driver.findElement(By.id("user_name")).sendKeys("demo@codefios.com");
		driver.findElement(By.id("password")).sendKeys("abc1234");
		driver.findElement(By.id("login_submit")).click();

	}

}