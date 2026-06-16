package runners;

//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import listeners.TestListener;
import listeners.RetryListener;

//@RunWith(Cucumber.class)
@Listeners({ TestListener.class, RetryListener.class })
@CucumberOptions(

		features = "src/test/resources/features",

		glue = {

				"stepdefinitions", "hooks" },

		plugin = {

				"pretty",

				"html:reports/cucumber.html" }

//		,tags = "@Registration"

)

public class TestRunner extends AbstractTestNGCucumberTests {

	@Override

	@DataProvider(parallel = false)

	public Object[][] scenarios() {

		return super.scenarios();
	}
}