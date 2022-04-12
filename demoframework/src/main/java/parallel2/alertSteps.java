package parallel2;

import java.util.List;
import java.util.Map;

import org.testng.asserts.SoftAssert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomfiles.alert;

public class alertSteps {

	boolean flag = false;
	SoftAssert softassert = new SoftAssert();
	private alert alertsteps = new alert(DriverFactory.getDriver());
	@Given("User is on {string} Page")
	public void user_is_on_page(String url) {
		DriverFactory.getDriver().get(url);
		DriverFactory.getDriver().manage().window().maximize();
	}

	@When("User clicks on the below alert button")
	public void user_clicks_on_the_below_alert_button(DataTable data) throws InterruptedException {
		
		List<Map<String, String>> actionTypes = data.asMaps(String.class, String.class);
		System.out.println(actionTypes.size());
		int size = actionTypes.size() - 1;
		for (int i = 0; i <= size; i++) {
			String actions = actionTypes.get(i).get("AlertButton");
			String expectedmessage = actionTypes.get(i).get("Message");
			String actualmessage = alertsteps.alertcheck(actions);
			if (actualmessage.equals(expectedmessage)) {
				flag = true;
			}
			else
			{
				System.out.println("incorrect message is displayed");
			}
		}
	    
	}

	@Then("Validate the message displayed")
	public void validate_the_message_displayed() {
		softassert.assertTrue(flag);
	    
	}
}
