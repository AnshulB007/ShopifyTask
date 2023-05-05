package com.ab.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ab.bastTest.BaseTest;


public class AddToCartFunctionalityTest extends BaseTest {

	

	@Test
	public void loginWithValidCredentials() throws InterruptedException {
		loginPage_obj.enterEmail("david@husssey.com");
		loginPage_obj.enterUserPassword("david123");
		loginPage_obj.clickOnLogin();
		dashBoardPage_obj.clickOnShopLink();
		dashBoardPage_obj.clickOnProductCategory();
		
		System.out.println(yourCart_obj.getListOfCartProduct("HeadStart Brain Nourishment"));
		
		yourCart_obj.checkItemsAddedToCart();
		
		
		
	}
}
