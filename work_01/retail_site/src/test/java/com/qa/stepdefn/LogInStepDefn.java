package com.qa.stepdefn;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInStepDefn {

	String c_uname="";		//correct mail id
	String c_pswd = "";		//correct password
	
	String inc_uname="abc123";
	String inc_pswd = "abc123";
	
	WebDriver driver;
	
	@Given("User is on HomePage")
	public void user_in_on_Homepage()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Agarwal\\Desktop\\Selenium\\jar files\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
	}
	
	
	
	@When("User clicks on SignIn")
	public void user_clicksoin_SignIn() throws Exception {
	   driver.findElement(By.id("nav-link-accountList")).click();
	   //clicking on signin button
	   Thread.sleep(3000); 
	}
		
	
	@When("User enters mailid")
	public void user_enter_mailid() {
		driver.findElement(By.id("ap_email")).sendKeys(c_uname);
		//entering mail id
	}
	
	@When("User clicks on Continue")
	public void user_clicks_on_the_Continue() throws Exception {
		driver.findElement(By.id("continue")).click();
		Thread.sleep(3000);
	}
	
	
	
	 @When("User enters password") 
	public void user_enter_Password() throws Exception {
		driver.findElement(By.id("ap_password")).sendKeys(c_pswd);
		Thread.sleep(3000);
	}
	
	
	@When("User clicks on Login")
	public void user_clicks_Signin() throws Exception {
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(3000);
	}
	
	
	@Then("Login validation is done")
	public void login_validation_Done() throws Exception {
		String u_name= driver.findElement(By.xpath("[@id=\"nav-link-accountList\"]/span[1]")).getText();
		//reading the username in the home page
		assertThat(u_name, is(equalTo("Hello, Bicky")));
		Thread.sleep(3000);
	}
	
	
}

