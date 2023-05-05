package com.ab.pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ab.utilities.Utilities;

public class LoginPage extends Utilities {

	public LoginPage(WebDriver driver) {
           super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "CustomerEmail")
	private WebElement userEmail;

	@FindBy(css = ".errors li")
	private WebElement error_message;

	@FindBy(id = "CustomerPassword")
	private WebElement userPassword;

	@FindBy(css = "#CustomerLoginForm [type='submit']")
	private WebElement login_button;
	@FindBy(id = "customer_logout_link")
	private WebElement logOut_link;

	public void enterEmail(String eId) {
		reachLoginPage();
		userEmail.sendKeys(eId);
	}

	public void enterUserPassword(String password) {
		userPassword.sendKeys(password);
	}

	public void clickOnLogin() {
		login_button.click();
	}
	public boolean checklogOutIsPresent() {
		return logOut_link.isDisplayed();
	}
	public String getErrorMessage() {

		return error_message.getText();
	}

}
