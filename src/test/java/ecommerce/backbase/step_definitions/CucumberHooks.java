package ecommerce.backbase.step_definitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import ecommerce.backbase.helpers.*;

public class CucumberHooks{
	public static WebDriver driver;


	@Before
	/**
	 * Delete all cookies at the start of each scenario to avoid
	 * shared state between tests
	 */

	public void openBrowser() throws IOException {
		String browser = System.getProperty("BROWSER");

		configProperty config = new configProperty();

		if(browser.equals("chrome"))
		{
			System.out.println("CHROME initiated");
			System.setProperty("webdriver.chrome.driver", config.getChromePath());
			driver = new ChromeDriver();
		} else if (browser.equals("phantomjs")) {
			System.out.println("HEADLESS mode initiated with phantomjs");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, config.getPhantomjsPath());
			driver = new PhantomJSDriver(caps);
		} else {
			System.out.println("Skipped and CHROME initiated");
			System.setProperty("webdriver.chrome.driver", config.getPhantomjsPath());
			driver = new ChromeDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}


	@After
	/**
	 * Embed a screenshot in test report if test is marked as failed
	 */
	public void embedScreenshot(Scenario scenario) {

		if(scenario.isFailed()) {
			try {
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");    
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}

		}
		driver.quit();

	}

}
