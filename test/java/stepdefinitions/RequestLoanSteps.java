package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.RequestLoanPage;

public class RequestLoanSteps {
	private final RequestLoanPage requestLoan = new RequestLoanPage();

	@And("clicks on Request Loan link")
	public void clicks_on_request_loan_link() {
		requestLoan.clickRequestLoan();
	}

	@And("enter loan details {string} {string}")
	public void enter_loan_details(String amount, String downPayment) {
		requestLoan.enterLoanDetails(amount, downPayment);
	}

	@And("clicks on apply now button")
	public void clicks_on_apply_now_button() {
		requestLoan.clickApplyNow();
	}

	@Then("validate loan result")
	public void validate_loan_result() {
		final SoftAssert soft = new SoftAssert();

//		System.out.println(DriverFactory.getDriver().getCurrentUrl());
//		System.out.println(DriverFactory.getDriver().getTitle());
//		System.out.println(DriverFactory.getDriver().findElement(By.xpath("//h2")).toString());

		// Critical validation
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("requestloan"), "Request loan failed");

		// Additional validations
		soft.assertEquals(DriverFactory.getDriver().getTitle(), "ParaBank | Loan Request", "Loan title mismatch");

		soft.assertTrue(DriverFactory.getDriver().findElement(By.xpath("//h1")).isDisplayed(), "Loan heading missing");

		soft.assertAll();
		System.out.println("Loan Requested Successfully");
	}

}
