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
import com.training.pom.MemberLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_050AddContactandMakePayment {
	private WebDriver driver;
	private String baseUrl;
	private AllLoginPOM loginPOM;
	private MemberLoginPOM memlogPOM;
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
		memlogPOM = new MemberLoginPOM(driver);
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
		loginPOM.AllLoginDetails("Selenium01", "Manipal123");
		screenShot.captureScreenShot("HomePage");
		Thread.sleep(2000);
		loginPOM.clickLoginBtn(); 
		Thread.sleep(2000);
		memlogPOM.PersonalLinkButton();
		memlogPOM.ContactsButton();
		memlogPOM.sendMemUserName("anushi_01");
		Thread.sleep(1000);
		memlogPOM.ContactSubmitButton();
		driver.switchTo().alert().accept();
		memlogPOM.ContactListlink();
		memlogPOM.MakePaymentSubmitButton();
		memlogPOM.enterAmount("03");
		memlogPOM.addDescription("welcome");
		memlogPOM.paymentPageSubmitbutton();
		memlogPOM.allSubmitbutton();
		String actual= memlogPOM.confirmtext_TC050();
		String Expected = "Successful payment";
		Assert.assertEquals(actual, Expected);
}
}