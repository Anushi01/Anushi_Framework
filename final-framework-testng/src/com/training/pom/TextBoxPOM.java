package com.training.pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TextBoxPOM {
		private WebDriver driver; 
		
		public TextBoxPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="amount")
		private WebElement amnt;
				
		@FindBy(id = "type")
		private WebElement transactbtn;
	
		@FindBy(id="description")
		private WebElement desc;
		
		public List<WebElement> TransactionTypebtn() {
			Select s=new Select(this.transactbtn) ;
			//this.paymenttxt.click();
			/*Actions actions = new Actions(driver);
			actions.moveToElement(paymenttxt).perform();*/
			s.selectByVisibleText("Debit to member");
			return s.getOptions();
		}
		
		public void enterAmount(String amount) throws InterruptedException {
			this.amnt.sendKeys(amount);
			Thread.sleep(1000);
			//this.amnt.sendKeys(Keys.ENTER);
		}
		
		public void addDescription(String description) {
			this.desc.sendKeys(description);
		}
}

