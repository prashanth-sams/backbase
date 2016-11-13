package ecommerce.propertyfinderae.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class genericFunctions {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public genericFunctions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForElementToBeVisible(By selector) {
		
		try {
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		} catch (Exception e) {
			throw new NoSuchElementException(String.format("The following element was not visible within [%s] seconds: %s ", "15".toString(), selector));

		}
	}
	
	public WebElement getElement(By selector) {
        try {
            return driver.findElement(selector);
        } catch (Exception e) {
            System.out.println(String.format("Element %s does not exist - proceeding", selector));
        }
        return null;
    }
	
	public void waitForElementToBeClickable(By selector) {
        try {
            wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.elementToBeClickable(selector));
        } catch (Exception e) {
//            throw new TestException("The following element is not clickable: " + selector);
        }
    }
	
	public void clickElement (By selector) {
		WebElement element = getElement(selector);
        waitForElementToBeClickable(selector);
        try {
            element.click();
        } catch (Exception e) {
//            throw new TestException(String.format("The following element is not clickable: [%s]", selector));
        }
	}

	
}
