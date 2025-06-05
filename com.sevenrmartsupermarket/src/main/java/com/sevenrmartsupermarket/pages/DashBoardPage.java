package com.sevenrmartsupermarket.pages;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;

public class DashBoardPage 
{
	WebDriver driver;
	Properties properties = new Properties();
	@FindBy(xpath="//a[@class='d-block']")
	private WebElement profileNameElement;
	@FindBy(xpath="//p[contains(text(),'Manage Contact')]")
	private WebElement manageContact;
	@FindBy(xpath="//section[@class='content']//tbody//tr//td[2]")
	private WebElement emailId;
	@FindBy(xpath="//li[@class='nav-item dropdown']//a[@class='nav-link']")
	private WebElement profileIcon;
	@FindBy(xpath="//a[@class='dropdown-item'][2]")
	private WebElement logout_fromProfile;
	@FindBy(xpath="//p[contains(text(),'Settings')]")
	private WebElement menuSettings;
	@FindBy(xpath="//p[contains(text(),'Logout')]")
	private WebElement logout_fromSettings;
	@FindBy(xpath="//p[contains(text(),'Sign in to start your session')]")
	private WebElement signinText;

	
	public void logoutFromProfileIcon()
	{
		profileIcon.click();
		logout_fromProfile.click();
	}
	public void logoutFromMenuSettings()
	{
		menuSettings.click();
		logout_fromSettings.click();
	}
	
	public String getSigninPageText()
	{
		return signinText.getText();
	}


	public DashBoardPage(WebDriver driver)
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
	
	public String getContactUsEmailID()
	{
		manageContact.click();
		return emailId.getText();
	}
	
	public String getProfileName()
	{
		return profileNameElement.getText();
	}
}


