package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import utilities.WaitUtil;

public class RegistrationPage {

	WebDriver driver = DriverFactory.getDriver();
	By account = By.cssSelector("a[title='My Account']");

	public void registration(String fname, String lname, String email, String phone, String password) {

		WaitUtil.waitForClickable(driver, account).click();
		WaitUtil.waitForClickable(driver, By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[1]")).click();
		WaitUtil.waitForVisible(driver, By.id("input-firstname")).sendKeys(fname);

		WaitUtil.waitForVisible(driver, By.id("input-lastname")).sendKeys(lname);

		WaitUtil.waitForVisible(driver, By.id("input-email")).sendKeys(email);

		WaitUtil.waitForVisible(driver, By.id("input-telephone")).sendKeys(phone);

		WaitUtil.waitForClickable(driver, By.id("input-password")).sendKeys(password);

		WaitUtil.waitForVisible(driver, By.id("input-confirm")).sendKeys(password);

		WaitUtil.waitForClickable(driver, By.cssSelector("input[name='agree']")).click();

		WaitUtil.waitForClickable(driver, By.cssSelector("input[value='Continue']")).click();

		WaitUtil.waitForClickable(driver, By.xpath("//*[@id='content']/div/div/a")).click();

	}

}