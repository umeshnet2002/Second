package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import base.DriverFactory;
import utilities.WaitUtil;

public class RegistrationPage {
	WebDriver driver = DriverFactory.getDriver();
	Actions ac = new Actions(driver);

//	private static final By REGISTER_BUTTON = By.cssSelector("a[href='register.htm']");
	private static final By REGISTER_BUTTON = By.linkText("Register");
	private static final By FIRST_NAME = By.id("customer.firstName");
	private static final By LAST_NAME = By.id("customer.lastName");
	private static final By ADDRESS = By.id("customer.address.street");
	private static final By CITY = By.id("customer.address.city");
	private static final By STATE = By.id("customer.address.state");
	private static final By ZIP_CODE = By.id("customer.address.zipCode");
	private static final By PHONE_NUMBER = By.id("customer.phoneNumber");
	private static final By SSN = By.id("customer.ssn");
	private static final By USERNAME = By.id("customer.username");
	private static final By PASSWORD = By.id("customer.password");
	private static final By CONFIRM_PASSWORD = By.id("repeatedPassword");
	private static final By SUBMIT_BUTTON = By.xpath("//input[@value='Register']");

	public void home() {
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}

	public void Click() {

		WaitUtil.waitForVisible(driver, REGISTER_BUTTON).click();

	}

	public void add_credentials(String fname, String lname, String address, String city, String state, String zip,
			String phone, String ssn, String username, String password, String confirm_password) {

		WaitUtil.waitForVisible(driver, FIRST_NAME).sendKeys(fname);
		WaitUtil.waitForVisible(driver, LAST_NAME).sendKeys(lname);
		WaitUtil.waitForVisible(driver, ADDRESS).sendKeys(address);
		WaitUtil.waitForVisible(driver, CITY).sendKeys(city);
		WaitUtil.waitForVisible(driver, STATE).sendKeys(state);
		WaitUtil.waitForVisible(driver, ZIP_CODE).sendKeys(zip);
		WaitUtil.waitForVisible(driver, PHONE_NUMBER).sendKeys(phone);
		WaitUtil.waitForVisible(driver, SSN).sendKeys(ssn);
		WaitUtil.waitForVisible(driver, USERNAME).sendKeys(username);
		WaitUtil.waitForVisible(driver, PASSWORD).sendKeys(password);
		WaitUtil.waitForVisible(driver, CONFIRM_PASSWORD).sendKeys(confirm_password);

	}

	public void clickRegister() {

		WaitUtil.waitForClickable(driver, SUBMIT_BUTTON).click();
	}
}