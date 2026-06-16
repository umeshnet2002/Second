package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.TransferFundsPage;

public class TransferFundsSteps {
	private final TransferFundsPage transferFunds = new TransferFundsPage();

	@And("clicks on Transfer Funds link")
	public void clicks_on_transfer_funds_link() {
		transferFunds.clickTransferFunds();
	}

	@And("enter amount to transfer")
	public void enter_amount_to_transfer() {
		transferFunds.enterAmount();
	}

	@And("selects to and from account")
	public void selects_to_and_from_account() {
		transferFunds.selectToAccount();
	}

	@And("clicks on transfer button")
	public void clicks_on_transfer_button() {
		transferFunds.clickTransfer();
	}

	@Then("validate transfer result")
	public void validate_transfer_result() {
		final SoftAssert soft = new SoftAssert();

//		System.out.println(DriverFactory.getDriver().getCurrentUrl());
//		System.out.println(DriverFactory.getDriver().getTitle());
//		System.out.println(DriverFactory.getDriver().findElement(By.xpath("//h1")).toString());

		// Critical validation
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("transfer"), "Transfer funds failed");

		// Additional validations
		soft.assertEquals(DriverFactory.getDriver().getTitle(), "ParaBank | Transfer Funds", "Funds Transfer title mismatch");

		soft.assertTrue(DriverFactory.getDriver().findElement(By.xpath("//h1")).isDisplayed(), "Transfer heading missing");

		soft.assertAll();
		System.out.println("Funds Transferred Successfully");

	}

}
