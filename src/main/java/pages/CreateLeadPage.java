package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.Annotations;
public class CreateLeadPage extends Annotations {
	
	public CreateLeadPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="createLeadForm_companyName")
	WebElement eleCompanyName;
	
	@FindBy(id="createLeadForm_firstName")
	WebElement eleFirstName;

	@FindBy(id="createLeadForm_lastName")
	WebElement eleLastName;

	@FindBy(id="createLeadForm_primaryPhoneNumber")
	WebElement elePhone;

	@FindBy(id="createLeadForm_primaryEmail")
	WebElement eleEmail;
	
	@FindBy(className="smallSubmit")
	WebElement eleSubmitButton;
	
	@FindBy(className="errorMessage")
	WebElement eleErrorMsg;

	public CreateLeadPage typeCompanyName(String cName) {
		type(eleCompanyName, cName);
		return this;
	}
	
	public CreateLeadPage typefirstName(String fName) {
		type(eleFirstName, fName);
		return this;
	}
	public CreateLeadPage typeLastName(String lName) {
		type(eleLastName, lName);
		return this;
	}
	public CreateLeadPage typePhoneNumber(String ph) {
		type(elePhone, ph);
		return this;
	}
	
	public CreateLeadPage typeEmail(String email) {
		type(eleEmail, email);
		return this;
	}
	
	public ViewLeadPage clickSubmitButton() {
		click(eleSubmitButton);
		return new ViewLeadPage();
	}
	public CreateLeadPage clickSubmitButtonForFailure() {
		click(eleSubmitButton);
		return this;
	}
	
	public CreateLeadPage viewErrorMsg(String expectedText)
	{
		verifyPartialText(eleErrorMsg, expectedText);
		return this;
	}
	
}
