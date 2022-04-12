package parallel2;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:parallel2", glue = { "parallel2",
		"ApplicationHooks" }, monochrome = true, plugin = { "pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, publish = true)
	
	public class parallelRun extends AbstractTestNGCucumberTests  {
		@Override
		 @DataProvider(parallel = false)
		public Object[][] scenarios() {
			return super.scenarios();
		}

	}
