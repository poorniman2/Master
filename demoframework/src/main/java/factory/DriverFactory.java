package factory;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
public static WebDriver driver = null;
//private String url;
/*public static WebDriver getWebDriverForBrowser(String browser)
{
	switch (browser.toLowerCase())
	{
	case "chrome":
		driver= new ChromeDriver();
		
	case "firefox":
		driver = new FirefoxDriver();
		
	case "headless":
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200*600");
		driver = new ChromeDriver(options);
		break;
		
	default:
		driver = new ChromeDriver();
		
	
	}
	return driver;
}*/
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	
	
	public WebDriver init_driver(String browser)
	{
		System.out.println("Browser is "+browser);
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			//driver=tlDriver.get();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			//driver=tlDriver.get();
		}
		else
		{
			System.out.println("Browser is incorrect "+browser);
		}
		//getDriver().manage().deleteAllCookies();
	//	getDriver().manage().window().maximize();
		return getDriver();
		//return tlDriver.get();
		
		
	}

	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	
	




}
