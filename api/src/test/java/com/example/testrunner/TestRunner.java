package com.example.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		//Setup of the feature file to run
		features = "src/test/resources/features/TestCase.feature",
		//Setup of the step definition
		glue = "com.example.stepdef",
		//Setup of the Reports generation
		plugin ="html:target/reports/API Automation Reports.html"
)

public class TestRunner {
	
}