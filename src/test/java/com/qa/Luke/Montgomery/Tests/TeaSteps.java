package com.qa.Luke.Montgomery.Tests;

import static org.junit.Assert.assertEquals;

import java.awt.Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.Luke.Montgomery.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.CheckoutPage;
import Pages.Home;
import Pages.MenuPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TeaSteps {

	WebDriver driver;

	ExtentTest test;

	MenuPage menu;
	Home home;
	CheckoutPage checkout;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER_FILEPATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		test = TeaTest.reports.startTest("Navigate the website");
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("^the correct web address$")
	public void the_correct_web_address() {
		driver.get(Constants.URL);
		test.log(LogStatus.INFO, "Go to URL " + Constants.URL);
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {
		home = PageFactory.initElements(driver, Home.class);
		home.clickMenu();
		test.log(LogStatus.INFO, "Go to Menu page");

	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
		menu = PageFactory.initElements(driver, MenuPage.class);
		String expected = "Green Tea";

		if (!expected.equals(menu.checkGreenTeaTitle())) {
			test.log(LogStatus.FAIL, "Navigated to the wrong page");
		} else {
			test.log(LogStatus.PASS, "Success: Gone to the menu page");
			assertEquals("Green Tea", menu.checkGreenTeaTitle());
		}
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
		home = PageFactory.initElements(driver, Home.class);
		home.clickMenu();
		test.log(LogStatus.INFO, "Go to Menu page");
		menu = PageFactory.initElements(driver, MenuPage.class);
		menu.goToCheckOut();
		test.log(LogStatus.INFO, "Navigate to the checkout");
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {
		checkout = PageFactory.initElements(driver, CheckoutPage.class);
		String expected = "Pay with Credit Card or Log In";

		if (!expected.equals(checkout.checkTitle())) {
			test.log(LogStatus.FAIL, "Navigated to the wrong page");
		} else {
			test.log(LogStatus.PASS, "Success: Gone to the checkout page");
			assertEquals("Pay with Credit Card or Log In", checkout.checkTitle());
		}
	}

}
