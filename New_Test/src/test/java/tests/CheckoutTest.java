package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import base.DriverFactory;
import dataproviders.TestDataProviders;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.SearchPage;
import utilities.ExcelUtil;

public class CheckoutTest extends BaseClass{
  @Test(priority = 4, enabled = true, dataProvider = "CheckoutData", dataProviderClass = TestDataProviders.class)
  public void checkout(String product) {
		LoginPage loginPage = new LoginPage();
		SearchPage searchPage = new SearchPage();
		CheckoutPage checkoutPage = new CheckoutPage();

		final ExcelUtil excel = new ExcelUtil("src/test/resources/testdata/LogData.xlsx");
		final String email = excel.getCellData("sheet1", 1, 0);

		final String password = excel.getCellData("sheet1", 1, 1);

		loginPage.login(email, password);
		
		searchPage.searchProduct(product);
		
		checkoutPage.addProductToCart();
		checkoutPage.checkout();
		
		String actualUrl = DriverFactory.getDriver().getCurrentUrl();
//		System.out.println(actualUrl);

		Assert.assertTrue(actualUrl.contains("checkout"), "Checkout failed!");
		
		System.out.println("Checkout successful");

  }
}
