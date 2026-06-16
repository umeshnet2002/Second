package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import base.DriverFactory;
import dataproviders.TestDataProviders;
import pages.LoginPage;
import utilities.ExcelUtil;

public class LoginTest extends BaseClass {

	@Test(priority = 2, enabled = true)
	public void login() {

		LoginPage loginPage = new LoginPage();

		final ExcelUtil excel = new ExcelUtil("src/test/resources/testdata/LogData.xlsx");
		final String email = excel.getCellData("sheet1", 1, 0);

		final String password = excel.getCellData("sheet1", 1, 1);

		loginPage.login(email, password);

		String actualUrl = DriverFactory.getDriver().getCurrentUrl();
//		System.out.println(actualUrl);

		Assert.assertTrue(actualUrl.contains("login"), "Login failed!");
		
		System.out.println("Login successful");

	}
}