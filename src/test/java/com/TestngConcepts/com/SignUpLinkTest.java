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

public class SignUpLinkTest {
	WebDriver driver;
	By signuplink=By.linkText("SIGN UP");

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
		  public void verifySignUpIsDisplayed()
		  {
			  boolean status;
			  try
			  {
				  driver.findElement(signuplink).isDisplayed();
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
