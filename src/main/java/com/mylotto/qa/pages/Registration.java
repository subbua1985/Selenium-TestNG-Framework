package com.mylotto.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylotto.qa.base.TestBase;

public class Registration extends TestBase {
	
	//Objects
	
	@FindBy(id="nav-menu-account--text")
	WebElement LoginButton;
	
	@FindBy(id="rightMenuNavMenuLoginBlockLoginButton")
	WebElement rightLoginButton;
	
	@FindBy(id="rightMenuNavMenuLoginBlockRegisterButton")
	WebElement regButton;
	
	@FindBy(id="emailAddress")
	WebElement emailInput;
	
	@FindBy(id="firstName")
	WebElement firstInput;

	
	@FindBy(id="lastName")
	WebElement lastInput;
	
	@FindBy(id="password")
	WebElement passInput;
	
	@FindBy(id="confirm-password")
	WebElement cpassInput;
	
	@FindBy(id="dobDay")
	WebElement dayInput;
	
	@FindBy(id="dobMonth")
	WebElement monthInput;
	
	@FindBy(id="dobYear")
	WebElement yearInput;

	@FindBy(id="maleCheckboxLabel")
	WebElement maleInput;
	
	
	public Registration() throws IOException{
		PageFactory.initElements(driver, this);
		
	}
	
	
	//For Excel Sheet Data Provider
	//Actions in the Registration page, but using Data Provider concept to retrieve data from TestData.xlsx
	
	public void RegistrationFormExcelSheet(String email,String fistname, String lastname, String password, String cpassword) throws InterruptedException {
		LoginButton.click();
		regButton.click();
		emailInput.sendKeys(email);
		firstInput.sendKeys(fistname);
		lastInput.sendKeys(lastname);
		passInput.sendKeys(password);
		cpassInput.sendKeys(cpassword);
		maleInput.click();
		Thread.sleep(5000);
		
	}
}
