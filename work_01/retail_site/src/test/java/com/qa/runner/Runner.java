package com.qa.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\java\\com\\qa\\feature\\pdp.feature",
		glue = "com.qa.stepdefn",
		plugin = { "pretty" , "html:test-output"},
		monochrome = true,
		strict = true
		)

public class Runner {

}
