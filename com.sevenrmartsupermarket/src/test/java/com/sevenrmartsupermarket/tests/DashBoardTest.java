package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class DashBoardTest extends Base
{
	LoginPage loginpage;
	DashBoardPage dashboardpage;

	@Test(groups="regression")
	public void verifyTheContactUsMailIsNotNull()
	{
		loginpage=new LoginPage(driver);
		dashboardpage=new DashBoardPage(driver);
		loginpage.login("admin", "admin");
		String actualEmailId=dashboardpage.getContactUsEmailID();
		System.out.println(actualEmailId);
		Assert.assertNotNull(actualEmailId, "The email id is showing as Null");
	}
	
	@Test(groups={"smoke","regression"})
	public void verifyLogoutOptionFromProfileIcon()
	{
		loginpage=new LoginPage(driver);
		loginpage.login("admin", "admin");
		dashboardpage=new DashBoardPage(driver);
		dashboardpage.logoutFromProfileIcon();
		String actualSigninPageText=dashboardpage.getSigninPageText();
		System.out.println(actualSigninPageText);
		String expectedSigninPageText="Sign in to start your session";
		Assert.assertEquals(actualSigninPageText, expectedSigninPageText);
	}
	
	@Test(groups={"smoke","regression"})
	public void verifyLogoutOptionFromMenuSettings()
	{
		loginpage=new LoginPage(driver);
		loginpage.login("admin", "admin");
		dashboardpage=new DashBoardPage(driver);
		dashboardpage.logoutFromMenuSettings();
		String actualSigninPageText=dashboardpage.getSigninPageText();
		System.out.println(actualSigninPageText);
		String expectedSigninPageText="Sign in to start your session";
		Assert.assertEquals(actualSigninPageText, expectedSigninPageText);
	}
}
