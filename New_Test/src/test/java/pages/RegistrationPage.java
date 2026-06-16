package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import utilities.WaitUtil;

public class RegistrationPage {

    WebDriver driver = DriverFactory.getDriver();

    private final By myAccount = By.cssSelector("a[title='My Account']");
    private final By registerLink = By.linkText("Register");

    private final By firstName = By.id("input-firstname");
    private final By lastName = By.id("input-lastname");
    private final By emailField = By.id("input-email");
    private final By telephone = By.id("input-telephone");
    private final By passwordField = By.id("input-password");
    private final By confirmPassword = By.id("input-confirm");

    private final By privacyPolicy = By.name("agree");
    private final By continueBtn = By.cssSelector("input[value='Continue']");

    // Success page
//    private final By successMsg =
//            By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");

    private final By successContinueBtn =
            By.linkText("Continue");

    public void registration(String fname, String lname,
                             String email, String phone,
                             String password) {

        WaitUtil.waitForClickable(driver, myAccount).click();
        WaitUtil.waitForClickable(driver, registerLink).click();

        WaitUtil.waitForVisible(driver, firstName).sendKeys(fname);
        WaitUtil.waitForVisible(driver, lastName).sendKeys(lname);
        WaitUtil.waitForVisible(driver, emailField).sendKeys(email);
        WaitUtil.waitForVisible(driver, telephone).sendKeys(phone);
        WaitUtil.waitForVisible(driver, passwordField).sendKeys(password);
        WaitUtil.waitForVisible(driver, confirmPassword).sendKeys(password);

        WaitUtil.waitForClickable(driver, privacyPolicy).click();
        WaitUtil.waitForClickable(driver, continueBtn).click();

//        // Verify registration success
//        WaitUtil.waitForVisible(driver, successMsg);
//
//        // Click Continue
//        WaitUtil.waitForClickable(driver, successContinueBtn).click();
    }
}