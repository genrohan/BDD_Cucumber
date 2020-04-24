package com.qa.stepdefn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class ProductSteps {

	WebDriver driver;
	
	@Given("User is on product detail page")
	public void user_is_on_the_product_detail_page() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Agarwal\\Desktop\\Selenium\\jar files\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.amazon.in/Test-Exclusive-606/dp/B07HGJK535/ref=sr_1_2?dchild=1&keywords=oneplus+8&qid=1587278832&sr=8-2");
		Thread.sleep(2000);
	}

	@Then("User can see Currently Unvailable displayed")
	public void user_can_see_Currently_Unvailable_displayed() {
		driver.findElement(By.xpath("//div[@id='outOfStock']/div/div/span")).getText();
	    driver.close();
	}

	
	
}
