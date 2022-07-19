package parallel2;

import java.util.List;
import java.util.Map;

import org.testng.asserts.SoftAssert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomfiles.frames;

public class frameSteps {
	private frames frame = new frames(DriverFactory.getDriver());
	boolean flag = false;
	SoftAssert softassert = new SoftAssert();

	@Given("User is on {string} frames Page")
	public void user_is_on_frames_page(String url) {
		DriverFactory.getDriver().get(url);
		DriverFactory.getDriver().manage().window().maximize();
		
		
	}
	

	@When("User clicks on the below frame button")
	public void user_clicks_on_the_below_frame_button(DataTable data) throws InterruptedException {
		List<Map<String, String>> frames = data.asMaps(String.class, String.class);
		System.out.println(frames.size());
		int size = frames.size() - 1;
		for (int i = 0; i <= size; i++) {
			String frameactions = frames.get(i).get("Frameid");
			String expectedmessage = frames.get(i).get("Message");
			String actualmessage = frame.frameCheck(frameactions);
			System.out.println("actualmessage displayed "+actualmessage);
			if (actualmessage.equals(expectedmessage))  {
				flag = true;
			} else {
				System.out.println("incorrect message is displayed");
			}
		}
	}

	@Then("Validate the message displayed for frames")
	public void validate_the_message_displayed_for_frames() {
		softassert.assertTrue(flag);
	}

}
