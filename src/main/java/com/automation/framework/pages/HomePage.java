package com.automation.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.elements.InputElement;

public class HomePage {
	WebDriver driver;
	InputElement iElement;

	@FindBy(id = "nav-link-accountList")
	WebElement signInLink;

	@FindBy(className = "nav-action-signin-button")
	WebElement signInButton;

	@FindBy(id = "nav-signin-tooltip")
	WebElement signInTooltip;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		iElement = new InputElement(driver);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void navigateToSignInPage() {
		iElement.waitUntilElementVisible(signInTooltip);
		iElement.mouseOver(signInLink);
		iElement.click(signInButton);
	}
}
