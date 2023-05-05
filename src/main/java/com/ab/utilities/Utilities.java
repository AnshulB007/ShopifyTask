package com.ab.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

	WebDriver driver;
	WebDriverWait wait;

	public Utilities(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickOnShopingCartBasket() {

		driver.findElement(By.cssSelector(".primary_header .shopping_cart_link")).click();

	}

	public String getCurrentUrl() {

		return driver.getCurrentUrl();

	}

	public void reachLoginPage() {
		System.out.println("Clickes");

		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector(".needsclick.kl-private-reset-css-Xuajs1 button svg path"))));

		driver.findElement(By.cssSelector(".needsclick.kl-private-reset-css-Xuajs1 button svg path")).click();
		driver.findElement(By.cssSelector("[href='#LoginModal']")).click();
		driver.findElement(By.id("Password")).sendKeys("cliely" + Keys.ENTER);
		driver.findElement(By.cssSelector("[href='/account/login'] svg")).click();

	}

	public void scrollUp(int value) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0," + value + ")");
	}
	
	public void ScrollInto(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].scrollIntoView(true);", element);
			
		} catch (Exception e) {
			e.printStackTrace();
			}
			
	}

	public void getCurrentUrl(int value) {

		driver.getCurrentUrl();
		
	}

}
