package com.jupiter.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jupiter.Base.Base;


@Test
public class TC2_ContactPage_SuccessMessage extends Base 
{
	public void testcase2() throws InterruptedException {
	WebElement contactlink = driver.findElement(By.linkText(pr.getProperty("ContactLink")));
	contactlink.click();
	Thread.sleep(6000);	
		
	WebElement Forename_textfield = driver.findElement(By.id(pr.getProperty("Forename_textfield")));
	Forename_textfield.sendKeys("testcontact");
	
	WebElement Email_textfield = driver.findElement(By.id(pr.getProperty("Email_textfield")));
	Email_textfield.sendKeys("testcontact@gmail.com");
	
	WebElement Message_textfield = driver.findElement(By.id(pr.getProperty("Message_textfield")));
	Message_textfield.sendKeys("Hi, Welcome,  This is a test message.");
			
	
	WebElement Button = driver.findElement(By.xpath(pr.getProperty("SubmitButton")));
	Button.click();
	
	Thread.sleep(15000);		

	 WebElement message= driver.findElement(By.xpath(pr.getProperty("SuccessMessage")));
	String TextMessage = message.getText();
	Assert.assertTrue(TextMessage.contains("we appreciate your feedback."));
	Thread.sleep(5000);
	}	

}
