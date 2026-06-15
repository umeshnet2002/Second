package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import dataproviders.TestDataProviders;
import pages.RegistrationPage;

public class RegistrationTest extends BaseClass {
	@Test(priority = 1, enabled = true, dataProvider = "RegistrationData", dataProviderClass = TestDataProviders.class)
	public void registration(String fname, String lname, String email, String phone, String password)
			throws InterruptedException {
		RegistrationPage pompages = new RegistrationPage();

		pompages.registration(fname, lname, email, phone, password);

	}
}