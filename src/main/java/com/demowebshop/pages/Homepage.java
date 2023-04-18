package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utilities.RandomUtility;
import com.demowebshop.Utilities.TestHelperUtility;
import com.demowebshop.Utilities.WaitUtility;

public class Homepage extends TestHelperUtility {
	public WebDriver driver;
	public Homepage(WebDriver driver){ //initializing pagefactory (constructor)
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	private final String _subEmailField="newsletter-email"; /*elements should be written before actions*/
	@FindBy(id=_subEmailField)
	private WebElement subEmailField;
	private final String _subButton="newsletter-subscribe-button"; /*elements should be written before actions*/
	@FindBy(id=_subButton)
	private WebElement subButton;
	private final String _SubMessage="newsletter-result-block"; /*elements should be written before actions*/
	@FindBy(id=_SubMessage)
	private WebElement SubMessage;
	private final String _loginLink="//a[@class='ico-login']";
			@FindBy(xpath=_loginLink)
			private WebElement loginLink;
	private final String _registerLink="//a[text()='Register']";
	@FindBy(xpath =_registerLink )
	private WebElement registerlink;
			public String getHomePageTitle()
			{
				String title=page.getPageTitle(driver);
				return title;
				}
			public void enterSubEmail() {
				String emailId=RandomUtility.getRandomEmail(); //inputing random emailid
				page.enterText(subEmailField,emailId);
			}
			public void clickOnSubButton() {
				page.clickOnElement(subButton);
			}
			public String getSubMessage() {
				wait.setHardWait();
				wait.waitForElementToBeVisible(driver,_SubMessage,WaitUtility.LocatorType.Id);
				String message=page.getElementText(SubMessage);
				return message;
			}
	public LoginPage clickLoginLink() {
		page.clickOnElement(loginLink);
		return new LoginPage(driver);
	}
	public Registerpage clickRegisterLink() {
		page.clickOnElement(registerlink);
		return new Registerpage(driver);
}
}

