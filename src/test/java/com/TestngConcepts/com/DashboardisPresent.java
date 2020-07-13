package com.TestngConcepts.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//checking dashboard independently without login will always fail 
public class DashboardisPresent {
	WebDriver driver;
	By username=By.id("username");
	By password=By.id("password");
	By loginButton=By.xpath("//button[@type='submit']");
	By dashboardLink=By.linkText("Dashboard");
	@BeforeTest
	  public void init_Setup() {
		  WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("https://www.surveymonkey.com/"); 
	  }
		  
		  
	  @AfterTest
	  public void teardown() {
		  driver.quit();
	  }
	  
	  
	  @Test
	  public void enterLoginDetails()
	  {
		  boolean status;
		  try
		  {
		  driver.findElement(By.xpath("//a[@class='log-in static-buttons']")).click();
		  driver.findElement(username).sendKeys("Seleniumtraining1");
		  driver.findElement(password).sendKeys("selenium1234");
		  driver.findElement(loginButton).click();  
		  status=true;
		  }
		  catch(Exception s)
		  {
			  status=false;
		  }
		  Assert.assertEquals(status,true);
		  
		  
	  }
	  
	  @Test(dependsOnMethods= {"enterLoginDetails"})
	  public void checkDashboardIsPresent()
	  {
	 	 
	 	 boolean status;
	 	  try
	 	  {
	 		  driver.findElement(dashboardLink).isDisplayed();
	 		  status = true;
	 		 // System.out.println(status);
	 	  }
	 	  catch(Exception e)
	 	  {
	 		  status=false;
	 		  //System.out.println(status);
	 	  }
	 	  Assert.assertEquals(status,true);
	  }
	   
}
