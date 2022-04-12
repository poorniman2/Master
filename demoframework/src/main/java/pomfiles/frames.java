package pomfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class frames {
	private WebDriver driver;
	 public frames(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 public String frameCheck(String frameid) throws InterruptedException
	 {String message = null;
		 WebElement frame=driver.findElement(By.xpath("//iframe[@id='"+frameid+"']"));
		 switch(frameid)
		 {
		 case "frame1":
			 
			 driver.switchTo().frame(frame);
			 Thread.sleep(6000);
			 message= driver.findElement(By.id("sampleHeading")).getText();
			 driver.switchTo().defaultContent();
			 break;
			 
		 case "frame2":
			 driver.switchTo().defaultContent();
			 driver.switchTo().frame(frame);
			 Thread.sleep(6000);
			 message= driver.findElement(By.id("sampleHeading")).getText();
			 driver.switchTo().defaultContent();
			 break;
		default:
			message="Please enter valid frame id";
		 }
		return message;
	 }
}
