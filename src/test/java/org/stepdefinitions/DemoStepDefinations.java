package org.stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.objectrepo.ObjectRepo;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testbase.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoStepDefinations extends TestBase{
	
	@Given("start testcase {string}")
	public void start_testcase(String string) {
		StartTest(string);
	}
	
	@Given("I have the URL")
	public void i_have_the_url() throws InterruptedException, IOException {
	browserOpen();
	configReader();
	driver.get(prop.getProperty("URL"));
	Thread.sleep(2000);
	}

	@When("I provide Username")
	public void i_provide_username() throws IOException {
	 //click(ObjectRepo.Loginbutton);
	 inputText(ObjectRepo.Email,prop.getProperty("UserName"),"Entering usename");
	}
	@When("I provide Password")
	public void i_provide_password() throws IOException {
	inputText(ObjectRepo.Pass,prop.getProperty("PassWord"),"Entering password");
	EndTest();
	}
	@When("I click on Submit button")
	public void i_click_on_submit_button() throws IOException {
		
	    click(ObjectRepo.Submit, "Submit");
	    LogEntries entry=driver.manage().logs().get(LogType.BROWSER);
	    List<LogEntry> logs=entry.getAll();
	    for(LogEntry log:logs)
	    {
	    	System.out.println("logging the browser console logs  :\n" +log);
	    	
	    }
	}
	@Then("I am logged into application")
	public void i_am_logged_into_application() throws IOException {
		//Runtime.getRuntime().exec("wscript C:/Users/Tejes Das/Downloads/abc.vbs");
	    
	}

}
