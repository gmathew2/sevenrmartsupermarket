package com.sevenrmartsupermarket.pages;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage 
{
	WebDriver driver;
	Properties properties = new Properties();
	@FindBy(xpath="(//input[@class='form-control'])[1]")
	private WebElement userNameField;
	@FindBy(xpath="(//input[@class='form-control'])[2]")
	private WebElement passwordField;
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	private WebElement signinButton;
	@FindBy(xpath="//div[contains(@class,'alert alert-danger alert-dismissible')]")
	private WebElement InvalidCredentialsMessage;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); //class used to initialize elements
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
	
	public void enterUserName(String userName)
	{
		userNameField.sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public void clickSignInButton()
	{
		WaitUtility waitutility=new WaitUtility(driver);
		waitutility.elementToBeClickable(signinButton, 60);
		signinButton.click();
	}
	
	public void login(String userName,String password)
	{
		enterUserName(userName);
		enterPassword(password);
		clickSignInButton();
	}
	
	public String getInvalid_Username_Password_Message()
	{
		return InvalidCredentialsMessage.getText();
		
	}
	
	public void login() // reads from config file
	{
		String userName=properties.getProperty("username");
		String password=properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickSignInButton();
	}
}
