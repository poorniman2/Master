package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class screenshot {
	WebDriver driver;
	
	 public screenshot(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	public void tearDown(Scenario scenario, String name,File file) throws IOException 
	{
		if(scenario.isFailed() || (!scenario.isFailed()))
		{
		//	String location="./test-output/Screenshots";
		//	String screenshotName=name.replaceAll(" ", "_");
		//	System.out.println("name is "+screenshotName);
		//	byte[]  sourcepath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		//	scenario.attach(sourcepath, "image/png", screenshotName);
			 File screenshots = ((TakesScreenshot) driver) .getScreenshotAs(OutputType.FILE);
			String name1= screenshots.getName();
			System.out.println("name is "+name1);
			File dest = new File(file + name);
		//	FileUtils.copyFile(screenshots, file);
			FileUtils.copyFileToDirectory(screenshots, file);
		}
		
	}
	
	public File createNewFile()
	{
		String location="./test-output/Screenshots";
		 File file=new File(location);
		if(file.exists())
		{
			file.delete();
			file.mkdir();
		}
		else
		{
			file.mkdir();
		}
		return file;
	}
	
	public File createNewFileWithClassName(String classname)
	{
		String location="./test-output/Screenshots/"+classname;
		 File file=new File(location);
		if(file.exists())
		{
			file.delete();
			file.mkdir();
		}
		else
		{
			file.mkdir();
		}
		return file;
	}
	
			
	}


