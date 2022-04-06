package runnerfile;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "classpath:featurefiles",
		glue= {"stepdefinitions","ApplicationHooks"},
		monochrome=true,
		tags="@smoke",
		plugin= {"pretty",
				"html:target/cucumber-reports.html"},
		publish=true
		
		)
public class demotest {

}
