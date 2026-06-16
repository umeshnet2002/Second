package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.FindTransactionsPage;

public class FindTransactionsSteps {
	private final FindTransactionsPage findTransactionsPage = new FindTransactionsPage();

	@And("clicks on Find Transactions link")
	public void clicks_on_find_transactions_link() {
		findTransactionsPage.clickFindTransactions();
	}

	@And("enter transaction details {string} {string}")
	public void enter_transaction_details(String fromDate, String toDate) {
		findTransactionsPage.enterDateRange(fromDate, toDate);
	}

	@And("clicks on find transaction button")
	public void clicks_on_find_transaction_button() {
		findTransactionsPage.clickFind();
	}

	@Then("validate transaction search result")
	public void validate_transaction_search_result() {
		final SoftAssert soft = new SoftAssert();

//	System.out.println(DriverFactory.getDriver().getCurrentUrl());
//	System.out.println(DriverFactory.getDriver().getTitle());
//	System.out.println(DriverFactory.getDriver().findElement(By.xpath("//h1")).toString());

		// Critical validation
	Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("parabank"), "Finding transactions failed");

		// Additional validations
	soft.assertEquals(DriverFactory.getDriver().getTitle(), "ParaBank | Find Transactions", "Transactions title mismatch");

	soft.assertTrue(DriverFactory.getDriver().findElement(By.xpath("//h1")).isDisplayed(), "Transactions heading missing");

	soft.assertAll();
		System.out.println("Transaction Search Validated Successfully");
	}

}
