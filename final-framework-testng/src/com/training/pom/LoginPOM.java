package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
		
	@FindBy(className="button")
	private WebElement loginBtn; 
	
	@FindBy(id="memberUsername")
	private WebElement memberuserName;
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void sendMemUserName(String userName) {
		this.memberuserName.clear();
		this.memberuserName.sendKeys(userName);
		this.memberuserName.sendKeys(Keys.ENTER);
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
}
