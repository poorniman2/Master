package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.asserts.SoftAssert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomfiles.browserWindow;
import util.screenshot;

public class browserWindowsSteps {
	Scenario scenario;
	File file;
	boolean flag = false;
	SoftAssert softassert = new SoftAssert();
	browserWindow browserwindow=new browserWindow(DriverFactory.getDriver());
	screenshot screen=new screenshot(DriverFactory.getDriver());
	@Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        
    }
	@Before
    public void createSeperateFolder() {
		String className = this.getClass().getName();
		String newname=className.substring(className.indexOf(".")+1, className.length());
		System.out.println("new class name is "+newname);
		file=screen.createNewFileWithClassName(newname);
		
    }
	@Given("user is on {string}")
	public void user_is_on(String url) {

		DriverFactory.getDriver().get(url);
		DriverFactory.getDriver().manage().window().maximize();
	}

	@Then("Page header should be {string}")
	public void page_header_should_be(String header) throws IOException {
		String actialHeader=browserwindow.getPageHeader();
		softassert.assertTrue(header.equals(actialHeader), "Page header is incorrect");
		screen.tearDown(scenario,"verify header page",file);
	 
	}

	@When("User clicks on the below broser window buttons")
	public void user_clicks_on_the_below_broser_window_buttons(DataTable data) throws InterruptedException, IOException {
		List<Map<String, String>> windowButtons = data.asMaps(String.class, String.class);
		int size = windowButtons.size() - 1;
		for (int i = 0; i <= size; i++) {
			String windowType = windowButtons.get(i).get("windowType");
			String expectedmessage = windowButtons.get(i).get("Message");
			String actualmessage = browserwindow.windowClick(windowType);
			screen.tearDown(scenario,"window button clicks",file);
			if (actualmessage.equals(expectedmessage)) {
				flag = true;
			}
			else
			{
				System.out.println("incorrect message is displayed");
			}
		}
	   
	}
}
