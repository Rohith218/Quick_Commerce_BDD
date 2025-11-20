package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestContextSetup.TestContextSetup;

public class Landingpage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	public Landingpage(WebDriver driver){
		this.driver = driver;
	}
	By search = By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
	By productname = By.xpath("//h4[@class='product-name']");
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	public String getSearchItem() {
		return driver.findElement(search).getText();
	}
	public String getProductName() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(productname)));
		Thread.sleep(2000);
		return driver.findElement(productname).getText();
	}
}
