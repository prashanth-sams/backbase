package ecommerce.propertyfinderae.step_definitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
//		features = "classpath:features",
		features = "src/resources/features/scenarioA.feature",
		plugin = {"pretty", "html:target/cucumber-html-report"},
		tags = {}
//		tags = {"@smoke"}
		)
public class RunCukesTest{
	
}