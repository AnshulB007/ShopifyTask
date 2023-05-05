package com.ab.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ab.bastTest.BaseTest;

public class LoginFuntionalityTest extends BaseTest {

	
	@Test
	public void loginWithValidCredentials() {
		
		loginPage_obj.enterEmail("david@husssey.com");
		loginPage_obj.enterUserPassword("david123");
		loginPage_obj.clickOnLogin();
		System.out.println(loginPage_obj.checklogOutIsPresent());
		Assert.assertEquals(loginPage_obj.checklogOutIsPresent(), true);
		
	}
	
	@Test
	public void loginWithInvalidCredentials() {
		
		loginPage_obj.enterEmail("david@husssey.com");
		loginPage_obj.enterUserPassword("dav34");
		loginPage_obj.clickOnLogin();
		
		Assert.assertEquals(loginPage_obj.getErrorMessage(), "Incorrect email or password.");
	}
	
}
