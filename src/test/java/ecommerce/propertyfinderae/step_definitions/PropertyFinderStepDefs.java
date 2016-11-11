package ecommerce.propertyfinderae.step_definitions;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

//import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import Hooks.*;

public class PropertyFinderStepDefs{
    public WebDriver driver;
    
    public PropertyFinderStepDefs()
    {
    	driver = CucumberHooks.driver;
    }
    
//    @Before("smoke")
//    public void setup() throws Throwable {
//    	WebDriver driver = new ChromeDriver();
//    	driver.close();
//    }
    
//    @Before("smoke")
    @When("^I Open PropertyFinder$")
    public void open_url() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.propertyfinder.qa/");
    }
    
    @Then("^I validate the page title and URL$")
    public void validate_the_page_title_and_URL() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      assertEquals("propertyfinder.qa - Qatar's #1 property site",driver.getTitle());
      assertEquals("https://www.propertyfinder.qa/", driver.getCurrentUrl());
    }
    
}