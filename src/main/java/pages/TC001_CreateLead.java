package pages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import wdMethods.Annotations;

public class TC001_CreateLead extends Annotations {

	@BeforeTest
	public void setData()
	{
		excelFileName="CreateLead";
		testName="create lead";
		testDesc="create a new lead";
		category="smoke";
		author="renuka";
		moduleName="lead";
	}
	@Test(dataProvider="fetchData")

	public void createLead(String cName,String fName, String lName,String ph,String email) {
		new MyHomePage()
		.clickLeads()
		.clickCreateLeads()
		.typeCompanyName(cName)
		.typefirstName(fName)
		.typeLastName(lName)
		.typePhoneNumber(ph)
		.typeEmail(email)
		.clickSubmitButton()
		.verifyFirstName(fName);
	
	}
	}
