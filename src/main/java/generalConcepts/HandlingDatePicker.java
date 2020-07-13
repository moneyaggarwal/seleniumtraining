package generalConcepts;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDatePicker {
	public static void main(String[] args) throws InterruptedException {

	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
	driver.get("https://www.spicejet.com/default.aspx");
	String appTitle=driver.getTitle();
	
	//explicit wait
	WebDriverWait wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.titleIs(appTitle));
	//Thread.sleep(5000);

	//xpath for depart date picker
	By dateBox=By.xpath("//input[@name='ctl00$mainContent$view_date1']");
	//By datebox=By.xpath("//div[@id='ui-datepicker-div']");
	ElementUtils eu=new ElementUtils(driver);
	eu.fnClick(dateBox);
	
	Thread.sleep(2000);
	String expDay="17";
	String expMonth="March";
	String month="2";
	String expYear="2021";
	Boolean status=false;
	String setMonth;
	String setYear;
	String setMonth2;
	String setYear2;
	String xpath1,xpath2,xpath3,xpath4,finalxpath;
	/*String setMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	String setYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();*/
	while(true)
	{
		setMonth=driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']/div/span[1]")).getText();
		setYear=driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']/div/span[2]")).getText();
		setMonth2=driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']/div/span[1]")).getText();
		setYear2=driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']/div/span[2]")).getText();
		if(((setMonth.equalsIgnoreCase(expMonth)) && (setYear.equalsIgnoreCase(expYear)))||((setMonth2.equalsIgnoreCase(expMonth)) && (setYear2.equalsIgnoreCase(expYear))))
		
		{
			//status=true;
			break;
		}
		else
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
		}
		
	}
	//xpath for march 15 2021 
	//table/tbody/tr/td[contains(@data-month,'2') and @data-year='2021']/a[contains(text(),'7')]
	//click on day
	xpath1="//table/tbody/tr/td[contains(@data-month,'";
	xpath2="') and @data-year='";
	xpath3="']/a[contains(text(),'";
	xpath4="')]";
	
	finalxpath=xpath1+month+xpath2+expYear+xpath3+expDay+xpath4;
	driver.findElement(By.xpath(finalxpath)).click();
	Thread.sleep(5000);
	
			driver.quit();
	}

}
