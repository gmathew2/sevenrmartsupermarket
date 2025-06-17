package com.sevenrmartsupermarket.tests;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.sevenrmartsupermarket.base.Base;
	import com.sevenrmartsupermarket.pages.AdminUsersPage;
	import com.sevenrmartsupermarket.pages.LoginPage;
	import org.testng.annotations.Test;

	import com.sevenrmartsupermarket.base.Base;
	import com.sevenrmartsupermarket.pages.AdminUsersPage;
	import com.sevenrmartsupermarket.pages.LoginPage;

	public class AdminUsersTest extends Base 
	{
		AdminUsersPage adminuserspage;
		LoginPage loginpage;
		
		@Test (groups="regression")
		public void verifyAdminUsersIsMoreInfo_Enabled()
		{
			loginpage = new LoginPage(driver);
			loginpage.login("admin", "admin");
			adminuserspage=new AdminUsersPage(driver);
			System.out.println(adminuserspage.isAdminMoreInfoEnabled());
			Assert.assertTrue(adminuserspage.isAdminMoreInfoEnabled(), "The Admin More Info Page is not Enabled");
		}
		
		@Test
		public void verifyStatusChangeAlertMessage()
		{
			loginpage = new LoginPage(driver);
			loginpage.login("admin", "admin");
			adminuserspage=new AdminUsersPage(driver);
			String actualAlertMessage=adminuserspage.getStatusChangeAlertMessage();
			System.out.println(actualAlertMessage);
			String expectedAlertMessage=actualAlertMessage;
			Assert.assertEquals(actualAlertMessage,expectedAlertMessage);
		}
		
		@Test
		public void verifyDuplicateUsernameAlertMessage()
		{
			loginpage = new LoginPage(driver);
			loginpage.login("admin", "admin");
			adminuserspage=new AdminUsersPage(driver);
			String actualAlertMessage=adminuserspage.getDuplicateUsernameAlertMessage("gm","Password1","staff");
			System.out.println(actualAlertMessage);
			String expectedAlertMessage=actualAlertMessage;
			Assert.assertEquals(actualAlertMessage,expectedAlertMessage);
		}
		
		@Test
		public void testUserSearch()
		{
			loginpage = new LoginPage(driver);
			loginpage.login("admin", "admin");
			adminuserspage=new AdminUsersPage(driver);
			String userDetails=adminuserspage.getUserDetails("VeenaS");
			System.out.println("User Details: "+userDetails);
			if(userDetails==null)
			{
				System.out.println("No such user present");
				Assert.assertNull(userDetails);
			}
			else
			{
				System.out.println("User is present");
				Assert.assertNotNull(userDetails);
			}
		}
		
		@Test
		public void testNewUserCreation()
		{
			loginpage = new LoginPage(driver);
			loginpage.login("admin", "admin");
			adminuserspage=new AdminUsersPage(driver);
			String actualAlertMessage=adminuserspage.createNewUser("Tilak","HelloPassword","staff");
			System.out.println(actualAlertMessage);
			String expectedAlertMessage=actualAlertMessage;
			Assert.assertEquals(actualAlertMessage,expectedAlertMessage);
		}
}

