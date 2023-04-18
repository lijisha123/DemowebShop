package com.demowebshop.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demowebshop.Utilities.ExcelUtility;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessages;
import com.demowebshop.dataprovider.DataProviders;
import com.demowebshop.pages.Homepage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.UserAccountPage;

public class LoginTest extends Base{
	Homepage home;
	LoginPage login;
	UserAccountPage user;
	@Test(priority=1,enabled=true,description="TC003 verify Login Page Title",groups="sanity")
	public void TC003_verifyLoginPageTitle() {

	List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");

	String expectedLoginpageTitle=data.get(1).get(0);
	home=new Homepage(driver);
	login=home.clickLoginLink();
	String actualLoginPagetitle=login.getLoginPageTitle();

	Assert.assertEquals(expectedLoginpageTitle,actualLoginPagetitle,ErrorMessages.TITLE_FAILURE_MESSAGE);
}
	@Test(priority=1,enabled=true,description="TC004 verify Login using Invalid credentials",dataProvider="InvalidUserCredentials",dataProviderClass = DataProviders.class,groups="regression")
	public void TC004_verifyLoginusingInvalidcredentials(String email,String password)
	{
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String expectederrormessage=data.get(1).get(1);
		home=new Homepage(driver);
		login=home.clickLoginLink();
		login.enterEmail(email);
		login.enterpassword(password);
		login.clickOnloginButton();
		String actualLoginmsg=login.geterrormessage();
		Assert.assertEquals(actualLoginmsg,expectederrormessage,ErrorMessages.LOGIN_FAILURE_MESSAGE);
	}
	@Test(priority=1,enabled=true,description="TC004 verify Login using valid credentials")
	public void TC004_verifyLoginusingvalidcredentials()
	{
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("LoginPage");
		String username=data.get(1).get(2);
		String pasword=data.get(1).get(3);
		home=new Homepage(driver);
		login=home.clickLoginLink();
		login.enterEmail(username);
		login.enterpassword(pasword);
		user=login.clickonloginbutton();
		String actualmail=user.getuseremail();
		Assert.assertEquals(username, actualmail,ErrorMessages.LOGIN_FAILURE_MESSAGE);
		}
}
