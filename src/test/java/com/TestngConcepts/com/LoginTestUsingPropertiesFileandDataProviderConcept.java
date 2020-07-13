package com.TestngConcepts.com;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTestUsingPropertiesFileandDataProviderConcept {
	public WebDriver driver;
	//Bypatterns
	By username=By.id("username");
	By password=By.id("password");
	By loginButton=By.xpath("//button[@type='submit']");
	Properties prop= new Properties();

	//By signuplink=By.linkText("SIGN UP");
			//By.xpath("//a[@class='sign-up']");
	//By dashboardLink=By.linkText("Dashboard");
  
  @BeforeTest
  public void init_Setup() throws IOException {
	  
	  //using url from data.properties file
	  
	    
	    WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//System.out.println("afetr driver manage");
		//File file=new File(System.getProperty("user.dir")+"\\src\\main\\resources\\Config\\data.properties");
		//FileInputStream source=new FileInputStream(user.dir+"\\src\\main\\resources\\Config\\data.properties");
	    
		//usind user.dir with fileinputstream will never work so we use File system.getproperty 
		//to generate path and get relative path with System.getProperty("user.dir")(returns string)
		
		//FileInputStream sourcefile= new FileInputStream("C:\\Users\\aggar\\eclipse-workspace\\SeleniumTraining\\src\\main\\resources\\Config\\data.properties");
		String filepath=System.getProperty("user.dir")+"\\src\\main\\resources\\Config\\data.properties";
		FileInputStream sourcefile= new FileInputStream(filepath);
		
		prop.load(sourcefile);
	    String resourceurl=prop.getProperty("url");
	    driver.get(resourceurl);
		//driver.get("https://www.surveymonkey.com/"); 
  }
	  
	  
  @AfterTest
  public void teardown() {
	  driver.quit();
  }
  
 /* @Test(priority=1)
  public void checkTitle()
  {
	 String title= driver.getTitle();
	 Assert.assertEquals(title, "SurveyMonkey: The World’s Most Popular Free Online Survey Tool");
  }*/
  
  /*@DataProvider
  public Object keepData()
  {
	  Object userdetails[][]=new Object[2][2];
	  userdetails[0][0]="Seleniumtraining1";
	  userdetails[0][1]="selenium1234";
	  userdetails[1][0]="Seleniumtraining1";
	  userdetails[1][1]="selenium1234";
	  return userdetails;
  }
  //using dataprovider concept
  @Test(dataProvider="keepData")
  public void enterLoginDetailsUsingDataProvider(String userName,String Password)
  {
	  boolean status;
	  try
	  {
	  driver.findElement(By.xpath("//a[@class='log-in static-buttons']")).click();
	  driver.findElement(username).sendKeys(userName);
	  driver.findElement(password).sendKeys(Password);
	  driver.findElement(loginButton).click();  
	  status=true;
	  }
	  catch(Exception s)
	  {
		  status=false;
	  }
	  Assert.assertEquals(status,true);
	  
	  
  }
  */
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
  
 
  
 

}
