package com.automation.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.automation.framework.pages.PageManager;
import com.automation.framework.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public PageManager pageManager;

	private static Properties properties;

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeSuite
	public void beforeSuiteSetup() {
		properties = new Properties();
		// Read properties
		try {
			FileInputStream fis = new FileInputStream(Constants.PROPERTIES_PATH);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String browser = properties.getProperty("browser");

		// Decide browser driver
		switch (browser) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			driver = new ChromeDriver(options);
		}

		// Set driver default timeouts and properties
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	}

	@BeforeMethod
	public void testSetup() {
		pageManager = new PageManager(driver);
		// Launch application
		driver.get(properties.getProperty("applicationUrl"));
	}

	@AfterMethod
	public void testTearDown(ITestResult result) {
		driver.manage().deleteAllCookies();
	}

	@AfterSuite
	public void tearDownAfterSuite() {
		driver.close();
		driver.quit();
	}
}
