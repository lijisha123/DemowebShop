package com.demowebshop.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.Utilities.ExcelUtility;
import com.demowebshop.Utilities.RandomUtility;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessages;
import com.demowebshop.pages.Homepage;
import com.demowebshop.pages.Registerpage;
import com.demowebshop.pages.UserAccountPage;

public class RegisterTest extends Base{
	Homepage home;
	Registerpage register;
	UserAccountPage user;
	@Test(priority=1,enabled=true,description="TC003 verify Registration",groups="sanity")
	public void TC003_verifyRegistration() {
		List<ArrayList<String>> data=ExcelUtility.excelDataReader("RegisterPage");
		String gender=data.get(1).get(0);
		//String expectedmail=data.get(1).get(1);
		String fName=RandomUtility.getfName();
		String lName=RandomUtility.getlName();
		String emailid=RandomUtility.getRandomEmail();
		String password=fName+"@123";
		String cpassword=password;
		home=new Homepage(driver);
		register=home.clickRegisterLink();
		register.selectgender(gender);
		register.enterfirstname(fName);
		register.enterlastname(lName);
		register.enteremail(emailid);
		register.enterpassword(password);
		register.enterconfirmpassword(cpassword);
		user=register.clickOnregisterButton();
		String actualmail=user.getuseremail();
		Assert.assertEquals(emailid, actualmail,ErrorMessages.EMAIL_FAILURE_MESSAGE);
		}
	}
