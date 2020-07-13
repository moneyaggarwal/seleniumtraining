package com.TestngConcepts.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogInTestUsingparametersConcept {
	
	public WebDriver driver;
	//Bypatterns
	By username1=By.id("username");
	By password1=By.id("password");
	By loginButton=By.xpath("//button[@type='submit']");
	Properties prop= new Properties();
	@BeforeTest
	//declaring parameter annotation
	
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
	  
	  @Test
	  @Parameters({"userName","passWord"})
	  public void enterLoginDetails(String userName,String passWord)
	  {
		  boolean status;
		  try
		  {
		  driver.findElement(By.xpath("//a[@class='log-in static-buttons']")).click();
		  driver.findElement(username1).sendKeys(userName);
		  driver.findElement(password1).sendKeys(passWord);
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
