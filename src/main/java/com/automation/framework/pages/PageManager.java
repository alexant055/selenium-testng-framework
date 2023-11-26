package com.automation.framework.pages;

import org.openqa.selenium.WebDriver;

public class PageManager {
	WebDriver driver;
	private HomePage homePage;
	private SignInPage signInPage;

	public PageManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage != null) ? homePage : new HomePage(driver);
	}

	public SignInPage getSignInPage() {
		return (signInPage != null) ? signInPage : new SignInPage(driver);
	}
}
