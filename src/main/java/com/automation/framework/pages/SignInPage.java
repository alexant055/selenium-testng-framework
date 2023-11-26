package com.automation.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.framework.elements.InputElement;

public class SignInPage {
	WebDriver driver;
	InputElement iElement;

	@FindBy(id = "ap_email")
	WebElement emailInput;
	@FindBy(id = "ab-sign-in-ingress-link")
	WebElement businessLink;
	@FindBy(id = "createAccountSubmit")
	WebElement createAccountButton;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		iElement = new InputElement(driver);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void enterEmail() {
		iElement.enterText(emailInput, "alexander.anto@outlook.com");
	}
}
