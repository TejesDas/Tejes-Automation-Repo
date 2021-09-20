package org.stepdefinitions;

import org.objectrepo.ObjectRepo;
import org.openqa.selenium.By;
import org.testbase.TestBase;

import io.cucumber.java.en.When;

public class DatFeaturesStpDefinition extends TestBase {
	
	
	@When("^I give te \"([^\"]*)\"$")
	public void I_give_te(String arg1) {
	    driver.findElement(By.xpath("input[@class='_2IX_2- _3umUoc VJZDxU']")).sendKeys(arg1);
	}
}


