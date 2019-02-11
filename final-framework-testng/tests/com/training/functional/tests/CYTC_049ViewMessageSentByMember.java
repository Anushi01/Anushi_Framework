package com.training.functional.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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

public class CYTC_049ViewMessageSentByMember {
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
		memlogPOM.MessageButton();
		memlogPOM.NewSubmitButton();
		memlogPOM.sendMemUserName("anushi_01");
		memlogPOM.SubjectText();
		memlogPOM.BodyText();
		memlogPOM.MessageSubmitbutton();
		driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		memlogPOM.LogoutButton();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		loginPOM.AllLoginDetails("anushi_01", "selenium123");
		loginPOM.clickLoginBtn();
		memlogPOM.PersonalLinkButton();
		memlogPOM.MessageButton();
		Thread.sleep(1000);
		memlogPOM.MessageLink();
		String actual= memlogPOM.confirmtext_TC049();
		String Expected = "Message details";
		Assert.assertEquals(actual, Expected);
		System.out.println("Expected");
		}
}
