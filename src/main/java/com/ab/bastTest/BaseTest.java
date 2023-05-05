package com.ab.bastTest;

import java.io.File;
import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ab.pageLayer.CreateAccountPage;
import com.ab.pageLayer.DashBoardPage;
import com.ab.pageLayer.LoginPage;

import com.ab.pageLayer.YourCartPage;
import com.ab.utilities.Utilities;

public class BaseTest {

	public LoginPage loginPage_obj;
	public DashBoardPage dashBoardPage_obj;
	public YourCartPage yourCart_obj;
	public Utilities util_obj;
	
	public CreateAccountPage createAcc_obj;
	Properties prop; 
	public WebDriver driver;

	@Test
	public WebDriver intialiseBrowser() {

		String browserName = null;
		String configPath = System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\config.properties";

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(configPath);

			prop.load(fis);

			browserName = prop.getProperty("browser");

		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("Your chosen browser is " + browserName);

		if (browserName.equals("chrome")) {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("-remote-allow-origins=*");
			driver = new ChromeDriver(co);

		}

		if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage_obj = new LoginPage(driver);
		dashBoardPage_obj = new DashBoardPage(driver);
		
		util_obj = new Utilities(driver);
		yourCart_obj = new YourCartPage(driver);
		
		
		createAcc_obj = new CreateAccountPage(driver);
		return driver;

	}

	public String getScreenShot(WebDriver driver, String testcase) {

		String ssPath = System.getProperty("user.dir") + "\\testoutputs\\" + testcase + System.currentTimeMillis()
				+ ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(ssPath);
		try {
			FileHandler.copy(src, des);
			System.out.println("ScreenShot saved");
		} catch (Exception e) {

			e.printStackTrace();
		}
		return ssPath;
	}

	@BeforeMethod
	public void launcdhApplication() {

		driver = intialiseBrowser();
//		driver.get("https://commonsenseherbs.myshopify.com");
		driver.get(prop.getProperty("url"));

	}

	@AfterMethod
	public void TearDown() {

//		driver.quit();
		System.out.println("Browser Closed");
	}

}
