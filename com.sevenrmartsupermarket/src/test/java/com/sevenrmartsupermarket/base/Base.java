package com.sevenrmartsupermarket.base;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.CaptureScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base 
{
	public WebDriver driver;
	Properties properties = new Properties();
	CaptureScreenshot capturescreenshot= new CaptureScreenshot();
	
	public Base()
	{
		try
		{
			FileInputStream fileinputstream = new FileInputStream(Constants.CONFIG_FILEPATH);
			properties.load(fileinputstream);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void initialise(String browser, String url)
	{
		if(browser.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.contains("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser.contains("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	}
	
	@Parameters("browser")
	@BeforeMethod (enabled = false)
	public void launchBrowser(String browser)
	{
		String url=properties.getProperty("url");
		initialise(browser, url);
	}
	
	@BeforeMethod(enabled = true, alwaysRun = true)
	public void launchBrowser()
	{
		String url=properties.getProperty("url");
		String browser=properties.getProperty("browser");
		initialise(browser, url);
	}
	
	@AfterMethod(alwaysRun = true)
	public void terminate(ITestResult itestresult) //ITestResult is an interface used to know the status of a test case
	{
		if(itestresult.getStatus()==ITestResult.FAILURE)
		{
			capturescreenshot.takeScreenShot(driver, itestresult.getName());
		}
		driver.quit();
	}
}
