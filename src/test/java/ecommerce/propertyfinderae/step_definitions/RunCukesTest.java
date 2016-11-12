package ecommerce.propertyfinderae.step_definitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
//		features = "classpath:features",
		features = "src/resources/features/scenarioA.feature",
		plugin = {"pretty", "html:target/cucumber-html-report", "json:results/cucumber.json",
		"junit:results/cucumber.xml"},
		tags = {}
		)
public class RunCukesTest{
	
}