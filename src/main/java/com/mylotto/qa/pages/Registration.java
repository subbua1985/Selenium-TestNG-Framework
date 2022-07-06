package com.mylotto.qa.pages;

import java.io.IOException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylotto.qa.base.TestBase;

public class Registration extends TestBase {

	// Objects

	@FindBy(id = "nav-menu-main-signup-link")
	WebElement LoginButton;

	@FindBy(id = "login-modal-signup")
	WebElement rightLoginButton;

	@FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[4]/div/ul/li/button")
	
	WebElement regButton;

	@FindBy(id = "email")
	WebElement emailInput;

	@FindBy(id = "password")
	WebElement passInput;

	@FindBy(name = "password2")
	WebElement cpassInput;

	@FindBy(name = "firstName")
	WebElement firstInput;

	@FindBy(name = "lastName")
	WebElement lastInput;

	@FindBy(name = "dobDay")
	WebElement dayInput;

	@FindBy(name = "dobMonth")
	WebElement monthInput;

	@FindBy(name = "dobYear")
	WebElement yearInput;

	@FindBy(id = "label-male")
	WebElement maleInput;

	@FindBy(id = "femaleCheckboxLabel")
	WebElement femaleInput;

	@FindBy(id = "mobileNetwork")
	WebElement mob_net;

	@FindBy(id = "mobilePhoneNumber")
	WebElement mob_no;

	@FindBy(name = "location")
	WebElement loc;

	@FindBy(name = "city")
	WebElement city;

	public Registration() throws IOException {
		PageFactory.initElements(driver, this);

	}

	// For Excel Sheet Data Provider
	// Actions in the Registration page, but using Data Provider concept to retrieve
	// data from TestData.xlsx

	public void RegistrationFormExcelSheet(String email, String fistname, String lastname, String password,
			String cpassword, String dob_date, String dob_year, String mobile) throws InterruptedException {
		LoginButton.click();
		regButton.click();
		emailInput.sendKeys(email);
		passInput.sendKeys(password);
		cpassInput.sendKeys(cpassword);
		firstInput.sendKeys(fistname);
		lastInput.sendKeys(lastname);
		dayInput.sendKeys(dob_date);
		Select dob_month = new Select(driver.findElement(By.name("dobMonth")));
		dob_month.selectByVisibleText("September");
		yearInput.sendKeys(dob_year);
		maleInput.click();
		mob_no.sendKeys(mobile);
		Select loc = new Select(driver.findElement(By.name("location")));
		loc.selectByVisibleText("Marlborough");
		Select p_city = new Select(driver.findElement(By.name("city")));
		p_city.selectByVisibleText("Marlborough");
		 Thread.sleep(1000);
		//driver.findElement(By.cssSelector(".lnzfdn-button.lnzfdn-button--fill")).click();
		 driver.findElement(By.xpath("//span[contains(text(),'Sign up')]")).click();
	}
	
}
