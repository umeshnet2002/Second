package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.DriverFactory;
import utilities.WaitUtil;

public class UpdateContactInfoPage {
	WebDriver driver = DriverFactory.getDriver();
	
//	private static final By UPDATE_CONTACT_INFO_LINK = By.cssSelector("a[href='updateprofile.htm']");
	private static final By UPDATE_CONTACT_INFO_LINK = By.linkText("Update Contact Info");
	private static final By ADDRESS = By.id("customer.phoneNumber");
	private static final By UPDATE_PROFILE = By.cssSelector("input[value='Update Profile']");
	
	public void clickUpdateContactInfo() {
		WaitUtil.waitForClickable(driver, UPDATE_CONTACT_INFO_LINK).click();
	}
	
	public void enterNewAddress(String newAddress) throws InterruptedException {
		Thread.sleep(2000); 
		WebElement add = WaitUtil.waitForVisible(driver, ADDRESS);
		add.clear();
		add.sendKeys(newAddress);
	}
	
	public void clickUpdateProfile() {
		driver.findElement(UPDATE_PROFILE).click();
	}

}
