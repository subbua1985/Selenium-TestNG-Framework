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

	@FindBy(id = "Lucky-Dip-7")
	WebElement LinesLuckyDip7;
	
	@FindBy(id = "Lucky-Dip-10-5")
	WebElement LinesLuckyDip105;
	
	@FindBy(id = "Triple-Dip-16")
	WebElement TripleDip16;

	@FindBy(id = "Triple-Dip-18")
	WebElement TripleDip18;
	
	@FindBy(id = "Triple-Dip-20")
	WebElement TripleDip20;
	
	
	
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
		driver.findElement(By.cssSelector(".lnzfdn-button.lnzfdn-button--fill")).click();
		Thread.sleep(5000);		
	}

	
	public void lottoLuckyDips() throws InterruptedException {	
		//Lucky Dip $5.60
	   	driver.navigate().to("https://2.cat.mylotto.co.nz/lotto/dips");
	   	LinesLuckyDip56.click();
	   	buyButton.click();
		Thread.sleep(4000);
		confirmPurchase.click();
		Thread.sleep(4000);		
		boolean b = driver.findElement(By.className("lnz-thanks-page__thanks-header-text")).isDisplayed();
		System.out.println("Wager Success based on above boolean");
		
		
		//Lucky Dip $5.60
		driver.navigate().to("https://2.cat.mylotto.co.nz/lotto/dips");
		LinesLuckyDip7.click();
	   	buyButton.click();
		Thread.sleep(4000);
		confirmPurchase.click();
		Thread.sleep(4000);		
		boolean c = driver.findElement(By.className("lnz-thanks-page__thanks-header-text")).isDisplayed();
		System.out.println("Wager Success based on above boolean");
		
		//Lucky Dip $5.60
		driver.navigate().to("https://2.cat.mylotto.co.nz/lotto/dips");
		LinesLuckyDip105.click();
	   	buyButton.click();
		Thread.sleep(4000);
		confirmPurchase.click();
		Thread.sleep(4000);		
		boolean d = driver.findElement(By.className("lnz-thanks-page__thanks-header-text")).isDisplayed();
		System.out.println("Wager Success based on above boolean");
	}

	public void lottoTripleDips() throws InterruptedException {	
		//Triple Dip $16.0
	   	driver.navigate().to("https://2.cat.mylotto.co.nz/lotto/dips");
	   	TripleDip16.click();
	   	buyButton.click();
		Thread.sleep(4000);
		confirmPurchase.click();
		Thread.sleep(4000);		
		boolean e = driver.findElement(By.className("lnz-thanks-page__thanks-header-text")).isDisplayed();
		System.out.println("Wager Success based on above boolean");

		//Triple Dip $16.0
	   	driver.navigate().to("https://2.cat.mylotto.co.nz/lotto/dips");
	   	TripleDip18.click();
	   	buyButton.click();
		Thread.sleep(4000);
		confirmPurchase.click();
		Thread.sleep(4000);		
		boolean f = driver.findElement(By.className("lnz-thanks-page__thanks-header-text")).isDisplayed();
		System.out.println("Wager Success based on above boolean");
		
		//Triple Dip $16.0
	   	driver.navigate().to("https://2.cat.mylotto.co.nz/lotto/dips");
	   	TripleDip20.click();
	   	buyButton.click();
		Thread.sleep(4000);
		confirmPurchase.click();
		Thread.sleep(4000);		
		boolean g = driver.findElement(By.className("lnz-thanks-page__thanks-header-text")).isDisplayed();
		System.out.println("Wager Success based on above boolean");
	}
	
}
