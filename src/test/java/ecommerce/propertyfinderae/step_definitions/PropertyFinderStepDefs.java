package ecommerce.propertyfinderae.step_definitions;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ecommerce.propertyfinderae.helpers.*;
import ecommerce.propertyfinderae.pageobjects.*;

//import ecommerce.propertyfinderae.pageobjects.PFHomePage;

public class PropertyFinderStepDefs{
    public WebDriver driver;
    public configProperty config;
    public PFHomePage page;
    
    public PropertyFinderStepDefs()
    {
    	driver = CucumberHooks.driver;
    }
    
    @When("^I open the page url$")
    public void open_url() throws Throwable {
    	config = new configProperty();
        driver.get(config.getPageURL());
    }
    
    @Then("^I validate the page title and URL$")
    public void validate_the_page_title_and_URL() throws Throwable {
      assertEquals("propertyfinder.qa - Qatar's #1 property site",driver.getTitle());
      assertEquals("https://www.propertyfinder.qa/", driver.getCurrentUrl());
    }
    
    @When("^I select \"([^\"]*)\" from \"([^\"]*)\" field$")
    public void select_from_field(String val, String Field) throws Throwable {

        page = new PFHomePage(driver);
        page.selectValue(val, Field);
        
    }
    
}