package com.codefios.ebilling.smoke;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_Junit {

	WebDriver driver;


	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class!!");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After Class!!");
	}

	@Before
	public void setUp() {
		System.out.println("Before");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		System.out.println("After");
		driver.close();
	}

	@Test
	public void loginTest() {
		System.out.println("Test 1");
		driver.findElement(By.id("user_name")).sendKeys("demo@codefios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.id("login_submit")).click();
	}

	@Test
	public void negativeTest() {
		System.out.println("Test 2");
		driver.findElement(By.id("user_name")).sendKeys("demo@codefios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.id("login_submit1")).click();
	}

}
