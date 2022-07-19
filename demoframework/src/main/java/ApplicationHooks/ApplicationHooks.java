package ApplicationHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.configReader;

public class ApplicationHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private configReader configreader;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configreader = new configReader();
		prop = configreader.init_prop();
		System.out.println("demo");
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("Browser");
		System.out.println(browserName);
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@AfterStep
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed() || (!scenario.isFailed())) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			System.out.println("name is " + screenshotName);
			byte[] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotName);

		}
	}
}
