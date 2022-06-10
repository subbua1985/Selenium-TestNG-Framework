/*
 * Author: Subramani.Ayyanar@lottonz.co
 */
package com.mylotto.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mylotto.qa.base.TestBase;
import com.mylotto.qa.pages.Registration;
import com.mylotto.qa.util.TestUtil;

public class RegistrationMyLotto extends TestBase {

String sheetName = "Reg"; //Reg is the name of the first sheet given in the TestData.xlsx

	public RegistrationMyLotto() throws IOException {
		super();
	}

	
	@DataProvider     //Data Provider will be the priority during compile, than @BeforeMethod 
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName); //getTestData is the method in TestUtil.java package that got xlsx reading algorithm
		return data;
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		
	}
	
	@Test(priority=1, dataProvider="getTestData") //Provides all the TestData from the sheet (getTestData)
	
	//Below RegistrationForm method must match with the number of columns including column names in the test data file TestData.xlsx
	public void RegistrationForm(String email,String fistname, String lastname, String password, String cpassword, String dob_date, String dob_year, String mobile) throws IOException, InterruptedException {
		Registration reg = new Registration();
		reg.RegistrationFormExcelSheet(email, fistname, lastname, password, cpassword, dob_date, dob_year, mobile);
		System.out.println("I am in RegistrationForm");
		System.out.println(email +"  via csv");
		System.out.println(fistname +"  via csv");
		System.out.println(lastname +"  via csv");
		System.out.println(password +"  via csv");
		System.out.println(cpassword +"  via csv");
		System.out.println(mobile +"  via csv");
		Thread.sleep(2000);
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();}
						   
}

