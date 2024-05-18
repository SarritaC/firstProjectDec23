package com.codefios.ebilling.smoke;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddNewAccount {

	static WebDriver driver;

	private static void login(String username, String password) {
		System.out.println("login method");
		driver.findElement(By.id("user_name")).sendKeys("demo@codefios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.id("login_submit")).click();
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class!!");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After Class!!");
	}

	@Before // setup
	public void setUp() {
		System.out.println("Before");
		// Set system property
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		// launch browser
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		// go to website
		driver.get("https://codefios.com/ebilling/login");
		// maximize window
		driver.manage().window().maximize();
	}

	@After // close the browser
	public void tearDown() {
		System.out.println("After");
		driver.close();
	}

	@Test
	public void loginTest() throws InterruptedException {
		System.out.println("Test 1");

		login("demo@codefios.com", "abc123");

		// List Account
		driver.findElement(By.linkText("List Accounts")).click();

		// Add Account
		driver.findElement(By.xpath("//button[text()='Add Account']")).click();
		Thread.sleep(2000);

		// Account Name
		driver.findElement(By.id("account_name")).sendKeys("December2023");

		// Description
		driver.findElement(By.id("description")).sendKeys("Selenium");

		// Balance
		driver.findElement(By.id("balance")).sendKeys("5000.00");

		// Account number
		driver.findElement(By.id("account_number")).sendKeys("4252024");

		// Contact Person
		driver.findElement(By.id("contact_person")).sendKeys("TechFios");

		// Save button
		driver.findElement(By.id("accountSave")).click();
		System.out.println("saved");
		Thread.sleep(2000);
	}

}
