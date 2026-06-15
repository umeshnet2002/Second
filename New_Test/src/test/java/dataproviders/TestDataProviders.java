package dataproviders;

import org.testng.annotations.DataProvider;

public class TestDataProviders {
	@DataProvider(name = "RegistrationData")
	public Object[][] getRegistrationData() {
		return new Object[][] { { "John", "Doe", "doejohn1234567813@gmail.com","12894967", "password123" }

		};
	}
	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() {
		return new Object[][] { {"doejohn@gmail.com","password123" }
		
		};
	}
	@DataProvider(name = "SearchData")
	public Object[][] getSearchData() {
		return new Object[][] {
			{"macbook"},
			{"iphone"}
		
		};
	}
	@DataProvider(name = "CheckoutData")
	public Object[][] getCheckoutData() {
		return new Object[][] {
			{"macbook"}
			
			
		};
	}
}