package com.ab.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ab.bastTest.BaseTest;

public class SignUpFuctionalityTest extends BaseTest {
	
	
	@Test
	public void signUpWithValidDetails() {
		
		
		createAcc_obj.clickOnCreateAccount();
		
		createAcc_obj.enterFirstName("David");
		
		createAcc_obj.enterLastName("Hussey");
		createAcc_obj.enterEmail("david@uy.com");
		createAcc_obj.enterPassword("david123");
		createAcc_obj.clickOnCheckBox();
		createAcc_obj.clickOnRegisterBtn();
		Assert.assertEquals(createAcc_obj.getUrl(), "https://commonsenseherbs.myshopify.com/");
	
	}
	
	@Test(dependsOnMethods="signUpWithValidDetails")
	public void signUpWithExistingEmailId() {
		
		
		createAcc_obj.clickOnCreateAccount();
		
		createAcc_obj.enterFirstName("David");
		
		createAcc_obj.enterLastName("Hussey");
		createAcc_obj.enterEmail("david@uy.com");
		createAcc_obj.enterPassword("david123");
		createAcc_obj.clickOnCheckBox();
		createAcc_obj.clickOnRegisterBtn();
		Assert.assertEquals(createAcc_obj.getErrorMessage(), "This email address is already associated with an account. If this account is yours, you can reset your password");
	
	}
	
	
	@Test
	public void signUpWithoutClickingCheckbox() {
		
		
		createAcc_obj.clickOnCreateAccount();
		
		createAcc_obj.enterFirstName("David");
		
		createAcc_obj.enterLastName("Hussey");
		createAcc_obj.enterEmail("david@ioy.com");
		createAcc_obj.enterPassword("david123");
		createAcc_obj.clickOnRegisterBtn();
		Assert.assertEquals(createAcc_obj.getUrl(), "https://commonsenseherbs.myshopify.com/account/register");

		//Here there is bug because it is registering the user without accepting the privacy policy which is mandatory
	
	}
	
	@Test
	public void signUpWithoutIncorrectEmailFormat() {
		
		
		createAcc_obj.clickOnCreateAccount();
		
		createAcc_obj.enterFirstName("David");
		
		createAcc_obj.enterLastName("Hussey");
		createAcc_obj.enterEmail("davidioy.com");
		createAcc_obj.enterPassword("david123");
		createAcc_obj.clickOnCheckBox();
		createAcc_obj.clickOnRegisterBtn();
		
		Assert.assertEquals(createAcc_obj.getInvalidEmailMessage(), "Email is invalid.");

		//Here there is bug because it is registering the user without accepting the privacy policy which is mandatory
	
	}
	
	

}
