package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import base.DriverFactory;
import dataproviders.TestDataProviders;
import pages.RegistrationPage;

public class RegistrationTest extends BaseClass {
	@Test(priority = 1, enabled = true, dataProvider = "RegistrationData", dataProviderClass = TestDataProviders.class)
	public void registration(String fname, String lname, String email, String phone, String password)
			throws InterruptedException {
		RegistrationPage pompages = new RegistrationPage();

		pompages.registration(fname, lname, email, phone, password);
		
		 String actualUrl = DriverFactory.getDriver().getCurrentUrl();
//		   System.out.println(actualUrl);

		    Assert.assertTrue(actualUrl.contains("account"), "Registration failed!");

	}
}