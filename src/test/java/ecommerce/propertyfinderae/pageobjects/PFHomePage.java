package ecommerce.propertyfinderae.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ecommerce.propertyfinderae.helpers.genericFunctions;

public class PFHomePage extends genericFunctions{

	private final By CATEGORY_FIELD = By.cssSelector("form#search-form-property .search-wrapper button.ms-choice span");
	private final By SELECT_BUY = By.cssSelector("form#search-form-property .search-wrapper .ms-drop ul > li[data-value='1']");
	
	
	public PFHomePage(WebDriver driver) {
		super(driver);
	}
	
	public void selectValue(String val, String Field) throws InterruptedException {
		By objLocator = null; 
		
		if (Field.equals("Category")) {
			clickElement(CATEGORY_FIELD);
			objLocator = SELECT_BUY;
		} else if (Field.equals("")) {
			
		}
		
		waitForElementToBeVisible(objLocator);
		clickElement(objLocator);
		
	}

}
