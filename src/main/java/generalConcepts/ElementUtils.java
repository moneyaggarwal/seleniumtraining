package generalConcepts;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {
	
	WebElement element;
	WebDriver driver;
	List<WebElement> lists;
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	private WebElement getElement(By locatorvalue)
	{
		element=driver.findElement(locatorvalue);
		return element;
	}
	public void fnSendKeys(By locatorvalue,String valueToBeSent)
	{
		getElement(locatorvalue).sendKeys(valueToBeSent);
	}
	public void fnClick(By locatorvalue)
	{
		getElement(locatorvalue).click();
	}
	private List<WebElement> getElements(By locatorvalue)
	{
		lists=driver.findElements(locatorvalue);
		return lists;
	}
	public ArrayList<String> displayAllElements(By locatorvalue)
	{
		lists=getElements(locatorvalue);
		ArrayList<String> al=new ArrayList<String>();
		for (int i = 0; i <lists.size(); i++) {
			al.add(lists.get(i).getText());	
		}
		return al;
	}
	public void capturePageScreenshot(WebDriver driver,File fileName)
	{
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,new File("./target/screenshot/"+fileName+".png"));
		}catch(Exception e) {
			e.getMessage();
		}
		
	}

}
