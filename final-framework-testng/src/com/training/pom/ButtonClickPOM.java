package com.training.pom;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ButtonClickPOM {
	private WebDriver driver; 
	public ButtonClickPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="button")
	private WebElement loginBtn;
	
	@FindBy(xpath="//*/tr/td/input[contains(@linkurl,'accountOverview')][@class='linkButton']")
	private WebElement accountSubmit;
	
	@FindBy(name = "query(paymentFilter)")
	private WebElement paymenttxt;
	
	@FindBy(xpath="//input[@value='Search']")
	private WebElement searchbtn;
	
	@FindBy(xpath="//*/tr/td/input[contains(@linkurl,'payment?to=52')][@class='linkButton']")
	private WebElement paymentsys_member;
	
	@FindBy(id="submitButton")	
	private WebElement paymentsubmitbtn;
	
	@FindBy(xpath ="//input[@value='Submit']" )
	private WebElement allsubmitbtn;
	
	@FindBy(xpath = "//*/tr/td/input[contains(@linkurl,'grantLoan?memberId=52')][@class='linkButton']")
	private WebElement grantloan_submitbtn;
	
	@FindBy(xpath = "//*/tr/td/input[contains(@linkurl,'searchLoans?memberId=52')][@class='linkButton']")
	private WebElement viewloans_submitbtn;
	
	@FindBy(xpath= "//input[@value='CLOSED']")
	private WebElement closeradiobtn;
	
	@FindBy(xpath= "//td[@class='tdHeaderTable']")
	private WebElement confirmTxt;
	
	@FindBy(xpath= "//input[@value='OPEN']")
	private WebElement openradiobtn;
	
	@FindBy(xpath = "//span[@class='menuText'][contains(text(),'Account')]")
	private WebElement accntlinkbtn;
	
	@FindBy(xpath = "//span[contains(text(),'Account Information')]")
	private WebElement accntinformatnbtn;
	
	@FindBy(xpath = "//img[@title='View']")
	private WebElement viewbtn;
	
	@FindBy(xpath = "//input[@id='backButton']")
	private WebElement backbtn;
	
	@FindBy(id= "modeButton")
	private WebElement advBtn;
	
	@FindBy(xpath= "//img[@id='calendarTrigger0']")
	private WebElement fromdateBtn;
	
	@FindBy(xpath= "//img[@id='calendarTrigger1']")
	private WebElement todateBtn;
	
	@FindBy(xpath= "//span[contains(text(),'Member Payment')]")
	private WebElement memPaymentBtn;
	
	/*@FindBy(id= "schedulingTypeSelect")
	private WebElement schedulingDD;

	public void schedulingDropDown() {
		this.schedulingDD.click();
	}
	
	@FindBy(xpath="//option[@value='MULTIPLE_FUTURE']")
	private WebElement schedulingoption2;
	
		public void SchedulingDDSelect() {
		Actions action = new Actions(driver);
		action.moveToElement(schedulingoption2).click().perform();;
	}*/
	
	
	
	public void MemberPaymentButton() {
		this.memPaymentBtn.click();
	}
	
	public void FromDateButton() {
		this.fromdateBtn.click();
	}
	
	public void ToDateButton() {
		this.todateBtn.click();
	}
	
	public void advanceButton() {
		this.advBtn.click();
	}
	
	public void BackButton() {
		this.backbtn.click();
	}
	
	public void ViewButton() {
		this.viewbtn.click();
	}
	public void AccountInfoButton() {
		this.accntinformatnbtn.click();
	}
	
	public void AccountLinkButton() {
		this.accntlinkbtn.click();
	}
	
	public void ClosedRadiobutton() {
		this.closeradiobtn.click();
	}
	
	public void OpenRadiobutton() {
		this.openradiobtn.click();
	}
	
	public List<WebElement> paymenttxtbtn() {
		Select s=new Select(this.paymenttxt) ;
		//this.paymenttxt.click();
		/*Actions actions = new Actions(driver);
		actions.moveToElement(paymenttxt).perform();*/
		s.selectByVisibleText("Commission payments");
		return s.getOptions();
	}
	
	public void paymentPageSubmitbutton() {
		this.paymentsubmitbtn.click();
	}
	
	public void accountSubmitbtn() {
	this.accountSubmit.click();
	}
	
	public void searchButton() {
		this.searchbtn.click();
	}
	
	public void paymentmemButton() {
		this.paymentsys_member.click();
	}

	public void allSubmitbutton() {
		this.allsubmitbtn.click();
	}
	public void grantloansubmit() {
		this.grantloan_submitbtn.click();
		
	}
	
	public void viewLoansSubmitbutton() {
		this.viewloans_submitbtn.click();
	}
	
	public String confirmtext() {
		return this.confirmTxt.getText();
	} 
}