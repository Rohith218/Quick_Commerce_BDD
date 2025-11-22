package EcommerceStepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import Driver.DriverInitialize;
import TestContextSetup.TestContextSetup;
import io.cucumber.java.en.Then;
import pageobjects.Offerspage;

public class OfferPageStepDefinitions {

	
	public WebDriver driver;
	WebDriverWait wait;
	public String product = "";
	public String offersProduct = "";
	Assertion a = new Assertion();
	TestContextSetup ts;
	DriverInitialize d = new DriverInitialize();
	public OfferPageStepDefinitions(TestContextSetup ts) {
		this.ts = ts;
		this.driver = ts.driver;
	}
	
	@Then("user search same shortname {string} in offerspage and verify both are same")
	public void user_search_same_shortname_in_offerspage_and_verify_both_are_same(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Offerspage op = new Offerspage(driver);
		op.switchtoOffersPage();
		op.searchOffersPage(string);
		offersProduct = op.getOffersProduct();
		ts.offersProduct = offersProduct;
		driver.quit();
	}
	
	@Then("validate whether product name in landing page is same as offers page")
	public void validate_whether_product_name_in_landing_page_is_same_as_offers_page() {
	    boolean b = (ts.product.equalsIgnoreCase(ts.offersProduct))? true:false;
	    a.assertEquals(ts.offersProduct, ts.product);;
	}
}
