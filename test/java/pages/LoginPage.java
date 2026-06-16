package pages;

import org.openqa.selenium.*;

import base.DriverFactory;
import utilities.WaitUtil;

public class LoginPage {

	WebDriver driver = DriverFactory.getDriver();

	private static final By USERNAME = By.name("username");

	private static final By PASSWORD = By.name("password");

	private static final By LOGIN_BUTTON = By.xpath("//input[@type='submit' and @value='Log In']");

	public void enterCredentials(String user, String pass) {

		WaitUtil.waitForVisible(driver, USERNAME).sendKeys(user);
		WaitUtil.waitForVisible(driver, PASSWORD).sendKeys(pass);
	}

	public void clickLogin() {

		WaitUtil.waitForClickable(driver, LOGIN_BUTTON).click();
	}

}