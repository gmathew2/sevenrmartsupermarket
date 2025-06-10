package com.sevenrmartsupermarket.pages;

	import java.time.Duration;

	import org.openqa.selenium.By;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class AdminUsersMoreInfoPage 
	{

		WebDriver driver;
		@FindBy(xpath="(//a[@class='small-box-footer'])[1]")
		private WebElement MoreInfobutton;
		@FindBy(xpath="(//span[text()='Active'])[1]")
		private WebElement ActiveStatus;
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
		
		
		
		public AdminUsersMoreInfoPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this); 
			
		}
		
		public String clickMoreInfobuttonbackgroundcolor()
		{
			MoreInfobutton.click();
			return ActiveStatus.getCssValue("background-color");
			
		}
		
		public void createNewUser()
		{
			
			MoreInfobutton.click();
			AddUser.click();
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Admin Users Informations')]")));
			NewUserName.sendKeys("Lanka");
			NewPassword.sendKeys("Lanka");
			Select select =new Select(SelectType);
			SelectType.click();
	      	select.selectByValue("Staff");
	      	Save.click();
			
		}
		
		
}

