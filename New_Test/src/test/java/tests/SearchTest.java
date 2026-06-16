package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import base.DriverFactory;
import dataproviders.TestDataProviders;
import pages.LoginPage;
import pages.SearchPage;
import utilities.ExcelUtil;

public class SearchTest extends BaseClass{
  @Test(priority = 3, enabled = true, dataProvider = "SearchData", dataProviderClass = TestDataProviders.class)
  public void search(String product) {
	  SearchPage searchPage = new SearchPage();
	  
		LoginPage loginPage = new LoginPage();

		final ExcelUtil excel = new ExcelUtil("src/test/resources/testdata/LogData.xlsx");
		final String email = excel.getCellData("sheet1", 1, 0);

		final String password = excel.getCellData("sheet1", 1, 1);

		loginPage.login(email, password);
	  
	  searchPage.searchProduct(product);
	  
		String actualUrl = DriverFactory.getDriver().getCurrentUrl();
//		System.out.println(actualUrl);

		Assert.assertTrue(actualUrl.contains("search"), "Search failed!");
		
		System.out.println("Search successful");

  }
}
