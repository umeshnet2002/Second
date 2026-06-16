package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.DriverFactory;
import utilities.WaitUtil;

public class TransferFundsPage {
	WebDriver driver = DriverFactory.getDriver();
	
//	private static final By TRANSFER_FUNDS_LINK = By.cssSelector("a[href='transfer.htm']");
	private static final By TRANSFER_FUNDS_LINK = By.linkText("Transfer Funds");
	private static final By TRANSFER_FUNDS = By.id("amount");
	private static final By TO_ACCOUNT = By.id("toAccountId");
	private static final By TRANSFER_BUTTON = By.cssSelector("input[value='Transfer']");
	
	public void clickTransferFunds() {
		WaitUtil.waitForClickable(driver, TRANSFER_FUNDS_LINK).click();
	}
	
	public void enterAmount() {
		WaitUtil.waitForVisible(driver, TRANSFER_FUNDS).sendKeys("50");
	}
	
	public void selectToAccount() {
		WebElement to_acc = WaitUtil.waitForVisible(driver, TO_ACCOUNT);
		to_acc.click();
		to_acc.sendKeys(Keys.ARROW_DOWN);
		to_acc.sendKeys(Keys.ENTER);
		
	}
	
	public void clickTransfer() {
		WaitUtil.waitForClickable(driver, TRANSFER_BUTTON).click();
	}
		
		

}
