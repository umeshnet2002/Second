package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.DriverFactory;
import io.cucumber.java.en.*;

import pages.RegistrationPage;

public class RegistrationSteps {
	private final RegistrationPage reg = new RegistrationPage();

	@Given("Para Bank home page is open")
	public void home_page() {
		reg.home();
	}

	@Given("user clicks Register option")
	public void register_option() {
		reg.Click();
	}

	@When("enters necessary credentials {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void credentials(String fname, String lname, String address, String city, String state, String zip,
			String phone, String ssn, String username, String password, String confirm_password) {
		reg.add_credentials(fname, lname, address, city, state, zip, phone, ssn, username, password, confirm_password);

	}

	@And("clicks register button")
	public void register_button() {
		reg.clickRegister();
	}

	@Then("validate registration result")
	public void registration_should_complete() {
		final SoftAssert soft = new SoftAssert();

		final String url = DriverFactory.getDriver().getCurrentUrl();

//		System.out.println(url);
//		System.out.println(DriverFactory.getDriver().getTitle());
//		System.out.println(DriverFactory.getDriver().findElement(By.xpath("//h1")).toString());

		// Critical
		Assert.assertTrue(url.contains("register"), "Registration Failed");

		// Extra validations
		soft.assertEquals(DriverFactory.getDriver().getTitle(), "ParaBank | Customer Created",
				"Title mismatch");

		soft.assertTrue(DriverFactory.getDriver().findElement(By.xpath("//h1")).isDisplayed(),
				"Page heading not displayed");

		soft.assertAll();

		System.out.println("Registration successful");

	}

}