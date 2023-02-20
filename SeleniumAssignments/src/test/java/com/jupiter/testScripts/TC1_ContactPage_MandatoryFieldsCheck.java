package com.jupiter.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jupiter.Base.Base;

public class TC1_ContactPage_MandatoryFieldsCheck extends Base 
{
	
	@Test
	public void testcase1() throws InterruptedException {
		WebElement contactlink= driver.findElement(By.linkText(pr.getProperty("ContactLink")));
		contactlink.click();
		Thread.sleep(4000);	
		
		WebElement Button = driver.findElement(By.xpath(pr.getProperty("SubmitButton")));
		Button.click();
		Thread.sleep(4000);	
		
		String actual_ErrorMessage= driver.findElement(By.xpath(pr.getProperty("actual_ErrorMessage"))).getText();
		Assert.assertTrue(actual_ErrorMessage.contains("Forename is required"));
		
		String actual_EmailError= driver.findElement(By.xpath(pr.getProperty("actual_EmailError"))).getText();
		Assert.assertTrue(actual_EmailError.contains("Email is required"));

		String actual_Message= driver.findElement(By.xpath(pr.getProperty("actual_Message"))).getText();
		Assert.assertTrue(actual_Message.contains("Message is required"));
		
		
		WebElement Forename_textfield = driver.findElement(By.id(pr.getProperty("Forename_textfield")));
		Forename_textfield.sendKeys("testuser1");
				
		WebElement Email_textfield = driver.findElement(By.id(pr.getProperty("Email_textfield")));
		Email_textfield.sendKeys("testuser1@gmail.com");
		
		WebElement Message_textfield = driver.findElement(By.id(pr.getProperty("Message_textfield")));
		Message_textfield.sendKeys("Hi, This is a test message.");
		Thread.sleep(4000);		
		
		String message= driver.findElement(By.xpath(pr.getProperty("message"))).getText();
		Assert.assertTrue(message.contains("We welcome your feedback - tell it how it is."));
		
		Thread.sleep(4000);	
	
	}

}
