package ecommerce.propertyfinderae.pageobjects;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ecommerce.propertyfinderae.helpers.genericFunctions;

public class PFHomePage extends genericFunctions{

	private final By CATEGORY_FIELD = By.cssSelector("form#search-form-property .search-wrapper button.ms-choice span");
	private final By SELECT_BUY = By.cssSelector("form#search-form-property .search-wrapper .ms-drop ul > li[data-value='1']");
	private final By SEARCH_FIELD = By.cssSelector("input[name='q']");
	private final By AUTO_SEARCH = By.cssSelector("strong[class='tt-highlight']");
	private final By PROPERTY_FIELD = By.cssSelector("#search-form-property > div.settings.minimized > div > div:nth-child(1) > div > button > span");
	private final By SELECT_VILLA = By.cssSelector("form#search-form-property .ms-drop ul > li[data-value='35']");
	private final By MIN_BEDROOM = By.cssSelector("#bedroom_group > div:nth-child(1) > div > button > span");
	private final By MAX_BEDROOM = By.cssSelector("#bedroom_group > div:nth-child(2) > div > button > span");
	private final By SELECT_3BEDS = By.cssSelector("#bedroom_group > div:nth-child(1) ul > li:nth-child(5)");
	private final By SELECT_7BEDS = By.cssSelector("#bedroom_group > div:nth-child(2) ul > li:nth-child(9)");
	private final By CLICK_SEARCH = By.cssSelector("#search-form-property > div.pure-g.search-wrapper > div.search.pure-u-1-1.pure-u-sm-3-4.pure-push > button > div.text");
	private final By SORT_FIELD = By.cssSelector("#serp-nav > div.title-sort-area > div > div > button > span");
	private final By SORT_HIGHPRICE = By.cssSelector("#serp-nav > div.title-sort-area > div > div > div > ul > li:nth-child(4)");
	private final By LISTED_PRICES = By.cssSelector("#content span.val");
	
	
	public PFHomePage(WebDriver driver) {
		super(driver);
	}
	
	public void selectValue(String val, String Field) throws InterruptedException {
		By objLocator = null; 
		
		if (Field.equals("Category")) {
			clickElement(CATEGORY_FIELD);
			objLocator = SELECT_BUY;
		} else if (Field.equals("Minimum_Bedroom_Group")) {
			clickElement(MIN_BEDROOM);
			objLocator = SELECT_3BEDS;
		} else if (Field.equals("Maximum_bedroom_Group")) {
			clickElement(MAX_BEDROOM);
			objLocator = SELECT_7BEDS;
		} else if (Field.equals("Property")) {
			clickElement(PROPERTY_FIELD);
			objLocator = SELECT_VILLA;
		} else if (Field.equals("Sorting")) {
			clickElement(SORT_FIELD);
			objLocator = SORT_HIGHPRICE;
		}
		
		clickElement(objLocator);
		
	}
	
	public void insertValue(String val, String Field) throws InterruptedException {
		
		if(Field.equals("Location")) {
			clickElement(SEARCH_FIELD);
			sendKeys(SEARCH_FIELD, val);
			clickElement(AUTO_SEARCH);
		} else if (Field.equals("")) {
			
		}
			
	}
	
	public void clickButton(String button) throws InterruptedException {
		By objLocator = null; 
		
		if (button.equals("search")) {
			objLocator = CLICK_SEARCH;
		} else if (button.equals("")) {
		}
		
		clickElement(objLocator);
		
	}
	
	public void fetchAllPrices() throws InterruptedException, IOException {
		
		FileWriter writer = new FileWriter("./results/listing title - price.csv");
		writer.append("PriceList_Top_to_Low");
		writer.append('\n');

		List<WebElement> element = driver.findElements(LISTED_PRICES);
		
		for (WebElement myValue : element) {
		    writer.append(myValue.getText().replaceAll(",", ""));
		    writer.append('\n');
		    writer.flush();
		}
		
		
	}

}