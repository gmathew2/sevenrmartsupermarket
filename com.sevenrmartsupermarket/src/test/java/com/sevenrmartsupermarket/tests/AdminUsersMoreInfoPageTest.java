package com.sevenrmartsupermarket.tests;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.sevenrmartsupermarket.base.Base;
	import com.sevenrmartsupermarket.pages.AdminUsersMoreInfoPage;
	import com.sevenrmartsupermarket.pages.LoginPage;
	import org.testng.annotations.Test;

	import com.sevenrmartsupermarket.base.Base;
	import com.sevenrmartsupermarket.pages.AdminUsersMoreInfoPage;
	import com.sevenrmartsupermarket.pages.LoginPage;

	public class AdminUsersMoreInfoPageTest extends Base 
	{
		AdminUsersMoreInfoPage adminusersmoreinfopage;
		LoginPage loginpage;
		
		@Test (groups="regression")
		public void VerifyBackgroundColor()
		{
			loginpage = new LoginPage(driver);
			loginpage.login("admin", "admin");
			adminusersmoreinfopage=new AdminUsersMoreInfoPage(driver);
			String actualbackgroundcolor=adminusersmoreinfopage.clickMoreInfobuttonbackgroundcolor();
			System.out.println(actualbackgroundcolor);
			String expectedbackgroundcolor="rgba(40, 167, 69, 1)";
			Assert.assertEquals(actualbackgroundcolor,expectedbackgroundcolor);
			
		}
		
		
		@Test
		public void addNewUser()
		{
			loginpage = new LoginPage(driver);
			loginpage.login("admin", "admin");
			adminusersmoreinfopage=new AdminUsersMoreInfoPage(driver);
			adminusersmoreinfopage.createNewUser();
			
		}
}

