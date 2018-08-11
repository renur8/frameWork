package pages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import wdMethods.Annotations;

public class TC002_EditLead extends Annotations {

	@BeforeTest
	public void setData()
	{
		excelFileName="TC002_EditLead";
		testName="Edit lead";
		testDesc="changing company name for an existing lead";
		category="smoke";
		author="renuka";
		moduleName="lead";
	}
	@Test(dataProvider="fetchData")

	public void createLead(String fName,String cName) throws InterruptedException {
		new MyHomePage()
			.clickLeads()
			.clickFindLeads()
			.typeFirstName(fName)
			.clickFindLeadsButton()
			.clickFirstEntryName()
			.clickEditButton()
			.updateCName(cName)
			.clickUpdateButton()
			.verifyUpdatedCName(cName);
	
	}
	}
