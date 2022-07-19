package parallel2;

import java.util.ArrayList;
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
		String s1= "my name is poornima";
		String strArray[] = s1.split(" ");
		System.out.println("size of string array is "+strArray.length);
		List<StringBuilder> s2 =new ArrayList<StringBuilder>();
		for(int i=0;i<strArray.length;i++)
		{
			String s3=strArray[i];
			StringBuilder input1 = new StringBuilder();
			input1.append(s3);
			input1.reverse();
			s2.add(input1);
			
			
			
		}
		System.out.println("final string is "+s2);
		 for (int k = 0; k < s2.size(); k++) {
	            // Printing the elements of String array
	            System.out.print(s2.get(k) + " ");
	        }
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
