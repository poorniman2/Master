package pomfiles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class browserWindow {
	private WebDriver driver;

	public browserWindow(WebDriver driver) {
		this.driver = driver;
	}
public String getPageHeader()
{
	String header=driver.findElement(By.xpath("//div[@class='main-header']")).getText();
	return header;
	
}
	public String windowClick(String windowType) throws InterruptedException {
		String message = null;
		String mainWindowHandle;
		Set<String> allWindowHandles;
		WebElement windowButton = driver.findElement(By.xpath("//button[text()='" + windowType + "']"));
		switch (windowType) {
		case "New Tab":
			windowButton.click();
			Thread.sleep(6000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			message = driver.findElement(By.id("sampleHeading")).getText();
			System.out.println("New Tab message "+message);
			driver.close();
			driver.switchTo().window(tabs2.get(0));
			break;

		case "New Window":
			windowButton.click();
			mainWindowHandle = driver.getWindowHandle();
			allWindowHandles = driver.getWindowHandles();
			// Now iterate using Iterator
			Iterator<String> iterator = allWindowHandles.iterator();
			while (iterator.hasNext()) {
				String ChildWindow = iterator.next();
				if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
					driver.switchTo().window(ChildWindow);
					message = driver.findElement(By.id("sampleHeading")).getText();
					System.out.println("New window message "+message);
					driver.close();
				}
			}
			driver.switchTo().window(mainWindowHandle);
			System.out.println("switched to main window");
			break;
		default:
			message = "Please enter valid button type";
			break;
		}
		return message;
	}
}
