package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.DriverFactory;
import io.cucumber.java.en.*;

import pages.LoginPage;
import utilities.ExcelUtil;

public class LoginSteps {

	private final LoginPage login = new LoginPage();
	private final ExcelUtil excel = new ExcelUtil("src/test/resources/testdata/LogData.xlsx");

	@Given("user enters username and password")

	public void enterCredentials() {
		final String username = excel.getCellData("sheet1", 1, 0);

		final String password = excel.getCellData("sheet1", 1, 1);

		login.enterCredentials(username, password);

	}

	@When("clicks on login button")

	public void clickLogin() {

		login.clickLogin();
	}

	@Then("validate login result")

	public void validateLogin() {
		final SoftAssert soft = new SoftAssert();

//		System.out.println(DriverFactory.getDriver().getCurrentUrl());
//		System.out.println(DriverFactory.getDriver().getTitle());
//		System.out.println(DriverFactory.getDriver().findElement(By.xpath("//h1")).toString());

		// Critical validation
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("overview"), "Login Failed");

		// Additional validations
		soft.assertEquals(DriverFactory.getDriver().getTitle(), "ParaBank | Accounts Overview", "Login title mismatch");

		soft.assertTrue(DriverFactory.getDriver().findElement(By.xpath("//h1")).isDisplayed(), "Login heading missing");

		soft.assertAll();

		System.out.println("Login Successful");
		

	}
}