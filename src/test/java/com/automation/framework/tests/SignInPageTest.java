package com.automation.framework.tests;

import static com.automation.framework.utils.report.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.automation.framework.TestBase;

public class SignInPageTest extends TestBase {

	@Test(description = "Verify user able to enter email in sign-in page.")
	public void verifyUserAbleEnterEmail(Method method) {
		startTest(method.getName(), "Verify user able to enter email in sign-in page.");
		pageManager.getHomePage().navigateToSignInPage();
		pageManager.getSignInPage().enterEmail();
	}
}
