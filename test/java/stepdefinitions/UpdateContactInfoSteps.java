package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.UpdateContactInfoPage;

public class UpdateContactInfoSteps {
	UpdateContactInfoPage updateContactInfoPage = new UpdateContactInfoPage();

	@And("clicks on Update Contact Info link")
	public void clicks_on_update_contact_info_link() {
		updateContactInfoPage.clickUpdateContactInfo();
	}

	@And("update contact information {string}")
	public void update_contact_information(String newAddress) throws InterruptedException {
		updateContactInfoPage.enterNewAddress(newAddress);

	}

	@And("clicks on update contact information button")
	public void clicks_on_update_contact_information_button() {
		updateContactInfoPage.clickUpdateProfile();
	}

	@Then("validate contact information update result")
	public void validate_contact_information_update_result() {
		final SoftAssert soft = new SoftAssert();

//		System.out.println(DriverFactory.getDriver().getCurrentUrl());
//		System.out.println(DriverFactory.getDriver().getTitle());
//		System.out.println(DriverFactory.getDriver().findElement(By.xpath("//h1")).toString());

		// Critical validation
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("updateprofile"), "Update profile failed");

		// Additional validations
		soft.assertEquals(DriverFactory.getDriver().getTitle(), "ParaBank | Update Profile", "Update title mismatch");

		soft.assertTrue(DriverFactory.getDriver().findElement(By.xpath("//h1")).isDisplayed(), "Update heading missing");

		soft.assertAll();
		System.out.println("Contact Information Updated Successfully");
	}
}
