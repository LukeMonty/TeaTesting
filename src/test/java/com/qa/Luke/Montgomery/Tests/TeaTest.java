package com.qa.Luke.Montgomery.Tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.qa.Luke.Montgomery.Constants;
import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")
public class TeaTest {

	static ExtentReports reports;

	@BeforeClass
	public static void setUp() {
		reports = new ExtentReports(Constants.REPORT_FILEPATH, true);
	}

	@AfterClass
	public static void tearDown() {
		reports.flush();
	}

}