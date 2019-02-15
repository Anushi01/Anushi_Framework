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

import com.training.dataproviders.LoginDataProvider1;
import com.training.dataproviders.LoginDataProvider2;
import com.training.generics.ScreenShot;
import com.training.pom.AllLoginPOM;
import com.training.pom.ButtonClickPOM;
import com.training.pom.MemberLoginPOM;
import com.training.pom.TextBoxPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_080ErrorMessageforInvalidCredentials {
	private WebDriver driver;
	private String baseUrl;
	private AllLoginPOM loginPOM;
	private MemberLoginPOM memlogPOM;
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
	@Test(dataProvider = "Sheet1", dataProviderClass = LoginDataProvider2.class)
	public void MultiplePayment(String Username,String amount,String description) throws InterruptedException {
		loginPOM.AllLoginDetails("anushi_01", "selenium123");
		screenShot.captureScreenShot("HomePage");
		Thread.sleep(2000);
		loginPOM.clickLoginBtn(); 
		Thread.sleep(2000);
		screenShot.captureScreenShot("First");
		memlogPOM.AccountLinkButton();
		memlogPOM.MemberPaymentButton();
		loginPOM.sendMemUserName(Username);
		Thread.sleep(1000);
		txtPOM.enterAmount(amount);
		txtPOM.addDescription(description);
		memlogPOM.SubmitButton();
		memlogPOM.Submit();
	}
}

