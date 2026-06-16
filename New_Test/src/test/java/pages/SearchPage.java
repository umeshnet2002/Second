package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.DriverFactory;
import utilities.WaitUtil;

public class SearchPage {

	WebDriver driver = DriverFactory.getDriver();

	private static final By SEARCH_BOX = By.name("search");

	public void searchProduct(String productName) {

		WebElement search = WaitUtil.waitForVisible(driver, SEARCH_BOX);
		search.sendKeys(productName);
		search.sendKeys(Keys.ENTER);

	}

}