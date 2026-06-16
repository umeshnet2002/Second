package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.OpenNewAccountPage;

public class OpenNewAccountSteps {
	private final OpenNewAccountPage openNewAccount = new OpenNewAccountPage();

	@And("clicks on Open New Account link")
	public void clicks_on_open_new_account_link() {
		openNewAccount.clickOpenNewAccount();

	}

	@And("selects account type")
	public void selects_account_type() {
		openNewAccount.selectAccountType();

	}

	@And("clicks on open new account button")
	public void clicks_on_open_new_account_button() throws InterruptedException {
		openNewAccount.clickSubmit();
	}

	@Then("validate account open result")
	public void validate_account_open_result() {
		final SoftAssert soft = new SoftAssert();

//		System.out.println(DriverFactory.getDriver().getCurrentUrl());
//		System.out.println(DriverFactory.getDriver().getTitle());
//		System.out.println(DriverFactory.getDriver().findElement(By.xpath("//h1")).toString());

		// Critical validation
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("activity"), "Account creation failed");

		// Additional validations
		soft.assertEquals(DriverFactory.getDriver().getTitle(), "ParaBank | Account Activity", "Account title mismatch");

		soft.assertTrue(DriverFactory.getDriver().findElement(By.xpath("//h1")).isDisplayed(), "Login heading missing");

		soft.assertAll();
		System.out.println("New Account Opened Successfully");

	}

}
