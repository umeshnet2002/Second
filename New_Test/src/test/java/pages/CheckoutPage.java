package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.DriverFactory;
import utilities.WaitUtil;

public class CheckoutPage {

	WebDriver driver = DriverFactory.getDriver();
	
	private static final By SEARCH_PRODUCT = By.cssSelector("div[class='product-thumb']");

	private static final By ADD_TO_CART = By.id("button-cart");

	private static final By CART = By.cssSelector("a[title='Shopping Cart']");

	private static final By CHECKOUT = By.linkText("Checkout");
	


	public void addProductToCart() {
		List<WebElement> products = WaitUtil.waitForAllVisible(driver, SEARCH_PRODUCT);
		products.get(1).click();
		driver.findElement(ADD_TO_CART).click();

	}

	public void checkout() {
		driver.findElement(CART).click();
		driver.findElement(CHECKOUT).click();
	}

}
