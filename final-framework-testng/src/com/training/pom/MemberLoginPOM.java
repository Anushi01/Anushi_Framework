package com.training.pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MemberLoginPOM {
	private WebDriver driver; 
	public MemberLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class='menuText'][contains(text(),'Account')]")
	private WebElement accntlinkbtn;
	
	public void AccountLinkButton() {
		this.accntlinkbtn.click();
	}
	
	@FindBy(xpath="//span[contains(text(),'Personal')]")
	private WebElement personalbtn;
	
	public void PersonalLinkButton() {
		this.personalbtn.click();
	}
	@FindBy(xpath="//span[contains(text(),'Messages')]")
	private WebElement messagesbtn;
	
	public void MessageButton() {
		this.messagesbtn.click();
	}
	
	@FindBy(xpath="//input[@value='Advanced']")
	private WebElement advbtn;
	
	public void AdvanceButton(){
		this.advbtn.click();
	}
	
	@FindBy(xpath= "//span[contains(text(),'Member Payment')]")
	private WebElement memPaymentBtn;

	public void MemberPaymentButton() {
		this.memPaymentBtn.click();
	}

	@FindBy(id="memberUsername")
	private WebElement memberuserName;
	
	public void sendMemUserName(String userName) throws InterruptedException {
		//this.memberuserName.clear();
		this.memberuserName.sendKeys(userName);
		Thread.sleep(1000);
		//this.memberuserName.sendKeys(Keys.ENTER);
	}
	
	@FindBy(id="memberUsername")
	private WebElement memberuserName1;
	
	public void sendMemUserName1(String userName) throws InterruptedException {
		//this.memberuserName.clear();
		this.memberuserName1.sendKeys(userName);
		Thread.sleep(1000);
		this.memberuserName.sendKeys(Keys.ENTER);
	}
	
	@FindBy(xpath= "//tr[@class='scheduling']//td//select")
	private WebElement schedulinglink;
	
	public List<WebElement> SchedulingLink() {
		Select s=new Select(this.schedulinglink);
		s.selectByVisibleText("Scheduled for future date");
		return s.getOptions();
	}
	
	@FindBy(id="scheduleForText")
	private WebElement schedulefor;
	
	public void ScheduleFor(String Date) throws InterruptedException {
		this.schedulefor.sendKeys(Date);
		Thread.sleep(1000);
		this.schedulefor.click();
	}
	
	@FindBy(xpath= "//input[@name='query(period).begin']")
	private WebElement fromdateBtn;
	
	public void FromDateButton() {
		this.fromdateBtn.clear();
		this.fromdateBtn.sendKeys("10/01/2019");
	}
	
	@FindBy(xpath= "//input[@name='query(period).end']")
	private WebElement todateBtn;
	
	public void ToDateButton() {
		//this.todateBtn.clear();
		this.todateBtn.sendKeys("03/03/2019");
	}
	
	
	@FindBy(id="scheduleForText")
	private WebElement scheduledate;
	
	public void ScheduleForDate() {
		this.scheduledate.clear();
		this.scheduledate.sendKeys("10/03/2019");
		}
	
	@FindBy(id= "description")
	private WebElement desc;
	
	public void Description() {
		this.desc.sendKeys("welcome");
	}

	@FindBy(id="submitButton")
	private WebElement submitbtn;
	
	public void SubmitButton() {
		 this.submitbtn.click();
		}
	
	@FindBy(xpath= "//input[@value='Submit']")
	private WebElement submit;
	
	public void Submit() {
		this.submit.click();
	}
	
	@FindBy(xpath="//span[contains(text(),'Scheduled payments')]")
	private WebElement schedulepaymentlink;
	
	public void SchedulePaymentButton() {
		this.schedulepaymentlink.click();
	}
	@FindBy(xpath= "//td[contains(text(),'Search transactions on Member account')]")
	private WebElement confirmTxt;
	
	public String confirmtext_TC046() {
		return this.confirmTxt.getText();
	} 
	
	
	@FindBy(xpath= "//td[contains(text(),'Search scheduled payments')]")
	private WebElement confirmTxt1;
	
	public String confirmtext_TC047() {
		return this.confirmTxt1.getText();
	} 
	
	@FindBy(xpath= "//td[contains(text(),'Search results')]")
	private WebElement confirmTxt2;
	
	public String confirmtext_TC048() {
		return this.confirmTxt2.getText();
	}   
	
	@FindBy(xpath= "//td[@class='tdHeaderTable']")
	private WebElement confirmTxt3;
	
	public String confirmtext_TC049() {
		return this.confirmTxt3.getText();
	}
	
	
	@FindBy(xpath= "//td[@class='tdHeaderTable']")
	private WebElement confirmTxt4;
	
	public String confirmtext_TC050() {
		return this.confirmTxt4.getText();
	}
	
	
	@FindBy(name="query(messageBox)")
	private WebElement messagebox;
	
	public List<WebElement> MessageBox1() {
		Select s=new Select(this.messagebox) ;
		s.selectByVisibleText("Sent items");
		return s.getOptions();
	}
	
	@FindBy(name="query(rootType)")
	private WebElement type;
	
	public List<WebElement> Typedropdown1(){
		Select s=new Select(this.type);
		s.selectByVisibleText("Administration");
		return s.getOptions();
	}
	
	@FindBy(name="query(messageBox)")
	private WebElement messagebox2;
	
	public List<WebElement> MessageBox2() {
		Select s=new Select(this.messagebox2) ;
		s.selectByVisibleText("Inbox");
		return s.getOptions();
	}
	
	@FindBy(name="query(rootType)")
	private WebElement type2;
	
	public List<WebElement> Typedropdown2(){
		Select s=new Select(this.type2);
		s.selectByVisibleText("All");
		return s.getOptions();
	}
	@FindBy(xpath= "//table[@class='defaultTable']//input[@value='Submit']")
	private WebElement msgsubmit;
	
	public void MsgSubmitButton() {
		this.msgsubmit.click();
	}
	
	@FindBy(id="newButton")
	private WebElement newsubmitbtn;
	
	public void NewSubmitButton() {
		this.newsubmitbtn.click();
	}
	
	@FindBy(id="subjectText")
	private WebElement subjecttxt;
	
	public void SubjectText() {
		this.subjecttxt.sendKeys("Hello");
	}
	
	@FindBy(xpath="//iframe[@title='Rich text editor, bodyText']")
	private WebElement bodyText;
	
	public void BodyText() {
	Actions act = new Actions(driver);
	act.moveToElement(this.bodyText).click().sendKeys("welcome").build().perform();
	}
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement msgsubmitbtn;
	
	public void MessageSubmitbutton() {
		this.msgsubmitbtn.click();
	}
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement logout;
	
	public void LogoutButton() {
		this.logout.click();
	}
	
	@FindBy(xpath= "//tbody//tbody//tr[2]//td[3]//table[1]//tbody[1]//tr[1]//td[2]//a[1]")
	private WebElement messagelink;
	
	public void MessageLink() {
		this.messagelink.click();
	}
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	private WebElement contactsbtn;
	
	public void ContactsButton() {
		this.contactsbtn.click();
	}
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement contactsubmit;
	
	public void ContactSubmitButton() {
		this.contactsubmit.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'anushi_01')]")
	private WebElement contactList;
	
	public void ContactListlink() {
		this.contactList.click();
	}
	
	@FindBy(xpath="//*/tr/td/input[contains(@linkurl,'payment?to=58')][@class='linkButton']")
	private WebElement makepaymentsubmit;
	
	public void MakePaymentSubmitButton() {
		this.makepaymentsubmit.click();
	}
	
	@FindBy(id="amount")
	private WebElement amnt;
	
	public void enterAmount(String amount) throws InterruptedException {
		this.amnt.sendKeys(amount);
		Thread.sleep(1000);
		//this.amnt.sendKeys(Keys.ENTER);
	}
	
	@FindBy(id="description")
	private WebElement descriptiontextbox;
	
	public void addDescription(String description) {
		this.descriptiontextbox.sendKeys(description);
	}
	
	@FindBy(id="submitButton")	
	private WebElement paymentsubmitbtn;
	
	public void paymentPageSubmitbutton() {
		this.paymentsubmitbtn.click();
	}
	
	@FindBy(xpath ="//input[@value='Submit']" )
	private WebElement allsubmitbtn;
	
	public void allSubmitbutton() {
		this.allsubmitbtn.click();
	}
	
	@FindBy(name="query(paymentFilter)")
	private WebElement paymentfilter;
	
	public List<WebElement> PaymentFilter() {
		Select s=new Select(this.paymentfilter) ;
		s.selectByVisibleText("Loan payments");
		return s.getOptions();
	}
	
	@FindBy(xpath="//span[contains(text(),'Loans')]")
	private WebElement loanbtn;
	
	public void LoanButton() {
		this.loanbtn.click();
	}
	
	@FindBy(xpath="//tbody//tbody//tr[2]//td[4]//img[1]")
	private WebElement viewbtn;
	
	public void ViewButton() {
		this.viewbtn.click();
	}
	
	@FindBy(id="amountText")
	private WebElement amounttextbox;
	
	public void AmounttextBox() throws InterruptedException {
		Thread.sleep(1000);
		this.amounttextbox.clear();
		this.amounttextbox.sendKeys("500");
	}
	
	@FindBy(xpath="//input[@value='Repay']")
	private WebElement repaybtn;
	
	public void RepayButton() {
		this.repaybtn.click();
	}

}
