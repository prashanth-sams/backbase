package ecommerce.propertyfinderae.step_definitions;

import static org.testng.AssertJUnit.assertEquals;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
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
    	page = new PFHomePage(driver);
    	config = new configProperty();
    }
    
    @When("^I open the page url \"([^\"]*)\"$")
    public void open_url(String URL) throws Throwable {
    	
    	if(URL.equals("propertyfinder.qa")) {
    		driver.get(config.getPageURL("PropertyfinderqaURL"));
    	} else if (URL.equals("propertyfinder.ae")) {
    		driver.get(config.getPageURL("PropertyfinderaeURL"));
    	}
        
    }
    
    @Then("^I validate the page title and URL \"([^\"]*)\"$")
    public void validate_the_page_title_and_URL(String PF) throws Throwable {
    	if(PF.equals("propertyfinder.qa")) {
    		assertEquals(config.getPageTitle("PFqaTitle"), driver.getTitle());
    	    assertEquals(config.getPageURL("PropertyfinderqaURL"), driver.getCurrentUrl());
    	} else if (PF.equals("propertyfinder.ae")) {
    		assertEquals(config.getPageTitle("PFaeTitle"), driver.getTitle());
    	    assertEquals(config.getPageURL("PropertyfinderaeURL"), driver.getCurrentUrl());
    	}
      
    }
    
    @When("^I select \"([^\"]*)\" from \"([^\"]*)\" field$")
    public void select_from_field(String val, String Field) throws Throwable {
        page.selectValue(val, Field);
    }
    
    @When("^I search \"([^\"]*)\" in \"([^\"]*)\" field$")
    public void search_in_field(String val, String Field) throws Throwable {
    	page.insertValue(val, Field);
    }

    @When("^I click on \"([^\"]*)\" link$")
    public void click_on_button(String link) throws Throwable {
        page.clickLink(link);
    }

    @Then("^I fetch all the prices of the listing and save it in csv file$")
    public void fetch_all_the_prices_of_the_listing_and_save_it_in_csv_file() throws Throwable {
        page.fetchAllPrices();
    }
    
    @When("^I filter Hindi English Arabic from Languages field$")
    public void filter_Hindi_English_Arabic_from_Languages_field() throws Throwable {
        page.filterLanguages();
    }

    @Then("^I get the total number of \"([^\"]*)\" agents$")
    public void get_the_total_number_of_agents(String counts) throws Throwable {
        page.scrapAgentCounts(counts);
    }

    @Then("^I validate the current agents to be in lesser number than previous$")
    public void validate_the_current_agents_to_be_in_lesser_number_than_previous() throws Throwable {
    	page.validateAgentcounts();
    }

    @Then("^I capture the First Agent details in a text file$")
    public void capture_the_First_Agent_details_in_a_text_file() throws Throwable {
    	page.captureFADetailsintoTextFile();
    }

    @Then("^I capture screenshot of the page \"([^\"]*)\" changing language$")
    public void capture_screenshot_of_the_page_changing_language(String time) throws Throwable {
    	
    	  Thread.sleep(2000);
      	  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      	  try {
      	   org.apache.commons.io.FileUtils.copyFile(scrFile, new File("./results/screenshot"+time+"changingLanguage.png"));
      	  } catch (Exception e) {
      		  System.out.println("Unable to take screenshot");
      	  }
      
    }



   
    
}