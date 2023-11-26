package com.automation.framework.tests;

import static com.automation.framework.utils.report.ExtentTestManager.startTest;
import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.automation.framework.TestBase;

public class HomePageTest extends TestBase {

	@Test(description = "Verify home page loads")
	public void verifyHomePageLoads(Method method) {
		// Extent report start test
		startTest(method.getName(), "Verify home page loads");
		String pageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		// assert home page title
		assertEquals(pageManager.getHomePage().getTitle(), pageTitle);

	}

	@Test(description = "Verify sign-in page loads when clicks sign-in button.")
	public void verifyAbleToNavigateToSignInPage(Method method) {
		// Extent report start test
		startTest(method.getName(), "Verify sign-in page loads when clicks sign-in button.");
		pageManager.getHomePage().navigateToSignInPage();
		// assert login page title
		assertEquals(pageManager.getSignInPage().getTitle(), "Amazon Sign In");
	}
}
