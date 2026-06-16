package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import utilities.WaitUtil;

public class FindTransactionsPage {
	WebDriver driver = DriverFactory.getDriver();

	private static final By FIND_TRANSACTIONS_LINK = By.cssSelector("a[href='findtrans.htm']");
	private static final By FROM_DATE = By.id("fromDate");
	private static final By TO_DATE = By.id("toDate");
	private static final By FIND_BUTTON = By.id("findByDateRange");

	public void clickFindTransactions() {
		WaitUtil.waitForClickable(driver, FIND_TRANSACTIONS_LINK).click();
	}

	public void enterDateRange(String from, String to) {
		WaitUtil.waitForVisible(driver, FROM_DATE).sendKeys(from);
		WaitUtil.waitForVisible(driver, TO_DATE).sendKeys(to);
	}

	public void clickFind() {
		WaitUtil.waitForClickable(driver, FIND_BUTTON).click();
	}

}
