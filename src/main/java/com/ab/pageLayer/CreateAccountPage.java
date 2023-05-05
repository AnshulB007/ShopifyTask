package com.ab.pageLayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ab.utilities.Utilities;

public class CreateAccountPage extends Utilities {

	public CreateAccountPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".inventory_item_name")
	private List<WebElement> productInCartList;

	@FindBy(id = "RegisterForm-FirstName")
	private WebElement firstName;

	@FindBy(id = "RegisterForm-LastName")
	private WebElement lastName;

	@FindBy(id = "RegisterForm-email")
	private WebElement email;

	@FindBy(id = "RegisterForm-password")
	private WebElement password;

	@FindBy(id = "customer_register_link")
	private WebElement createAccountLink;

	@FindBy(css = ".register.text-center [type='submit']")
	private WebElement registerBtn;

	@FindBy(id = "terms-check")
	private WebElement checkBox;
	
	@FindBy(css = ".form-message")
	private WebElement getErrorMsg;

	@FindBy(css = ".email.field :nth-child(3) :nth-child(3)")
	private WebElement inValidEmail;
	

	public void clickOnCreateAccount() {

		reachLoginPage();
		scrollUp(100);
		createAccountLink.click();

	}

	public void enterFirstName(String fn) {
		firstName.sendKeys(fn);
	}

	public void enterLastName(String ln) {
		lastName.sendKeys(ln);
	}

	public void enterEmail(String emailId) {
		email.sendKeys(emailId);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);

	}

	public void clickOnCheckBox() {
		scrollUp(80);
		checkBox.click();

	}

	public void clickOnRegisterBtn() {
		registerBtn.click();

	}

	public String getUrl() {

		return getCurrentUrl();

	}

	public String getErrorMessage() {

		return getErrorMsg.getText();

	}
	
	public String getInvalidEmailMessage() {

		return inValidEmail.getText();

	}

}
