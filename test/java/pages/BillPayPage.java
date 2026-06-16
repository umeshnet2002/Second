package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import utilities.WaitUtil;

public class BillPayPage {
	WebDriver driver = DriverFactory.getDriver();

	private static final By BILL_PAY_LINK = By.cssSelector("a[href='billpay.htm']");
	private static final By PAYEE_NAME = By.name("payee.name");
	private static final By PAYEE_ADDRESS = By.name("payee.address.street");
	private static final By PAYEE_CITY = By.name("payee.address.city");
	private static final By PAYEE_STATE = By.name("payee.address.state");
	private static final By PAYEE_ZIP = By.name("payee.address.zipCode");
	private static final By PAYEE_PHONE = By.name("payee.phoneNumber");
	private static final By PAYEE_ACCOUNT = By.name("payee.accountNumber");
	private static final By VERIFY_ACCOUNT = By.name("verifyAccount");
	private static final By AMOUNT = By.name("amount");
	private static final By SUBMIT_BUTTON = By.cssSelector("input[value='Send Payment']");

	public void clickBillPay() {
		WaitUtil.waitForClickable(driver, BILL_PAY_LINK).click();
	}

	public void enterPayeeDetails(String name, String address, String city, String state, String zip, String phone,
			String account, String verifyAccount, String amount) {
		WaitUtil.waitForVisible(driver, PAYEE_NAME).sendKeys(name);
		WaitUtil.waitForVisible(driver, PAYEE_ADDRESS).sendKeys(address);
		WaitUtil.waitForVisible(driver, PAYEE_CITY).sendKeys(city);
		WaitUtil.waitForVisible(driver, PAYEE_STATE).sendKeys(state);
		WaitUtil.waitForVisible(driver, PAYEE_ZIP).sendKeys(zip);
		WaitUtil.waitForVisible(driver, PAYEE_PHONE).sendKeys(phone);
		WaitUtil.waitForVisible(driver, PAYEE_ACCOUNT).sendKeys(account);
		WaitUtil.waitForVisible(driver, VERIFY_ACCOUNT).sendKeys(verifyAccount);
		WaitUtil.waitForVisible(driver, AMOUNT).sendKeys(amount);
	}

	public void clickSubmit() {
		WaitUtil.waitForClickable(driver, SUBMIT_BUTTON).click();
	}

}
