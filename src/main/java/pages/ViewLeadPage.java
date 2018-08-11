package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.Annotations;
public class ViewLeadPage extends Annotations {
	
	public ViewLeadPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="viewLead_firstName_sp")
	WebElement eleFirstName;
	
	@FindBy(linkText="Edit")
	WebElement eleEditButton;
	
	@FindBy(id="viewLead_companyName_sp")
	WebElement eleViewCName;
	
	@FindBy(linkText="Delete")
	WebElement eleDeleteButton;
	
	public ViewLeadPage verifyFirstName(String fName) {
		verifyExactText(eleFirstName, fName);
		return this;
	}
	
	public Opentaps_CRMPage clickEditButton() {
		click(eleEditButton);
		return new Opentaps_CRMPage();
	}
	public ViewLeadPage verifyUpdatedCName(String cName) {
		verifyPartialText(eleViewCName, cName);
		return this;
	}
	public FindLeadsPage clickDeleteButton()
	{
		click(eleDeleteButton);
		return new FindLeadsPage();
	}
}
