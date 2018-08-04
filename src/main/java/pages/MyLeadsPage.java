package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.Annotations;
public class MyLeadsPage extends Annotations{
	
	public MyLeadsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Create Lead")
	WebElement eleCreateLead;
	
	@FindBy(linkText="Find Leads")
	WebElement eleFindLead;

	
	public CreateLeadPage clickCreateLeads() {
		click(eleCreateLead);
		return new CreateLeadPage();
	}
	
	public FindLeadsPage clickFindLeads() {
		click(eleFindLead);
		return new FindLeadsPage();
		
	}


}
