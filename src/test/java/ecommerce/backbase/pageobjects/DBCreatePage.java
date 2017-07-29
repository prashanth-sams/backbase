package ecommerce.backbase.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ecommerce.backbase.helpers.configProperty;
import ecommerce.backbase.helpers.genericFunctions;

public class DBCreatePage extends genericFunctions {

	/* Used uniform css locators for efficiency*/
	private final By COMPUTER_NAME = By.cssSelector("#name");
	private final By INTRODUCED_DATE = By.cssSelector("#introduced");
	private final By DISCONTINUED_DATE = By.cssSelector("#discontinued");
	private final By COMPANY = By.cssSelector("#company");
	private final By CREATE_COMPUTER = By.cssSelector("[value='Create this computer']");
	private final By UPDATE_COMPUTER = By.cssSelector("[value='Save this computer']");
	private final By DELETE_COMPUTER = By.cssSelector("[value='Delete this computer']");

	public configProperty config;

	public DBCreatePage(WebDriver driver) {
		super(driver);
		config = new configProperty();
	}

	/* Enter values in a Text Field */
	public void insert_value(String value, String Field) throws InterruptedException {
		if (Field.equals("Computer name")) {
			sendKeys(COMPUTER_NAME, config.getComputerName("computer-name"));
		} else if (Field.equals("Introduced date")) {
			sendKeys(INTRODUCED_DATE, value);
		} else if (Field.equals("Discontinued date")) {
			sendKeys(DISCONTINUED_DATE, value);
		} else if (Field.equals("Computer update name")) {
			sendKeys(COMPUTER_NAME, config.getComputerName("updated-computer-name"));
		}
	}

	/* Click on a Element*/
	public void click_element(String value) throws InterruptedException {
		By objLocator = null;

		if (value.equals("create this computer")) {
			objLocator = CREATE_COMPUTER;
		} else if (value.equals("save this computer")) {
			objLocator = UPDATE_COMPUTER;
		} else if (value.equals("delete this computer")) {
			objLocator = DELETE_COMPUTER;
		}
		clickElement(objLocator);
	}

	/* Select value from a drop-down box*/
	public void select_value(String value, String Field) throws InterruptedException {
		if (Field.equals("company")) {
			SelectByText(value, COMPANY);
		} else if (Field.equals("")) {

		}
	}

}