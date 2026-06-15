package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void initDriver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();

			// Required for Docker/Linux containers
			options.addArguments("--headless=new");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-gpu");
			options.addArguments("--window-size=1920,1080");

			driver.set(new ChromeDriver(options));

		}

		else if (browser.equalsIgnoreCase("firefox")) {

			driver.set(new FirefoxDriver());
		}

		else if (browser.equalsIgnoreCase("edge")) {

//			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();

			options.addArguments("--headless=new");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-gpu");
			options.addArguments("--window-size=1920,1080");

			driver.set(new EdgeDriver(options));
		}

		getDriver().manage().window().maximize();
	}

	public static WebDriver getDriver() {

		return driver.get();
	}

	public static void quitDriver() {

		if (getDriver() != null) {

			getDriver().quit();

			driver.remove();
		}
	}
}