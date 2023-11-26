package com.automation.framework.elements;

import org.openqa.selenium.WebDriver;

public class InputElement extends EWrapper {
	WebDriver driver;

	public InputElement(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
