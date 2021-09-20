package org.runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SuppressWarnings("deprecated")
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src//test//resources//Features",
		glue="org.stepdefinitions",
		plugin= {"pretty","html:target/cucumber-reports.html"},
		strict=true,
		monochrome=true,
		dryRun=false,
		tags= "@xyz"
		
		)





public class Runner {

}
