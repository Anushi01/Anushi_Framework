package com.training.functional.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AllLoginPOM;
import com.training.pom.ButtonClickPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_020DisplayAccountInfoOfMember {
	private WebDriver driver;
	private String baseUrl;
	private AllLoginPOM loginPOM;
	private ButtonClickPOM btnPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AllLoginPOM(driver);
		btnPOM = new ButtonClickPOM(driver);
		//new java file obj
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.AllLoginDetails("anushi01", "selenium123");
		screenShot.captureScreenShot("HomePage");
		Thread.sleep(2000);
		loginPOM.clickLoginBtn(); 
		//loginPOM.sendMemFullName("manzoor mehadi");
		Thread.sleep(2000);
		screenShot.captureScreenShot("First");
		btnPOM.AccountLinkButton();
		btnPOM.AccountInfoButton();
		Thread.sleep(1000);
		btnPOM.ViewButton();
		Thread.sleep(1000);
		btnPOM.BackButton();
		String actual = btnPOM.confirmtext();
		String expected = "Search transactions on Member account";
		Assert.assertEquals(actual, expected);
				
	}
}
