package com.mylotto.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mylotto.qa.base.TestBase;
import com.mylotto.qa.pages.IGTControlActivationCode;
import com.mylotto.qa.util.TestUtil;

public class EmailActivation extends TestBase{

	String sheetName = "Reg"; 
	
	public EmailActivation() throws IOException {
		super();
	}
	
	@DataProvider     //Data Provider will be the priority during compile, than @BeforeMethod 
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName); //getTestData is the method in TestUtil.java package that got xlsx reading algorithm
		return data;
	}

	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initializationIGTControl();
		Thread.sleep(4000);
		
	}
	
	@Test(priority=1, dataProvider="getTestData")
	
	/*public void Activation() throws IOException, InterruptedException {
		
		IGTControlActivationCode igt = new IGTControlActivationCode();
		igt.LoginForm();
		
	}*/
	
	public void SearchAndActivation(String email,String fistname, String lastname, String password, String cpassword, String dob_date, String dob_year, String mobile) throws InterruptedException, IOException {
		
		IGTControlActivationCode igt = new IGTControlActivationCode();
		igt.LoginForm();
		igt.PlayerSearch(email);
		//Thread.sleep(10000);
		
	}
	
	/*
	@Test(priority=2, dataProvider="getTestData")
	public void SearchAndActivation(String email,String fistname, String lastname, String password, String cpassword, String dob_date, String dob_year, String mobile) throws InterruptedException, IOException {
		
		IGTControlActivationCode igtc = new IGTControlActivationCode();
		igtc.PlayerSearch(email);

	}
	*/
	
	@AfterMethod
	public void tearDown() {
		driver.quit();}
						   

}
