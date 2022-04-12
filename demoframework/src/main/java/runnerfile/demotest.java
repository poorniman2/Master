package runnerfile;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import factory.DriverFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import util.screenshot;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "classpath:featurefiles",
		glue= {"stepdefinitions","ApplicationHooks"},
		monochrome=true,
		tags= "@smoke or @sanity",
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		publish=true
		)
public class demotest {
	
	@BeforeClass
	public static void action()
	{
		screenshot screen = new screenshot(DriverFactory.getDriver());
		System.out.println("action class ");
		screen.createNewFile();

	}
}

