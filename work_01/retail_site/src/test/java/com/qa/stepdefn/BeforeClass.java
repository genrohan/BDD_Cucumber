package com.qa.stepdefn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;

public class BeforeClass {

	WebDriver driver;
	String path="C:\\Users\\Agarwal\\Desktop\\Selenium\\jar files\\Drivers\\chromedriver.exe";	//chromedriver path
	
	//@Before
	public void start() {
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
	}
	
}
