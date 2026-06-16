package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ConfigReader;

public class BaseClass {

	ConfigReader config;

	@BeforeMethod
	public void setUp() {

		config = new ConfigReader();
		DriverFactory.initDriver(config.getProperty("browser"));
		DriverFactory.getDriver().get(config.getProperty("url"));

	}

	@AfterMethod
	public void quitDriver() {
		DriverFactory.quitDriver();
	}

}