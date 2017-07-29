package ecommerce.backbase.step_definitions;

import static org.testng.AssertJUnit.assertEquals;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.*;
import ecommerce.backbase.helpers.configProperty;
import ecommerce.backbase.helpers.genericFunctions;
import ecommerce.backbase.pageobjects.*;

public class DBStepDefs {
	public static WebDriver driver;
	public configProperty config;
	public DBHomePage Homepage;
	public DBCreatePage Createpage;


	public DBStepDefs() {
		driver = CucumberHooks.driver;
		Homepage = new DBHomePage(driver);
		Createpage = new DBCreatePage(driver);
		config = new configProperty();
	}

	@Given("^I open the page url \"([^\"]*)\"$")
	public void open_url(String URL) throws Throwable {
		driver.get(config.getPageURL("computer-db"));
	}

	@Then("^I validate the \"([^\"]*)\" in (home|create|filter) page$")
	public void validate_assertions(String val, String page) throws Throwable {

		switch (val) {
		case "page title":
			assertEquals(config.getPageTitle("HomepageTitle"), driver.getTitle());

			if(page.equals("home")) {
				assertEquals(config.getPageURL("computer-db"), driver.getCurrentUrl());
			}else if (page.equals("create")) {
				assertEquals(config.getPageURL("add-computer"), driver.getCurrentUrl());
			}
			break;

		case "newly created computer":
			assertTrue(genericFunctions.getElementText(Homepage.ALERT_CREATE).contains("has been created"));
			genericFunctions.sendKeys(Homepage.SEARCH_COMPUTER, config.getComputerName("computer-name"));
			genericFunctions.clickElement(Homepage.SUBMIT_SEARCH);
			assertTrue(genericFunctions.getTextofFirstElement(Homepage.COMPUTER_LIST).contains(config.getComputerName("computer-name")));
			break;

		case "updated computer details":
			assertTrue(genericFunctions.getElementText(Homepage.ALERT_CREATE).contains("has been updated"));
			genericFunctions.sendKeys(Homepage.SEARCH_COMPUTER, config.getComputerName("updated-computer-name"));
			genericFunctions.clickElement(Homepage.SUBMIT_SEARCH);
			assertTrue(genericFunctions.getTextofFirstElement(Homepage.COMPUTER_LIST).contains(config.getComputerName("updated-computer-name")));
			break;

		case "deleted computer details":
			assertTrue(genericFunctions.getElementText(Homepage.ALERT_CREATE).contains("has been deleted"));
			genericFunctions.sendKeys(Homepage.SEARCH_COMPUTER, config.getComputerName("computer-name"));
			genericFunctions.clickElement(Homepage.SUBMIT_SEARCH);
			assertEquals(genericFunctions.elementSize(Homepage.COMPUTER_LIST), 0);
			break;

		default:
			throw new IllegalArgumentException("case not matching");
		}
	}

	@When("^I click on \"([^\"]*)\" (link|button) from the (home|create) page$")
	public void click_on_button(String value, String event, String page) throws Throwable {
		if(page.equals("home")) {
			Homepage.click_element(value);
		}else if (page.equals("create")) {
			Createpage.click_element(value);
		}
	}

	@And("^I enter \"([^\"]*)\" in the \"([^\"]*)\" field$")
	public void enter_value_in_field(String value, String field) throws Throwable {
		Createpage.insert_value(value, field);
	}

	@When("^I create a new machine$")
	public void create_new_machine() throws Throwable {
		Createpage.insert_value("custom_name", "Computer name");
		Createpage.insert_value(config.getComputerName("introduced-date"), "Introduced date");
		Createpage.insert_value(config.getComputerName("discontinued-date"), "Discontinued date");
		Createpage.select_value("IBM", "company");
		Createpage.click_element("create this computer");
	}

}