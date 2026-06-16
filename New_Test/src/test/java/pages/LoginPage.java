package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import utilities.WaitUtil;

public class LoginPage {

	WebDriver driver = DriverFactory.getDriver();

	private static final By MY_ACCOUNT = By.cssSelector("a[title='My Account']");

	private static final By LOGIN_OPTION = By.linkText("Login");

	private static final By EMAIL = By.id("input-email");

	private static final By PASSWORD = By.id("input-password");

	private static final By LOGIN_BUTTON = By.xpath("//input[@value='Login']");

	public void login(String email, String password) {

//		driver.findElement(MY_ACCOUNT).click();
		WaitUtil.waitForClickable(driver, MY_ACCOUNT).click();
//		driver.findElement(LOGIN_OPTION).click();
		WaitUtil.waitForClickable(driver, LOGIN_OPTION).click();

//		driver.findElement(EMAIL).sendKeys(email);
		WaitUtil.waitForVisible(driver, EMAIL).sendKeys(email);

//		driver.findElement(PASSWORD).sendKeys(password);
		WaitUtil.waitForVisible(driver, PASSWORD).sendKeys(password);

//		driver.findElement(LOGIN_BUTTON).click();
		WaitUtil.waitForClickable(driver, LOGIN_BUTTON).click();

	}

}