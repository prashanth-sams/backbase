package ecommerce.propertyfinderae.pageobjects;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
	private final By CLICKFA_SEARCH = By.cssSelector("button[class='submit']");
	private final By SORT_FIELD = By.cssSelector("#serp-nav > div.title-sort-area > div > div > button > span");
	private final By SORT_HIGHPRICE = By.cssSelector("#serp-nav > div.title-sort-area > div > div > div > ul > li:nth-child(4)");
	private final By LISTED_PRICES = By.cssSelector("#content span.val");
	private final By CLICK_FINDAGENT = By.cssSelector("#header nav > ul > li a.js-find-agent");
	private final By SELECT_LANGUAGES = By.cssSelector("#find-an-agent div.search-filter-container > div:nth-child(2) > div > button > span");
	private final By SELECT_ARABIC = By.cssSelector("#find-an-agent div.search-filter-container > div:nth-child(2) ul > li:nth-child(4)");
	private final By SELECT_ENGLISH = By.cssSelector("#find-an-agent div.search-filter-container > div:nth-child(2) ul > li:nth-child(11)");
	private final By SELECT_HINDI = By.cssSelector("#find-an-agent div.search-filter-container > div:nth-child(2) ul > li:nth-child(16)");
	private final By CLICK_NATIONALITY = By.cssSelector("#find-an-agent div.search-field-container > div:nth-child(3) > div > button > span");
	private final By FILTER_INDIA = By.cssSelector("#find-an-agent div.search-field-container > div:nth-child(3) > div > div > ul > li:nth-child(24)");
	private final By AGENTS_COUNT = By.cssSelector("#find-an-agent div.header-area.serp-header.hide-on-print > h1");
	private final By CLICK_FIRSTAGENT = By.cssSelector("#find-an-agent div.tile-block-area > div:nth-child(1) > a");
	private final By FA_USERNAME = By.cssSelector(".user-name");
	private final By FA_NATIONALITY = By.cssSelector(".user-nationality .content");
	private final By FA_LANGUAGE = By.cssSelector(".user-language .content");
	private final By FA_LICENSENO = By.cssSelector(".user-rera-no .content");	
	private final By FA_ABOUTME_LINK = By.cssSelector("button[data-tab='aboutMe']");
	private final By FA_ABOUTME = By.cssSelector("[data-tab-ref='aboutMe']");
	private final By FA_COMPANYNAME = By.cssSelector(".company-name");
	private final By FA_EXPERIENCE = By.cssSelector(".user-experience .content");
	private final By FA_ACTIVELISTINGS = By.cssSelector(".user-active-listing a");
	private final By ARABIC = By.cssSelector("#header > div.desktop-country-language-select > nav > div.language-wrapper > a");
	
	
	public String CombinedAgentcount;
	public String IndianAgentcount;
	
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
		} else if (Field.equals("Nationality")) {
			clickElement(CLICK_NATIONALITY);
			objLocator = FILTER_INDIA;
		}
		
		clickElement(objLocator);
		
	}
	
	public void filterLanguages() throws InterruptedException {
		
		clickElement(SELECT_LANGUAGES);
		clickElement(SELECT_ARABIC);
		clickElement(SELECT_ENGLISH);
		clickElement(SELECT_HINDI);
			
	}
	
	public void insertValue(String val, String Field) throws InterruptedException {
		
		if(Field.equals("Location")) {
			clickElement(SEARCH_FIELD);
			sendKeys(SEARCH_FIELD, val);
			clickElement(AUTO_SEARCH);
		} else if (Field.equals("")) {
			
		}
			
	}
	
	public void clickLink(String link) throws InterruptedException {
		By objLocator = null; 
		
		if (link.equals("search")) {
			objLocator = CLICK_SEARCH;
		} else if (link.equals("Find agent")) {
			objLocator = CLICK_FINDAGENT;
		} else if (link.equals("searchFA")) {
			objLocator = CLICKFA_SEARCH;
		} else if (link.equals("First agent")) {
			objLocator = CLICK_FIRSTAGENT;
		} else if (link.equals("Arabic language")) {
			objLocator = ARABIC;
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

	public void scrapAgentCounts(String counts) throws InterruptedException {
		if (counts.equals("Combined")) {
			CombinedAgentcount = getElementText(AGENTS_COUNT).replaceAll("\\D+","");
		} else if (counts.equals("Indian")) {
			Thread.sleep(3000);
			IndianAgentcount = getElementText(AGENTS_COUNT).replaceAll("\\D+","");
		}
		
	}
	
	public void captureFADetailsintoTextFile() throws IOException {

		File newTextFile = new File("./results/FAdetails.txt");
		FileWriter fw = new FileWriter(newTextFile);

		String username, nationality, language, license, aboutme, companyname, experience, activelistings;		
		
			username = getElementText(FA_USERNAME);
			fw.write(username+"\n");
		
			nationality = getElementText(FA_NATIONALITY);
			fw.write(nationality+"\n");
		
			language = getElementText(FA_LANGUAGE);
			fw.write(language+"\n");
			
			license = getElementText(FA_LICENSENO);
			fw.write(license+"\n");
			
			clickElement(FA_ABOUTME_LINK);
			aboutme = getElementText(FA_ABOUTME);
			fw.write(aboutme+"\n");
			
			companyname = getElementText(FA_COMPANYNAME);
			fw.write(companyname+"\n");
			
			experience = getElementText(FA_EXPERIENCE);
			fw.write(experience+"\n");
			
			activelistings = getElementText(FA_ACTIVELISTINGS);
			fw.write(activelistings+"\n");
			
			fw.close();
		
	}
	

	public void validateAgentcounts() {
		int previousCount = Integer.parseInt(CombinedAgentcount);
		int latestCount = Integer.parseInt(IndianAgentcount);
		
		if (previousCount >= latestCount) {
			System.out.println("Assertion Success");
		} else {
			Assert.fail();
		}
		
	}

}