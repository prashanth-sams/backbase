package ecommerce.backbase.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ecommerce.backbase.helpers.genericFunctions;

public class DBHomePage extends genericFunctions {

	/* Used uniform css locators for efficiency*/
	private final By ADD_NEW_COMPUTER = By.cssSelector("#add");
	public final By SEARCH_COMPUTER = By.cssSelector("#searchbox");
	public final By SUBMIT_SEARCH = By.cssSelector("#searchsubmit");
	public final By ALERT_CREATE = By.cssSelector(".alert-message.warning");
	public final By COMPUTER_LIST = By.cssSelector("tbody a[href*='/computers']");


	public DBHomePage(WebDriver driver) {
		super(driver);
	}

	/* Click on a Element*/
	public void click_element(String value) throws InterruptedException {
		By objLocator = null;

		if (value.equals("create new computer")) {
			objLocator = ADD_NEW_COMPUTER;
		} else if (value.equals("machine")) {
			objLocator = COMPUTER_LIST;
		}
		clickElement(objLocator);
	}

}