package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import utilities.WaitUtil;

public class RequestLoanPage {
	WebDriver driver = DriverFactory.getDriver();
	
//	private static final By REQUEST_LOAN_LINK = By.cssSelector("a[href='requestloan.htm']");
	private static final By REQUEST_LOAN_LINK = By.linkText("Request Loan");
	private static final By LOAN_AMOUNT = By.id("amount");
	private static final By DOWN_PAYMENT = By.id("downPayment");
	private static final By APPLY_NOW = By.cssSelector("input[value='Apply Now']");
	
	public void clickRequestLoan() {
		WaitUtil.waitForClickable(driver, REQUEST_LOAN_LINK).click();
		
	}
	
	public void enterLoanDetails(String amount, String downPayment) {
		WaitUtil.waitForVisible(driver, LOAN_AMOUNT).sendKeys(amount);
		WaitUtil.waitForVisible(driver, DOWN_PAYMENT).sendKeys(downPayment);
	}
	
	public void clickApplyNow() {
		WaitUtil.waitForClickable(driver, APPLY_NOW).click();
	}

}
