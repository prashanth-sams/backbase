package ecommerce.backbase.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class genericFunctions {
	public static WebDriver driver;
	public static WebDriverWait wait;

	public genericFunctions(WebDriver driver) {
		super();
		genericFunctions.driver = driver;
	}

	public void waitForElementToBeVisible(By selector) {

		try {
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		} catch (Exception e) {
			throw new NoSuchElementException(String.format("The following element was not visible within [%s] seconds: %s ", "15".toString(), selector));

		}
	}

	public static WebElement getElement(By selector) {
		try {
			return driver.findElement(selector);
		} catch (Exception e) {
			System.out.println(String.format("Element %s does not exist - proceeding", selector));
		}
		return null;
	}

	public static List<WebElement> getElements(By selector) {
		try {
			return driver.findElements(selector);
		} catch (Exception e) {
			System.out.println(String.format("Elements %s does not exist - proceeding", selector));
		}
		return null;
	}

	public static void waitForElementToBeClickable(By selector) {
		try {
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(selector));
		} catch (Exception e) {
			throw new NoSuchElementException(String.format("The following element was not available ", selector));
		}
	}

	public static void clickElement (By selector) {
		WebElement element = getElement(selector);
		waitForElementToBeClickable(selector);
		try {
			element.click();
		} catch (Exception e) {
			throw new NoSuchElementException(String.format("The following element was not available ", selector));
		}
	}

	public static void waitForElementTextToBeEmpty(WebElement element) {
		String text;
		try {
			text = element.getText();
			int maxRetries = 10;
			int retry = 0;
			while ((text.length() >= 1) || (retry < maxRetries)) {
				retry++;
				text = element.getText();
			}
		} catch (Exception e) {
			throw new NoSuchElementException(String.format("The following element was not available ", element));
		}

	}

	public static void clearField(WebElement element) {
		try {
			element.clear();
			waitForElementTextToBeEmpty(element);
		} catch (Exception e) {
			throw new NoSuchElementException(String.format("The following element was not available ", element));
		}
	}

	public static void sendKeys(By selector, String value) {
		WebElement element = getElement(selector);
		clearField(element);
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			throw new NoSuchElementException(String.format("The following element was not available ", selector));
		}
	}

	public static String getElementText(By selector) {
		waitUntilElementIsDisplayedOnScreen(selector);
		try {
			return driver.findElement(selector).getText();
		} catch (Exception e) {
			System.out.println(String.format("Element %s does not exist - proceeding", selector));
		}
		return null;
	}

	public static void waitUntilElementIsDisplayedOnScreen(By selector) {
		try {
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		} catch (Exception e) {
			throw new NoSuchElementException(String.format("The following element was not visible: %s ", selector));
		}
	}

	public void SelectByText(String value, By selector) {
		WebElement element = getElement(selector);
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public static String getTextofFirstElement(By selector) {
		List<WebElement> element_list = getElements(selector);
		try {
			return element_list.get(0).getText(); 
		} catch (Exception e) {
			System.out.println(String.format("Element %s does not exist - proceeding", selector));
		}
		return null;	
	}

	public static int elementSize(By selector) {
		List<WebElement> element_list = getElements(selector);
		try {
			return element_list.size(); 
		} catch (Exception e) {
			System.out.println(String.format("unknown error: ", selector));
		}
		return 0;
	}

}
