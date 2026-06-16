package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.WaitUtil;

import base.DriverFactory;

public class OpenNewAccountPage {
	WebDriver driver = DriverFactory.getDriver();
	
//	private static final By OPEN_NEW_ACCOUNT = By.cssSelector("a[href='openaccount.htm']");
	private static final By OPEN_NEW_ACCOUNT = By.linkText("Open New Account");
	private static final By ACCOUNT_TYPE = By.id("type");
	private static final By SUBMIT_BUTTON = By.cssSelector("input[value='Open New Account']");
	private static final By ACCOUNT_DETAILS = By.id("newAccountId");
	
	
	public void clickOpenNewAccount() {
		
		WaitUtil.waitForClickable(driver, OPEN_NEW_ACCOUNT).click();
	}
	
	public void selectAccountType() {
		WebElement acc_type = WaitUtil.waitForVisible(driver, ACCOUNT_TYPE);
		acc_type.click();
		acc_type.sendKeys(Keys.ARROW_DOWN);
		acc_type.sendKeys(Keys.ENTER);
	}
	
	public void clickSubmit() throws InterruptedException {
		Thread.sleep(1000);
		WaitUtil.waitForClickable(driver, SUBMIT_BUTTON).click();
		WaitUtil.waitForClickable(driver, ACCOUNT_DETAILS).click();
		
	}

}
