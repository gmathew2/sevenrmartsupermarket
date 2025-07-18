package com.sevenrmartsupermarket.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTests extends Base
{
	LoginPage loginpage;
	DashBoardPage dashboardpage;
	ExcelReader excelreader = new ExcelReader();
	
	@Test(groups="smoke")
	public void CheckRememberMeIsDisplayed()
	{
		loginpage=new LoginPage(driver);
		Assert.assertTrue(loginpage.isRememberMeDisplayed(), "The Remember Me checkbox is Not Displayed");
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class, groups="smoke")
	public void verifyLoginWithValidCredential()
	{
		String st=GeneralUtility.get_RandomName();
		System.out.println(st);
		excelreader.setExcelFile("LoginPage");
		System.out.println(excelreader.getCellData(0, 0));
		loginpage=new LoginPage(driver);
		dashboardpage=loginpage.login("admin", "admin");
		String actualProfileName=dashboardpage.getProfileName();
		String expectedProfilename="Admin";
		Assert.assertEquals(actualProfileName, expectedProfilename);
	}

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="smoke")
	public void verifyLoginWithInvalidCredentials(String username, String password)
	{
		loginpage=new LoginPage(driver);
		dashboardpage=loginpage.login(username,password);
		String actualErrorMessage=loginpage.getInvalid_Username_Password_Message();
		System.out.println(actualErrorMessage);
		String expectedErrorMessage="Invalid Username/Password";
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
	}
}
