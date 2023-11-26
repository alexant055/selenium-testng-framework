package com.automation.framework.utils.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("TestNG Automation - Report");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Blog Name", "Test Automation House");
		extentReports.setSystemInfo("Author", "Alexander, Antony");
		return extentReports;
	}
}
