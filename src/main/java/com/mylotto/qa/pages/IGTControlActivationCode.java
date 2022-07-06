package com.mylotto.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylotto.qa.base.TestBase;

public class IGTControlActivationCode extends TestBase {
	
	public IGTControlActivationCode() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	// Objects	
	
	@FindBy(id = "gkl")
	WebElement loginID;

	@FindBy(id = "gkp")
	WebElement loginPass;
	
	@FindBy(id = "signIn")
	WebElement SignInButton;	
	
	@FindBy(xpath = "//*[@id=\"parentMenu_2\"]/a/img")
	WebElement playerImg;
	
	@FindBy(id = "select2-search-criteria-container")
	WebElement playeremail;
	
	@FindBy(id = "select2-search-criteria-result-f4p5-EMAIL")
	WebElement emailDropDown;
	
	@FindBy(id = "value_criteria")
	WebElement emailInput;
	
	
	@FindBy(id = "select2-search-criteria-result-06lf-EMAIL")
	WebElement emailChoice;
	
	@FindBy(id = "searchButton")
	WebElement search;
	
	@FindBy(id = "player_TABLIST")
	WebElement contact;
	
	@FindBy(id = "tbody-tplayer")
	WebElement selPlayer;
	
	
	@FindBy(id = "boxDetailsPlayer_8")
	WebElement commPlayer;
	
	public void LoginForm() throws IOException, InterruptedException {
		
		//SignInButton.click();
		loginID.sendKeys("1");
		loginPass.sendKeys("1");
		SignInButton.click();
		Thread.sleep(2000);
	}

	
	//   //*[@id="commView_0_1200000175"]
	
	
	public void PlayerSearch(String email) throws InterruptedException {
		
		playerImg.click();
		//drpDown.selectByVisibleText("E-mail");
		driver.findElement(By.cssSelector("span[id='select2-search-criteria-container']")).click();
		Thread.sleep(2000);
		//Selecting the E-mail from the dropdown boss "li means array list" sot get(1) will pick the second record
		driver.findElements(By.className("select2-results__option")).get(1).click();
		emailInput.sendKeys(email);
		search.click();
		Thread.sleep(2000);
		selPlayer.click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[contains(.,' Confirm your MyLotto email ')]")).click();
		driver.findElement(By.xpath("/html/body/section/div/div[2]/div/div[2]/div[51]/div[1]/div/div/div[1]/div[4]/div/div[2]/div/div[3]/div[3]/div[3]/section/div")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(text(),' Confirm your MyLotto email ')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(text(),'https://2.cat.mylotto.co.nz/activation')]")).click();
		Thread.sleep(10000);
	}
	
}
