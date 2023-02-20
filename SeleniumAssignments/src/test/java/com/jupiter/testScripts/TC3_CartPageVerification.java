package com.jupiter.testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jupiter.Base.Base;

public class TC3_CartPageVerification extends Base 
{
	
	@Test
public void testcase3() throws InterruptedException {
	
	WebElement Shoplink= driver.findElement(By.linkText(pr.getProperty("ShopLink")));
	Shoplink.click();
	Thread.sleep(10000);	
	
	List<WebElement> ProductItems_Buy = driver.findElements(By.xpath(pr.getProperty("ProductButtonItems")));
	List<WebElement> ProductItems_Price = driver.findElements(By.xpath(pr.getProperty("ProductItems_Price"))); 
	ProductItems_Buy.get(1).click();
	ProductItems_Buy.get(1).click();
	
	
	String StuffedFrog_ProductPrice=ProductItems_Price.get(1).getText();
    List<WebElement> ProductName= driver.findElements(By.xpath(pr.getProperty("ProductName")));
	String StuffedFrog_ProductName = ProductName.get(1).getText();
			
	for(int i=0;i<=4;i++) {
	ProductItems_Buy.get(3).click();
	}
	
	for(int i=0;i<=2;i=i+1) {
	ProductItems_Buy.get(6).click();
	}
	
	String FluffyBunny_ProductPrice=ProductItems_Price.get(3).getText();
	String FluffyBunny_ProductName = ProductName.get(3).getText();
	
	String ValentinieBear_ProductPrice=ProductItems_Price.get(6).getText();
	String ValentinieBear_ProductName = ProductName.get(6).getText();

					
	WebElement cartlink = driver.findElement(By.xpath(pr.getProperty("CartLink")));
	cartlink.click();
		
	Thread.sleep(5000);
			
	WebElement Name_Product1= driver.findElement(By.xpath(pr.getProperty("ProductItems")));
	String Cart_Product1 = Name_Product1.getText();
	
	WebElement Price_Product1 = driver.findElement(By.xpath(pr.getProperty("ProductPrice")));
	String Cart_Product1Price = Price_Product1.getText();

	WebElement subtotal = driver.findElement(By.xpath(pr.getProperty("product1_SubTotal")));
	String SubTotal_Product1= subtotal.getText();
	
	String ExpectedSubTotal_Product1= "$21.98";
		
	Assert.assertEquals(Cart_Product1, StuffedFrog_ProductName);
	Assert.assertEquals(Cart_Product1Price, StuffedFrog_ProductPrice);
	Assert.assertEquals(SubTotal_Product1, ExpectedSubTotal_Product1);

	WebElement Name_Product2= driver.findElement(By.xpath(pr.getProperty("CartProduct2")));
	String Actual_Product2 = Name_Product2.getText();
	WebElement Price_Product2 = driver.findElement(By.xpath(pr.getProperty("CartProduct2Price")));
	String Product2Price = Price_Product2.getText();
	WebElement subtotal_Product2 = driver.findElement(By.xpath(pr.getProperty("SubTotalProduct2")));
	String ActualSubTotal_Product2= subtotal_Product2.getText();
	String ExpectedSubTotal_Product2= "$49.95";
	
	
	Assert.assertEquals(Actual_Product2, FluffyBunny_ProductName);
	Assert.assertEquals(Product2Price, FluffyBunny_ProductPrice);
	Assert.assertEquals(ActualSubTotal_Product2, ExpectedSubTotal_Product2);

	
	WebElement Name_Product3= driver.findElement(By.xpath(pr.getProperty("CartProduct3")));
	String Actual_Product3 = Name_Product3.getText();
	WebElement Price_Product3 = driver.findElement(By.xpath(pr.getProperty("CartProduct3Price")));
	String ActualCart_Product3Price = Price_Product3.getText();
	WebElement subtotal_Product3 = driver.findElement(By.xpath(pr.getProperty("SubTotalProduct3")));
	String ActualSubTotal_Product3= subtotal_Product3.getText();
	String Expected_subtotal_Product3="$44.97";
	
	
	Assert.assertEquals(Actual_Product3, ValentinieBear_ProductName);
	Assert.assertEquals(ActualCart_Product3Price, ValentinieBear_ProductPrice);
	Assert.assertEquals(ActualSubTotal_Product3, Expected_subtotal_Product3);

	WebElement ProductTotal= driver.findElement(By.xpath(pr.getProperty("ProductTotal")));
	String Actual_productTotal = ProductTotal.getText();
		
	
	double Expected_Total = 21.98 + 49.95 + 44.97;
	String Expected_t= "Total: " + Double.toString(Expected_Total);
	Assert.assertEquals(Actual_productTotal, Expected_t);
	Thread.sleep(5000);	
	}
	
}
	
	

