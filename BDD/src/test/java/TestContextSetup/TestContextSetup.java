package TestContextSetup;

import org.openqa.selenium.WebDriver;

import com.cucumber.pageobjectmanager.PageObjectManager;

import Driver.DriverInitialize;

public class TestContextSetup {
	public WebDriver driver;
	public String offersProduct ;
	public String product = "";
	public PageObjectManager pom;
	public TestContextSetup() {
		
	}
}
