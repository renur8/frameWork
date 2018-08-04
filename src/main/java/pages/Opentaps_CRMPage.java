package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.Annotations;
public class Opentaps_CRMPage extends Annotations {
	
	public Opentaps_CRMPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="updateLeadForm_companyName")
	WebElement eleUpdateCName;
	
	@FindBy(name="submitButton")
	WebElement eleUpdateButton;
	
	public Opentaps_CRMPage updateCName(String cName) throws InterruptedException {
		clearData(eleUpdateCName);
		Thread.sleep(2000);
		type(eleUpdateCName, cName);
		return this;
	}
	
	public ViewLeadPage clickUpdateButton() {
		click(eleUpdateButton);
		return new ViewLeadPage();
	}

}
