package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import listeners.Reporter;

public class SeMethods extends Reporter implements WdMethods{
	public static RemoteWebDriver driver ;
	int i = 1;
	public void startApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
				//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				 driver = new ChromeDriver();			
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckoriver.exe");
				 driver = new FirefoxDriver();		
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//System.out.println("The Browser "+browser+" is Launched Successfully");
			reportStep("The Browser "+browser+" is Launched Successfully", "pass");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("Webriver exception has occured");
			reportStep("The Browser "+browser+" is not Launched Successfully", "fail");
			throw new RuntimeException();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception has occured");
			throw new RuntimeException();
		}
		finally {
		takeSnap();
		}
	}

	@SuppressWarnings("finally")
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case "id": 	  return driver.findElementById(locValue);
			case "class": return driver.findElementByClassName(locValue);
			case "name": return driver.findElementByName(locValue);
			case "xpath": return driver.findElementByXPath(locValue);
			case "linkText": return driver.findElementByLinkText(locValue);
			case "tagName": return driver.findElementByTagName(locValue);
			case "CSS": return driver.findElementByCssSelector(locValue);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("NoSuchElementException has occured");
			throw new RuntimeException();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception has occured");
			throw new RuntimeException();
		}
		finally {
		takeSnap();
		}
		return null;
	}

	public WebElement locateElement(String locValue) {
		takeSnap();
		return driver.findElementById(locValue);
	}

	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			//System.out.println("The Data "+data+" is Entered Successfully");
			reportStep("The Data "+data+" is Entered Successfully", "pass");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.out.println(" WebDriverException has occured");
			reportStep("The Data "+data+" is not Entered Successfully", "fail");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception has occured");
			throw new RuntimeException();
		}
		finally {
		takeSnap();
		}
		
		}
	

	public void click(WebElement ele) {
	try {
		ele.click();
		//System.out.println("The Element "+ele+" is clicked Successfully");
		reportStep("The Element "+ele+" is clicked Successfully", "pass");
	} catch (WebDriverException e) {
		// TODO Auto-generated catch block
		//System.out.println(" WebDriverException has occured");
		reportStep("WebDriverException has occured", "fail");
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		System.err.println("Exception has occured");
		throw new RuntimeException();
	}
	finally {
	takeSnap();
	}
		
	}

	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		String gText=ele.getText();
		System.out.println("Text in GUI is" +gText);
		takeSnap();
		return gText ;

	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		// TODO Auto-generated method stub
		
		Select dropDownText = new Select(ele);
		dropDownText.selectByVisibleText(value);
		System.out.println("The text"+value+"is selected successfully");
		takeSnap();
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		Select dropDownIndex = new Select(ele);
		dropDownIndex.selectByIndex(index);
		System.out.println("The index value"+index+"is selected successfully");

	}
	

	public boolean verifyTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Exact title verification is passed");
			return true;
		}
		else
		{
			System.out.println("Exact Title verification failed, expected is "+expectedTitle +" - actual is "+actualTitle );
			return false;
		}
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		
		String appText = ele.getText();
		
		if(appText.equals(expectedText)) {
			
			//System.out.println("Exact text  verification is passed ");
			reportStep("Exact text  verification is passed", "pass");
		}
		else {
			//System.out.println("Exact Text verification failed, expected is "+expectedText+" - actual is "+appText);
			reportStep("Exact Text verification failed, expected is "+expectedText+" - actual is "+appText, "fail");
		}
		
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		String appText = ele.getText();
		
		if(appText.contains(expectedText)) {
			
			//System.out.println("partial text  verification is passed ");
			reportStep("partial text  verification is passed"+expectedText+"actual is"+appText, "pass");
		}
		else {
			//System.out.println("partial Text verification failed, expected is "+expectedText+" - actual is "+appText);
			reportStep("partial Text verification failed, expected is "+expectedText+" - actual is "+appText, "fail");
		}
		
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		String attributeValue=ele.getAttribute("value");
		if(attributeValue.equals(value)) {
			
			System.out.println("Exact Attribute verification is passed ");
		}
		else {
			System.out.println("Exact Attribute verification failed, expected is "+value+" - actual is "+attributeValue);
		}
		
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		String attributeValue=ele.getAttribute(attribute);
		if(attributeValue.contains(value)) {
			
			System.out.println("Exact Attribute verification is passed ");
		}
		else {
			System.out.println("Exact Attribute verification failed, expected is "+value+" - actual is "+attributeValue);
		}
		
	}
	

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		boolean selectedElement = ele.isSelected();
		if(selectedElement=true)
		{
			System.out.println("Given element"+ele+"is selected");
		}
		else
			System.out.println("Given element"+ele+"is not selected");
		takeSnap();
	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		boolean displayed = ele.isDisplayed();
		if(displayed=true) {
			System.out.println("Given element"+ele+"is displayed");
		}
		else
			System.out.println("Given element"+ele+"is not displayed");
		takeSnap();
	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindow = driver.getWindowHandles();
			List<String> listOfWindows=new ArrayList<String>();
			listOfWindows.addAll(allWindow);
			driver.switchTo().window(listOfWindows.get(index));
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("NoSuchWindowException has occured");
			throw new RuntimeException();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception has occured");
			throw new RuntimeException();
		}
		finally {
			takeSnap();
		}
	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().frame(ele);
		} catch (NoSuchFrameException e) {
			// TODO Auto-generated catch block
			System.err.println("NoSuchFrameException has occured");
			throw new RuntimeException();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception has occured");
			throw new RuntimeException();
		}
		finally {
		takeSnap();
		}
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().accept();
		takeSnap();
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().dismiss();
		takeSnap();

	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		String text = driver.switchTo().alert().getText();
		takeSnap();
		return text;
		
	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("C:\\workspace\\Seljuly18\\src\\main\\ss\\snap"+i+".png");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		driver.close();
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		driver.quit();
	}
	public void mouseOver(WebElement ele1,WebElement ele2)
	{
		Actions builder=new Actions(driver);
		builder.moveToElement(ele1).pause(3000).click(ele2).perform();
	}
	public void clearData(WebElement ele) {
		ele.clear();
		
}
	public int StringConvertedToInt(String value)
	{
		int val=Integer.parseInt(value);
		return val;
	}
}