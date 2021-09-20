package org.stepdefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.objectrepo.ObjectRepo;
import org.testbase.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExamplesStepDefinition  extends TestBase{
	
	
	@Given("i have th url of flipkart")
	public void i_have_th_url_of_flipkart() throws IOException, InterruptedException {
		
		browserOpen();
		configReader();
		driver.get(prop.getProperty("URL"));
		Thread.sleep(2000);
	    
	}


	

	@When("i provide the required username")
	public void i_provide_the_required_username(io.cucumber.datatable.DataTable dataTable) throws IOException {
		
	    List<String> users=new ArrayList<String>();
	    users=dataTable.asList(String.class);
	    System.out.println(users);
	    inputText(ObjectRepo.Email,users.get(0),"entering mail");
	    inputText(ObjectRepo.Email,users.get(1),"Entering mail");
	    
	 
	}
	@When("i provid th required password")
	public void i_provid_th_required_password(io.cucumber.datatable.DataTable dataTable) {
	    
	}
	@Then("i should be in the flipkart home page")
	public void i_should_be_in_the_flipkart_home_page() {
	    
	}



}
