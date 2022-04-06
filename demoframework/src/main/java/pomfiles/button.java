package pomfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class button {
	private WebDriver driver;
	 public button(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 public String buttonClick(String buttonType) throws InterruptedException
	 {String message = null;
	 Actions act = new Actions(driver);
		 WebElement button=driver.findElement(By.xpath("//button[text()='"+buttonType+"']"));
		 switch(buttonType)
		 {
		 case "Double Click Me":
			 
			 act.doubleClick(button).perform();
			 Thread.sleep(6000);
			 message= driver.findElement(By.id("doubleClickMessage")).getText();
			 break;
			 
		 case "Right Click Me":
			 act.contextClick(button).perform();
			 Thread.sleep(6000);
			 message=driver.findElement(By.id("rightClickMessage")).getText();
			 break;
			 
		 case "Click Me":
			 button.click();
			 Thread.sleep(6000);
			 message=driver.findElement(By.id("dynamicClickMessage")).getText();
			 break;
		default:
			message="Please enter valid button type";
		 }
		return message;
	 }
}
