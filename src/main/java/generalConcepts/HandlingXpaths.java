package generalConcepts;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingXpaths {

	public static void main(String[] args) throws InterruptedException {
		// relative xpaths
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/default.aspx");
		
	
		//create By patterns
		//System.out.println("before bypatterns");
		By roundTripradio=By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']");
		By seniorCitizencheckbox=By.xpath("//label[contains(text(),'Senior Citizen')]");
		
		// find xpath for all radio buttons
		//?*****
		By allRadio=By.xpath("//table[@id='ctl00_mainContent_rbtnl_Trip']/tbody/tr/td");
		//this xpath doesnot display values
		//By allCheckBox=By.xpath("//input[@type='checkbox']");
		
		//*** xpath to get all checkboxes
		//By allCheckBox=By.id("discount-checkbox");
		By allCheckBox=By.xpath("//div[@id='discount-checkbox']");
		
		
		
		ElementUtils eu=new ElementUtils(driver);
		eu.fnClick(roundTripradio);
		Thread.sleep(2000);
		eu.fnClick(seniorCitizencheckbox);
		
	    System.out.println(eu.displayAllElements(allRadio));
		System.out.println("after variable instantiation");
		/*//print all radio
		for (String  a: radiobuttonList) {
			System.out.println(a);
		}
		for (int i = 0;i<radiobuttonList.size(); i++) {
			
			System.out.println(radiobuttonList(i));
		}*/
		//System.out.println(eu.displayAllElements(allCheckBox));
		//using for each loop
		ArrayList<String> checkBoxList=eu.displayAllElements(allCheckBox);
		//print all checkbox
				for (String  b: checkBoxList)
				{
					System.out.println(b);
				}
		
	    
		
		driver.quit();
		
			
		}
		

	}


