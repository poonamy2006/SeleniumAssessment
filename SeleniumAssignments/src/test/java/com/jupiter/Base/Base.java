package com.jupiter.Base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public ChromeDriver driver;
	public Properties pr;
	
	@BeforeMethod
	public void init() throws IOException
	{
		
		File f = new File ("..///SeleniumProjects/Object.properties");
		FileReader fr= new FileReader(f);
		pr=new Properties();
		pr.load(fr);
		System.setProperty("webdriver.chrome.driver", "..//SeleniumProjects/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://jupiter.cloud.planittesting.com");
		driver.manage().window().maximize();
		
		
		
	}

	@AfterMethod
	public void Closebrowser() {
	driver.close();
	}
}
