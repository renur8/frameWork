package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.Annotations;
public class FindLeadsPage extends Annotations{
	
	public FindLeadsPage() {
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="(//input[@name='firstName'])[3]")
	WebElement eleFirstName;
	
	@FindBy(xpath="//button[text()='Find Leads']")
	WebElement eleFindLeadsButton;
	
	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
	WebElement eleclickFirstEntryName;
	
	@FindBy(linkText="Phone")
	WebElement elePhoneLink;
	
	@FindBy(name="phoneNumber")
	WebElement elePhoneNo;
	
	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
	WebElement eleFirstLeadID;
	
	@FindBy(name="id")
	WebElement eleLeadId;
		
	@FindBy(xpath="//div[text()='No records to display']")
	WebElement eleNoRecordsMsg;
	
	@FindBy(xpath="//span[text()='Email']")
	WebElement eleEmail;
	
	@FindBy(name="emailAddress")
	WebElement eleEmailAddress;
	
	public FindLeadsPage typeFirstName(String fName) {
		type(eleFirstName, fName);
		return this;
	}
	
	public FindLeadsPage clickFindLeadsButton() throws InterruptedException
	{
		click(eleFindLeadsButton);
		Thread.sleep(2000);
		return this;
	}
	public FindLeadsPage clickPhoneLink() {
		click(elePhoneLink);
		return this;
	}
	public FindLeadsPage typePhoneNumber(String phoneNumber)
	{
		type(elePhoneNo, ""+phoneNumber);
		return this;
	}
	
	public FindLeadsPage getFirstLeadID() throws InterruptedException {
		Thread.sleep(2000);
		getText(eleFirstLeadID);
		return this;
	}
	public FindLeadsPage typeLeadId(String LeadID) {
		type(eleLeadId, ""+LeadID);
		return this;
	}
	
	public FindLeadsPage clickEmail() {
		click(eleEmail);
		return this;
	}
	
	public FindLeadsPage typeEmailAddress(String email) {
		type(eleEmailAddress, email);
		return this;
	}
	public FindLeadsPage getNoRecordsMsg() throws InterruptedException
	{
		Thread.sleep(2000);
		getText(eleNoRecordsMsg);
		return this;
		
	}
	
	public ViewLeadPage clickFirstLeadID() {
		click(eleFirstLeadID);
		return new ViewLeadPage();
	}
	public ViewLeadPage clickFirstEntryName() throws InterruptedException {
		Thread.sleep(2000);
		click(eleclickFirstEntryName);
		return new ViewLeadPage();
	}
	

}
