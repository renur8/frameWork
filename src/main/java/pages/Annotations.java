package wdMethods;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import excelfun.ReadExcel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class Annotations extends SeMethods{
	public String excelFileName,testName,testDesc,category,author,moduleName;
  @BeforeSuite
  public void startSuite() {
	  beginResult();
  }
  
  @BeforeClass
  public void startTest() {
	  startTest(testName, testDesc);
  }
  @Parameters({"url","uName","pwd"})
  @BeforeMethod
  public void login(String url,String uName,String pwd) {
	    startTestIteration(moduleName, author, category);
	  	startApp("chrome", url);
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName,uName);
//		WebElement elePassword = locateElement("id","password");
//		type(elePassword, "crmsfa");
		
		type(locateElement("id","password"), pwd);
		WebElement eleLogin = locateElement("class","decorativeSubmit");
		click(eleLogin);
		click(locateElement("linkText", "CRM/SFA"));
		
  }

  @AfterMethod
  public void closeApp() {
	  closeAllBrowsers();
  }
  
  @AfterSuite
  public void stopSuite() {
	  endResult();
  }
  @DataProvider(name="fetchData")
	public Object[][] getData() throws IOException{
		
		return ReadExcel.readExcel(excelFileName);
			}
	

}
