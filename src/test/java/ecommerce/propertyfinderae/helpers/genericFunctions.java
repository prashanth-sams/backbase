package ecommerce.propertyfinderae.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

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
        	throw new NoSuchElementException(String.format("The following element was not available ", selector));
        }
    }
	
	public void clickElement (By selector) {
		WebElement element = getElement(selector);
        waitForElementToBeClickable(selector);
        try {
            element.click();
        } catch (Exception e) {
        	throw new NoSuchElementException(String.format("The following element was not available ", selector));
        }
	}

	public void waitForElementTextToBeEmpty(WebElement element) {
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
	
	public void clearField(WebElement element) {
        try {
            element.clear();
            waitForElementTextToBeEmpty(element);
        } catch (Exception e) {
        	throw new NoSuchElementException(String.format("The following element was not available ", element));
        }
    }
	
    public void sendKeys(By selector, String value) {
        WebElement element = getElement(selector);
        clearField(element);
        try {
            element.sendKeys(value);
        } catch (Exception e) {
        	throw new NoSuchElementException(String.format("The following element was not available ", selector));
        }
    }
    
    public String getElementText(By selector) {
        waitUntilElementIsDisplayedOnScreen(selector);
        try {
            return StringUtils.trim(driver.findElement(selector).getText());
        } catch (Exception e) {
            System.out.println(String.format("Element %s does not exist - proceeding", selector));
        }
        return null;
    }
    
    public void waitUntilElementIsDisplayedOnScreen(By selector) {
        try {
            wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        } catch (Exception e) {
            throw new NoSuchElementException(String.format("The following element was not visible: %s ", selector));
        }
    }
    
    
    
}
