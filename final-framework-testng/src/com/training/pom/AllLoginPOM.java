package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllLoginPOM {
	private WebDriver driver; 
	public AllLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
		
	@FindBy(className="button")
	private WebElement loginBtn; 
	
	@FindBy(id="memberName")
	private WebElement userFullname;


	/*public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	*/
	
	public void AllLoginDetails(String userName,String password) {
		this.userName.clear();
		this.userName.sendKeys(userName);
		this.password.clear(); 
		this.password.sendKeys(password);
	}
		
	public void sendMemFullName(String userName) {
		this.userFullname.clear();
		this.userFullname.sendKeys(userName);
		this.userFullname.sendKeys(Keys.ENTER);
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
}

