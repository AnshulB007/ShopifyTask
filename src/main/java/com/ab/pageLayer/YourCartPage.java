package com.ab.pageLayer;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ab.utilities.Utilities;

public class YourCartPage extends Utilities {

	private ArrayList<String> cartProductList;

	public YourCartPage(WebDriver driver) {
		super(driver);
		cartProductList = new ArrayList<>();

		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".h4.grid-view-item__title.product-card__title a")
	private List<WebElement> productList;

	
	@FindBy(xpath = "//*[@class='grid-view-item']//input[@value='Add to Cart']")
	private List<WebElement> addToCart_btn;
	
	@FindBy(css = "[aria-label='close cart'] svg")
	private WebElement closeCart_btn;

	
	@FindBy(css = ".site-header__icon.site-header__cart")
	private WebElement itemsInThe_btn;
	
	public ArrayList<String> getListOfCartProduct(String pName) {
		scrollUp(250);
		for (int i = 0; i < productList.size(); i++) {

			String products = productList.get(i).getText();

			if (products.equals(pName)) {

				cartProductList.add(products);
				System.out.println("Mil gaya");
				addToCart_btn.get(i).click();
				closeCart_btn.click();

			}

		}
		
		return cartProductList;

	}
	
	public void checkItemsAddedToCart() throws InterruptedException {
		ScrollInto(itemsInThe_btn);
		Thread.sleep(1000);
		itemsInThe_btn.click();
		
	}
	
	

	

}
