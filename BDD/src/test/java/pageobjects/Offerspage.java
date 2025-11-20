package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Offerspage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	private By deals = By.xpath("//a[@href='#/offers']");
	private By search = By.xpath("//input[@id='search-field' and @type='search']");
	private By product = By.cssSelector("tbody tr td:nth-child(1)");
	public Offerspage(WebDriver driver){
		this.driver = driver;
	}
	public void clickDeals() {
		driver.findElement(deals).click();
	}
	public void switchtoOffersPage() throws InterruptedException {
		WebElement dealsElement = driver.findElement(deals);
		String orig = driver.getWindowHandle();
		dealsElement.click();
		for(String s : driver.getWindowHandles()) {
			if(!s.equals(orig)) {
				driver.switchTo().window(s);
			}
		}
		
	}
	public void searchOffersPage(String s) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(search).sendKeys(s);
	}
	public String getOffersProduct() throws InterruptedException{
		Thread.sleep(5000);
		return driver.findElement(product).getText();
	}


}
