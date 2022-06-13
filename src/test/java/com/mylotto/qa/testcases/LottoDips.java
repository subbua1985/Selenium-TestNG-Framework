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
import com.mylotto.qa.pages.Lotto;
import com.mylotto.qa.util.TestUtil;

public class LottoDips extends TestBase{

String sheetName = "Players"; //Players is the name of the sheet available in the TestData.xlsx

	public LottoDips() throws IOException {
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
	
	//Below LoginAndDips method must match with the number of columns including column names in the test data file TestData.xlsx
	public void LoginAndDips(String player_email, String player_password) throws IOException, InterruptedException {
		
		Lotto lot = new Lotto();
		lot.LoginForm(player_email,player_password);
		lot.lottoLuckyDips();
	}
	
	/*
	@Test(priority=2)
	
	public void LottoBuyADip() throws IOException, InterruptedException
	{
		Lotto lot = new Lotto();
		lot.lottoDips();
		
	}
	*/
	

	@AfterMethod
	public void tearDown() {
		driver.quit();}
						   
}

