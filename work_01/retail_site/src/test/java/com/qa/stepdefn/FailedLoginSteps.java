package com.qa.stepdefn;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class FailedLoginSteps {

	WebDriver driver;
	
	String c_uname = "";		//correct mail id
	String inc_uname="abc123";
	String inc_pswd = "abc123";
	
	@Given("User is on Sign in page")
	public void user_is_on_Sign_in_page() throws Exception {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Agarwal\\Desktop\\Selenium\\jar files\\Drivers\\chromedriver.exe");
		//driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("nav-link-accountList")).click();
		Thread.sleep(3000);
	}
	
	@When("User enters correct mail id")
	public void user_enter_correct_mail_id() throws Exception {
	    driver.findElement(By.id("ap_email")).sendKeys(c_uname);
	    driver.findElement(By.id("continue")).click();
		Thread.sleep(3000);
	}

	@When("User enters Password")
	public void user_enters_Password() throws Exception {
		driver.findElement(By.id("ap_password")).sendKeys(inc_pswd);
		driver.findElement(By.id("signInSubmit")).click();
   		Thread.sleep(3000);
	}

	@Then("Verify incorrect password displayed on the page")
	public void verify_incorrect_password_displayed_on_the_page() {
	  String msg = driver.findElement(By.className("a-list-item")).getText();
	  assertThat(msg, equalTo("Your password is incorrect"));
	  driver.close();
	}

	
	@When("User enters incorrect mail id")
	public void user_enter_incorrect_mail_id() throws Exception {
	    driver.findElement(By.id("ap_email")).sendKeys(inc_uname);
	    driver.findElement(By.id("continue")).click();
		Thread.sleep(3000);
	}

	
	@Then("Verify incorrect mail id displayed on the page")
	public void verify_incorrect_mail_id_displayed_on_the_page() {
		String msg = driver.findElement(By.className("a-list-item")).getText();
		assertThat(msg, equalTo("We cannot find an account with that email address"));
		driver.close();
	}

	

	@When("User enters mail id")
	public void user_enters_mail_id() throws Exception {
		    driver.findElement(By.id("ap_email")).sendKeys(inc_uname);
		    driver.findElement(By.id("continue")).click();
			Thread.sleep(3000);
	}

	@Then("User lands on SIGN UP page")
	public void user_lands_on_SIGN_UP_page() {
		String msg = driver.findElement(By.className("a-list-item")).getText();
		assertThat(msg, equalTo("We cannot find an account with that email address"));
		driver.close();
	}

	
	
}
