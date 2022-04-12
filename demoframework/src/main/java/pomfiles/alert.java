package pomfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class alert {
	
	private WebDriver driver;

	public alert(WebDriver driver) {
		this.driver = driver;
	}
	
	public String alertcheck(String alertType) throws InterruptedException
	 {String message = "";
		 WebElement alert=driver.findElement(By.xpath("//button[@id='"+alertType+"']"));
		 switch(alertType)
		 {
		 case "alertButton":
			 alert.click();
			 message= driver.switchTo().alert().getText();
			 driver.switchTo().alert().accept();
			 break;
			 
		 case "timerAlertButton":
			 alert.click();
			 Thread.sleep(6000);
			 message= driver.switchTo().alert().getText();
			 driver.switchTo().alert().accept();
			 break;
			 
		 case "confirmButton":
			 alert.click();
			 driver.switchTo().alert().accept();
			 Thread.sleep(6000);
			 message=driver.findElement(By.xpath("//span[@id='confirmResult']")).getText();
			 break;
		 case "promtButton":
			 alert.click();
			 Thread.sleep(6000);
			 driver.switchTo().alert().sendKeys("Test");
			 driver.switchTo().alert().accept();
			 Thread.sleep(6000);
			 message=driver.findElement(By.xpath("//span[@id='promptResult']")).getText();
			 break;	 
		default:
			message="Please enter valid button type";
		 }
		return message;
	 }
}
