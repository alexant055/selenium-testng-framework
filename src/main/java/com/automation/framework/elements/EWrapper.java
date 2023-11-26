package com.automation.framework.elements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.framework.utils.Constants;

public abstract class EWrapper {
	public static Actions actions;
	public static WebDriverWait wait;

	public EWrapper(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DRIVER_WAIT));
		actions = new Actions(driver);
	}

	public void click(WebElement element) {
		element.click();
	}

	public void focus(WebElement element) {
		element.sendKeys("");
	}

	public void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}

	public String getValue(WebElement element) {
		return element.getText();
	}

	public void waitUntilElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilElementDisappear(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void mouseOver(WebElement element) {
		actions.moveToElement(element).perform();
	}
}
