package com.ab.pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ab.utilities.Utilities;

public class DashBoardPage extends Utilities {

	public DashBoardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//li/a/*[text()='Shop']")
	private WebElement shop_link;
	@FindBy(css = ".shop-menu-box a")
	private WebElement product_Category;

	//

	public void clickOnShopLink() {

		shop_link.click();

	}

	public void clickOnProductCategory() {

		product_Category.click();
		scrollUp(150);

	}

}
