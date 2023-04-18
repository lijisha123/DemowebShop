package com.demowebshop.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demowebshop.Utilities.ExcelUtility;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessages;
import com.demowebshop.constants.ExtendLogMessage;
import com.demowebshop.listeners.TestListener;
import com.demowebshop.pages.Homepage;

public class HomeTest extends Base {
	Homepage home;
	//ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	@Test(priority = 1, enabled = true, description = "TC001 verify Home Page Title", groups = { "smoke" })
	public void TC001_verifyHomePageTitle() {
		//extentTest.get().assignCategory("smoke");
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");
		String expectedTitle = data.get(1).get(0);
		home = new Homepage(driver);
		String actualHomePagetitle = home.getHomePageTitle();
		//extentTest.get().log(Status.PASS, ExtendLogMessage.HOMEPAGE_TITLE_RECEIVED);
		Assert.assertEquals(expectedTitle, actualHomePagetitle, ErrorMessages.TITLE_FAILURE_MESSAGE);
		//extentTest.get().log(Status.PASS, ExtendLogMessage.ACTUAL_AND_EXPECTED_MESSAGE);

	}

	@Test(priority = 1, enabled = true, description = "TC002 verify Subscribe Email Message", groups = "regression")
	public void TC_002_verifySubscribeEmailMessage() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");

		String expSubMessage = data.get(1).get(1);

		home = new Homepage(driver);

		home.enterSubEmail();

		home.clickOnSubButton();

		String actSubMessage = home.getSubMessage();

		Assert.assertEquals(expSubMessage, actSubMessage, ErrorMessages.EMAIL_FAILURE_MESSAGE);

	}

}
