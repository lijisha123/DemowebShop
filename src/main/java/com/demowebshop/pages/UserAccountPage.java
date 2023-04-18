package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v105.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utilities.TestHelperUtility;

public class UserAccountPage extends TestHelperUtility{
	public WebDriver driver;
	public UserAccountPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
			}
	private final String _validationmail="//div[@class='header-links']//a[@class='account']";
	@FindBy(xpath =_validationmail)
	private WebElement validationmail;
	
public String getuseremail()
{
	String email=page.getElementText(validationmail);
	return email;
}
}



