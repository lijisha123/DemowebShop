package com.demowebshop.pages;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.xml.xpath.XPath;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utilities.ExcelUtility;
import com.demowebshop.Utilities.RandomUtility;
import com.demowebshop.Utilities.TestHelperUtility;
import com.demowebshop.Utilities.WaitUtility;

import io.opentelemetry.sdk.metrics.data.Data;

public class LoginPage  extends TestHelperUtility{
	public WebDriver driver;
	public LoginPage(WebDriver driver){ //initializing pagefactory (constructor)
		this.driver=driver;
	PageFactory.initElements(driver,this);
}
	private final String _emailField="Email";
	@FindBy(id = _emailField)
	private WebElement emailField;
	private final String _PasswordField="Password";
	@FindBy(id = _PasswordField)
	private WebElement PasswordField;
	private final String _loginButton="//input[@class='button-1 login-button']";
	@FindBy(xpath =_loginButton)
	private WebElement loginButton;
	private final String _errorMessage="//div[@class='validation-summary-errors']//span";
	@FindBy(xpath=_errorMessage)
	private WebElement errorMessage;
	public String getLoginPageTitle()
	{
		String title=page.getPageTitle(driver);
		return title;
	}
		public void enterEmail(String email)
		{
			
			page.enterText(emailField,email);
		}
		public void enterpassword(String password)
		{
		
		page.enterText(PasswordField,password);
		}
		public void clickOnloginButton(){
			page.clickOnElement(loginButton);
		}
		public String geterrormessage()
		{
			String errorMsg=page.getElementText(errorMessage);
			return errorMsg;
		}
		public UserAccountPage clickonloginbutton()
		{
			page.clickOnElement(loginButton);
			return new UserAccountPage(driver);
		}
		}
		
	
