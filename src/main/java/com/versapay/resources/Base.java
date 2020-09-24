package com.versapay.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initialize_driver() {			// method to initialize driver
		prop= new Properties ();
		try {
			FileInputStream	fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\versapay\\resources\\config.properties");
			prop.load(fis);
		} 
		catch (FileNotFoundException e) {
			System.out.println("config.properties file not found");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		String browserName= System.getProperty("brower");
		if (browserName.contentEquals("chrome")) {
			WebDriverManager.chromedriver().setup();
		}
		else if (browserName.contentEquals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		}
		else if (browserName.contentEquals("ie")) {
			WebDriverManager.iedriver().setup();
		}
		else {
			System.out.println("check config.properties and name a browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}


}
