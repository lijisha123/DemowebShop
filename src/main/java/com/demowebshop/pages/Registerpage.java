package com.demowebshop.pages;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utilities.RandomUtility;
import com.demowebshop.Utilities.TestHelperUtility;
public class Registerpage extends TestHelperUtility {
	public WebDriver driver;
	public Registerpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	//List<WebElement> gender = driver.findElements(By.xpath("//input[@name='Gender']"));
	private final String _genderfield="//input[@name='Gender']/following-sibling::label";
	@FindBy(xpath = _genderfield)
	private List<WebElement> genderfield;
	private final String _firstNamefield="//input[@id='FirstName']";
	@FindBy(xpath = _firstNamefield)
	private WebElement firstNamefield;
	private final String _lastnamefield="//input[@id='LastName']";
	@FindBy(xpath = _lastnamefield)
	private WebElement lastnamefield;
	private final String _emailField="//input[@id='Email']";
	@FindBy(xpath = _emailField)
	private WebElement emailField;
	private final String _passwordField="//input[@id='Password']";
	@FindBy(xpath = _passwordField)
	private WebElement passwordField;
	private final String _confirmPasswordField="//input[@id='ConfirmPassword']";
	@FindBy(xpath = _confirmPasswordField)
	private WebElement confirmPasswordField;
	private final String _registerButton="//input[@id='register-button']";
	@FindBy(xpath = _registerButton)
	private WebElement registerButton;
	public void enterfirstname(String firstname) {
		page.enterText(firstNamefield,firstname);
		}
	public void enterlastname(String lastname) {
		page.enterText(lastnamefield,lastname);
		}
	public void enteremail(String email) {
		page.enterText(emailField,email);
		}
	public void enterpassword(String password) {
		 page.enterText(passwordField,password);
		}
	public void enterconfirmpassword(String confirmpassword) {
		page.enterText(confirmPasswordField,confirmpassword);
		}
	public void selectgender(String gender) {
		for (int i = 0; i < genderfield.size(); i++) {
			//String genderValue = genderfield.get(i).getAttribute("value");
			String genderValue=page.getElementText(genderfield.get(i));
			if (genderValue.equals(gender)) {
				page.clickOnElement(genderfield.get(i));
				break;
				}
		}
	}
		public UserAccountPage clickOnregisterButton(){
		page.clickOnElement(registerButton);
		return new UserAccountPage(driver);
		}

}
