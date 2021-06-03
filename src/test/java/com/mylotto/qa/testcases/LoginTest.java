package com.mylotto.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mylotto.qa.base.TestBase;
import com.mylotto.qa.pages.LoginPage;

public class LoginTest extends TestBase{

	LoginPage log; //This means using "log" variable we can access all functions/objects from LoginPage class
	
	public LoginTest() throws IOException {
		super(); //super() is to enable access the TestBase class objects
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		log = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void validateLoginPageTitle() {
		String title = log.validateLoginPageTitle();
		Assert.assertEquals(title, "Official Lotto NZ website");
		System.out.println(title);
		
	}
	
	@Test(priority=2)
	public void loginTestMyLotto() {
		
		log.actuallogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
