package EcommerceStepDefinitions;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import com.cucumber.pageobjectmanager.PageObjectManager;

import Driver.DriverInitialize;
import TestContextSetup.TestContextSetup;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Landingpage;

public class LandingPageStepDefinitions {
	
	//Single Responsibility Principle in SOLID - every class must have only one function
	//Loosely Coupled 
	public WebDriver driver;
	TestContextSetup ts;
	public String product = "";
	public String offersProduct = "";
	DriverInitialize d = new DriverInitialize();
	PageObjectManager pom;
	public LandingPageStepDefinitions(TestContextSetup ts) {
		this.ts = ts;
		if(ts.driver == null) {
			ts.driver = d.initialize();
		}
		this.driver = ts.driver;
		if(ts.pom ==null) {
			pom = new PageObjectManager(ts.driver);
		}
	}
	String[] text;
	Assertion a = new Assertion();
	WebDriverWait wait;
	@Given("Verify User is on GreenKart page {string}")
	public void verify_user_is_on_green_kart_page(String string) {
		d.openPage(string, driver);
	}
	@When("search for shortname {string} on homepage and extract actualname")
	public void search_for_shortname_on_homepage_and_extract_actualname(String string) throws InterruptedException {		
		Landingpage lp = pom.getLandingPage();
		lp.searchItem(string);
		text = lp.getProductName().split("-");
		product = text[0].trim();
		System.out.println("***************************************"+product+"**********************************");
		ts.product = product;
	}


}
