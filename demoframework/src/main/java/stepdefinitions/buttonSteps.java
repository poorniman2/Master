package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomfiles.button;

public class buttonSteps {
	String message;
	boolean flag = false;
	private button buttons = new button(DriverFactory.getDriver());

	@Given("User is on {string}")
	public void user_is_on_httpsdemoqacombuttons(String url) throws Throwable {
		DriverFactory.getDriver().get("https://demoqa.com/buttons");
		DriverFactory.getDriver().manage().window().maximize();
	}

	@When("User enters following details with columns")
	public void user_enters_following_details_with_columns(DataTable data) throws Throwable {
		List<Map<String, String>> buttonTypes = data.asMaps(String.class, String.class);
		System.out.println(buttonTypes.size());
		int size = buttonTypes.size() - 1;
		for (int i = 0; i <= size; i++) {
			String buttontype = buttonTypes.get(i).get("ButtonType");
			String expectedmessage = buttonTypes.get(i).get("Message");
			String actualmessage = buttons.buttonClick(buttontype);
			if (actualmessage.equals(expectedmessage)) {
				flag = true;
			}
			else
			{
				System.out.println("incorrect message is displayed");
			}
		}

	}

	@Then("validate the message displayed")
	public void validate_the_message_displayed() throws Throwable {

	}
}
