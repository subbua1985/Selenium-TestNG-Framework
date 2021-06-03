package com.mylotto.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.mylotto.qa.util.TestUtil;
import com.mylotto.qa.util.WebEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestBase {

	//global variable which means we can use in all child classes like LoginPage, Lotto, Keno etc.,
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase() throws IOException{
	//Properties and FileInput Stream available in java
	
	    prop = new Properties();
		
		FileInputStream ip = new FileInputStream("/Users/sayyanar/eclipse-workspace/MyLotto/src/main/java/com/mylotto/qa/config/config.properties");	
		prop.load(ip);

	}

	
	public static void initialization() throws IOException {
		
		String browserName = prop.getProperty("browser");
			
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:/Users/sayyanar/eclipse-workspace/Selenium/chromedriver_win32/chromedriver.exe");
		    driver = new ChromeDriver(); //global variable initialized here, we don't need to use WebDriver keyword again

		}
		else if (browserName.equals("firefox")) {
			System.out.println("Sorry Not available yet");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
	    driver.manage().window().maximize();  //maximize window
	    driver.manage().deleteAllCookies();   // delete all cookies
	    
		//dynamic wait which means it wont wait for 20 or 10 seconds all the time, if all the elements are available then it will continue
	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);	    
	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    driver.get(prop.getProperty("url"));
	    

	}
	
	
	
	
	
}