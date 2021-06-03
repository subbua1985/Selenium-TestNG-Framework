package com.mylotto.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylotto.qa.base.TestBase;

public class LoginPage extends TestBase{

	//PageFactory or Object Repository here
	
	@FindBy(name="emailAddress")
	WebElement emailAddress;
	
	@FindBy(name="password")
	WebElement password;

	@FindBy(name="login")
	WebElement login;
	
	@FindBy(id="signupNowLink")
	WebElement signupNowLink;
	
	@FindBy(id="nav-menu-account--text")
	WebElement LoginButton;
	
	@FindBy(id="rightMenuNavMenuLoginBlockLoginButton")
	WebElement rightLoginButton;
	
	
	//Initializing the page objects:
	public LoginPage() throws IOException {
		super();
		
		PageFactory.initElements(driver, this);  //this keyword means current class objects (ie emailAddress, password, login etc)
		
	}
	
	//Actions here
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLoginButton() {
		return login.isDisplayed();
	}
	
	public void actuallogin(String emailAdd, String pwd) {
		LoginButton.click();
		rightLoginButton.click();
		emailAddress.sendKeys(emailAdd);  //From Object repository - emailAddress
		password.sendKeys(pwd);
		login.click();
		
	}
	
}
