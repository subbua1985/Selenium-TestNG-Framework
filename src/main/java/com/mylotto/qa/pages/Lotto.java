package com.mylotto.qa.pages;

import java.io.IOException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylotto.qa.base.TestBase;

public class Lotto extends TestBase {

	// Objects	
	
	@FindBy(id = "navLottosecondary")
	WebElement lottoButton;
	
	@FindBy(id = "button-buy")
	WebElement buyButton;
	
	
	@FindBy(id = "Lucky-Dip-5-6")
	WebElement LinesLuckyDip56;

	@FindBy(id = "password")
	WebElement loginPass;

	
	@FindBy(name = "email")
	WebElement loginEmail;
	
	
	@FindBy(name = "login-form-login-button")
	WebElement loginButton;
	
	
	@FindBy(id = "confirmation-button")
	WebElement confirmPurchase;
	
	
	public Lotto() throws IOException {
		PageFactory.initElements(driver, this);

	}

	public void LoginForm(String player_email,String player_password) throws IOException, InterruptedException {
		
		driver.navigate().to("https://2.cat.mylotto.co.nz/#login");
		loginEmail.sendKeys(player_email);
		loginPass.sendKeys(player_password);
		//loginButton.click();
		driver.findElement(By.cssSelector(".lnzfdn-button.lnzfdn-button--fill")).click();
		Thread.sleep(5000);		
	}

	
	public void lottoDips() throws InterruptedException {		
	   	driver.navigate().to("https://2.cat.mylotto.co.nz/lotto/dips");
	   	LinesLuckyDip56.click();
	   	buyButton.click();
		Thread.sleep(4000);
		confirmPurchase.click();
		Thread.sleep(4000);		
		boolean b = driver.findElement(By.className("lnz-thanks-page__thanks-header-text")).isDisplayed();
		System.out.println("Wager Success based on above boolean");
	}

}
