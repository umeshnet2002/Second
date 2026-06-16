package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.BillPayPage;

public class BillPaySteps {
	private final BillPayPage billPayPage = new BillPayPage();

	@And("clicks on Bill Pay link")
	public void clicks_on_bill_pay_link() {
		billPayPage.clickBillPay();
	}

	@And("enter bill pay details {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void enter_bill_pay_details(String name, String address, String city, String state, String zip, String phone,
			String account, String verifyAccount, String amount) {
		billPayPage.enterPayeeDetails(name, address, city, state, zip, phone, account, verifyAccount, amount);
	}

	@And("clicks on send payment button")
	public void clicks_on_send_payment_button() {
		billPayPage.clickSubmit();
	}

	@Then("validate bill pay information update result")
	public void validate_bill_pay_information_update_result() {
		final SoftAssert soft = new SoftAssert();

//		System.out.println(DriverFactory.getDriver().getCurrentUrl());
//		System.out.println(DriverFactory.getDriver().getTitle());
//		System.out.println(DriverFactory.getDriver().findElement(By.xpath("//h1")).toString());

		// Critical validation
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("billpay"), "Bill Failed");

		// Additional validations
		soft.assertEquals(DriverFactory.getDriver().getTitle(), "ParaBank | Bill Pay", "Bill title mismatch");

		soft.assertTrue(DriverFactory.getDriver().findElement(By.xpath("//h1")).isDisplayed(), "Bill heading missing");

		soft.assertAll();
		System.out.println("Bill Pay Information Updated Successfully");
	}

}
