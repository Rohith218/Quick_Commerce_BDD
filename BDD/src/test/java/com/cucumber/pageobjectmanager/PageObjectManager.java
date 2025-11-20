package com.cucumber.pageobjectmanager;

import org.openqa.selenium.WebDriver;

import pageobjects.Landingpage;
import pageobjects.Offerspage;

public class PageObjectManager {
	WebDriver driver;
	Landingpage lp;
	Offerspage op;
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	public Landingpage getLandingPage() {
		return new Landingpage(driver);
	}
	public Offerspage getOfferspage() {
		return new Offerspage(driver);
	}
}
