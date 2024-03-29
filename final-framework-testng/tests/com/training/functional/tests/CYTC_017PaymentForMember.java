package com.training.functional.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import com.training.pom.TextBoxPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_017PaymentForMember {
	private WebDriver driver;
	private String baseUrl;
	private AllLoginPOM loginPOM;
	private ButtonClickPOM btnPOM;
	private TextBoxPOM txtPOM;
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
		txtPOM = new TextBoxPOM(driver);
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
	public void validLoginTest() throws InterruptedException, AWTException {
		loginPOM.AllLoginDetails("admin", "12345");
		screenShot.captureScreenShot("HomePage");
		Thread.sleep(2000);
		loginPOM.clickLoginBtn(); 
		//loginPOM.sendMemFullName("manzoor mehadi");
		loginPOM.sendMemUserName("anushi");
		screenShot.captureScreenShot("First");
		Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(2000);
		btnPOM.paymentmemButton();
		txtPOM.enterAmount("500,00");
		txtPOM.TransactionTypebtn();
		txtPOM.addDescription("bonus");
		btnPOM.paymentPageSubmitbutton();
		//assert equals statement to confirm the page should be inserted
		btnPOM.allSubmitbutton();
		screenShot.captureScreenShot("transaction details");
		String actual= btnPOM.confirmtext();
		String Expected = "Successful payment";
		Assert.assertEquals(actual, Expected);
		
	}
}

	
