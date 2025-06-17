package com.sevenrmartsupermarket.pages;

	import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class AdminUsersPage 
	{

		WebDriver driver;
		@FindBy(xpath="(//a[@class='small-box-footer'])[1]")
		private WebElement MoreInfobutton;
		@FindBy(xpath="(//span[text()='Active'])[1]")
		private WebElement ActiveStatus;
		@FindBy(xpath="//span[contains(text(),'Inactive')]")
		private WebElement inActiveStatus;
		@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
		private WebElement AddUser;
		@FindBy(xpath="//input[@id='username']")
		private WebElement NewUserName;
		@FindBy(xpath="//input[@id='password']")
		private WebElement NewPassword;
		@FindBy(xpath="//select[@id='user_type']")
		private WebElement SelectType;
		@FindBy(xpath="//button[@name='Create']")
		private WebElement Save;
		@FindBy(xpath="(//a[@class='btn btn-sm btn btn-success btncss'])[1]")
		private WebElement actionButton;
		@FindBy(xpath="//i[@class='fa fa-lock']")
		private WebElement lockedActionButton;
		@FindBy(xpath="//i[@class='fa fa-unlock']")
		private WebElement unlockedActionButton;
		@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]")
		private WebElement statusChangeAlert;
		@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
		private WebElement userSearchButton1;
		@FindBy(xpath="//div[contains(@class,'col-sm-6 form-group')]//input[@type='text'][1]")
		private WebElement searchUsernameField;
		@FindBy(xpath="(//select[@class='form-control'])[1]")
		private WebElement userTypeDropDown;
		@FindBy(xpath="//table[contains(@class,'table table-bordered table-hover table-sm')]//tbody//tr[1]")
		private WebElement userSearchResult;
		@FindBy(xpath="//button[@name='Search']")
		private WebElement userSearchButton2;
		@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
		private WebElement duplicateUsernameAlert;
		
		
		
		
		
		public AdminUsersPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this); 
			
		}
		
		public boolean isAdminMoreInfoEnabled()
		{
			return MoreInfobutton.isEnabled();
			
		}
		public String getStatusChangeAlertMessage()
		{
			MoreInfobutton.click();
			actionButton.click();
			return statusChangeAlert.getText();
			
		}
		public String getDuplicateUsernameAlertMessage(String userName,String newPassword, String userType)
		{
			createNewUser(userName,userName,userType);
			return duplicateUsernameAlert.getText();
			
		}
		public String getUserDetails(String userName)
		{
			MoreInfobutton.click();
			userSearchButton1.click();
			searchUsernameField.sendKeys(userName);
			userSearchButton2.click();
			return userSearchResult.getText();
		}
		public String createNewUser(String userName,String newPassword, String userType)
		{
			
			MoreInfobutton.click();
			AddUser.click();
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Admin Users Informations')]")));
			NewUserName.sendKeys(userName);
			NewPassword.sendKeys(newPassword);
			Select select =new Select(SelectType);
			SelectType.click();
	      	select.selectByValue(userType);
	      	Save.click();
	      	return statusChangeAlert.getText();
		}
		
	
		
		
}

