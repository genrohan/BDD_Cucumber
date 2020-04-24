package com.qa.stepdefn;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class PDPSteps {

	WebDriver driver;
    
	
    String p_name;
    int cartCount=0;
    String parentWinHandle;
    Set<String> winHandles;
    
	@Given("User is on Home page")
	public void user_is_on_Home_page() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Agarwal\\Desktop\\Selenium\\jar files\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
	}

	@When("User search for {string}")
	public void user_search_for(String product) throws Exception {
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
	    driver.findElement(By.className("nav-search-submit")).click();
	    Thread.sleep(3000);
	}

	@Then("User is on Product lister page of {string}")
	public void user_is_on_Product_lister_page(String product) { 
	   assertThat(driver.findElement(By.cssSelector(".sg-col-inner div span:nth-of-type(3)")).getText().toString(), equalTo(product)); 
	}

	
	@When("User select brand of the product as {string}")
	public void user_select_color_or_size_or_the_product(String brand) {
	    driver.findElement(By.partialLinkText(brand)).click();
	}

	
	@Then("User can see {string} product")
	public void user_can_see_the_selected_color_size_of_the_product(String brand) {
		assertThat(driver.findElement(By.xpath("(//div[@class='sg-col-inner'])/div/a/span")).getText().toString(), equalTo(brand));
		driver.close();
	}

	

	@When("User clicks on a product")
	public void user_clicks_on_a_product() throws Exception {
		driver.findElement(By.partialLinkText("Nivia")).click();
		Thread.sleep(3000);
		p_name = driver.findElement(By.xpath("(//span[contains(@class,'a-size-base-plus a-color-base a-text-normal')])[1]")).getText().toString();
		parentWinHandle = driver.getWindowHandle();
	    driver.findElement(By.xpath("(//div[contains(@class,'s-image-overlay-white-semitransparent')]/span/a)[1]")).click();
	    Thread.sleep(3000);
	}

	@Then("User lands on the detail page of the selected product")
	public void user_lands_on_the_detail_page_of_the_selected_product() throws Exception {
		winHandles = driver.getWindowHandles();
		 for(String handle: winHandles){
	            if(!handle.equals(parentWinHandle)){
	            driver.switchTo().window(handle);
	            Thread.sleep(1000);
	            }
		 }
	    assertThat(driver.findElement(By.xpath("//span[@id='productTitle']")).getText(), equalTo(p_name));
	    Thread.sleep(3000);
	    driver.close();
	}
	

	@Given("User is on the product detail page")
	public void user_is_on_the_product_detail_page() throws Exception {
		driver.get("https://www.amazon.in/Nivia-Stride-Spike-Running-Shoes/dp/B07VN4LS49/ref=sr_1_2?dchild=1&keywords=mens+running+shoes&qid=1587284950&refinements=p_89%3ANivia&rnid=3837712031&sr=8-2");
		Thread.sleep(2000);
	}
	
	
	
	@When("User select size as {string}")
	public void user_select_size_as(String size) throws Exception {
		driver.findElement(By.xpath("//option[@id='native_size_name_10']")).click();
		Thread.sleep(3000);
	}
	
	
	@When("User add product to the cart")
	public void user_add_product_to_the_cart() throws Exception {
		cartCount = Integer.parseInt(driver.findElement(By.xpath("//span[@id='nav-cart-count']")).getText());
		driver.findElement(By.xpath("//span[@id='submit.add-to-cart']")).click();
		cartCount++;
		Thread.sleep(2000);
	}
	
	@Then("Number of product in the cart increases by one")
	public void number_of_product_in_the_cart_increases_by_one() {
		assertThat(driver.findElement(By.xpath("//span[@id='nav-cart-count']")).getText(), equalTo(String.valueOf(cartCount)));
		driver.close();
	}
}
