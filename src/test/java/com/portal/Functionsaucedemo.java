package com.portal;

import static org.testng.Assert.expectThrows;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Functionsaucedemo {

	
	
WebDriver  driver;
	
	@BeforeClass
	void initialization() {
		
		System.out.println("initiating the driver");
		
        driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
		
	}
	
	

	@Test(dataProvider = "logindata")
	void login(String username , String password)
	{
	
	driver.get("https://www.saucedemo.com/v1/");
		driver.findElement(By.xpath("//input[@class = 'form_input' and @name= 'user-name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@class = 'form_input' and @name= 'password']")).sendKeys(password);
	
		driver.findElement(By.xpath("//input[@class = 'btn_action']")).click();
		
		
	}
	
	@DataProvider(name = "logindata")
	Object [] [] dprovider(){
		
	Object [] [] data =	{{"standard_user", "secret_sauce"},{"locked_out_user","secret_sauce"},{"problem_user","secret_sauce"},{"performance_glitch_user", "secret_sauce"}};
		
		
		return data;
		
		
	}
	

	
	

	@Test (priority = 2 , dependsOnMethods = {"login"})	
void aboutuscheck() throws InterruptedException {
		
	WebElement menu = driver.findElement(By.xpath("//button[text() = 'Open Menu']"));
		menu.click();
		
		driver.findElement(By.xpath("//*[@id=\"about_sidebar_link\"]")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//button[text() ='Close Menu' ]")).click();
		
		
		
		
	}

	
	@Test(priority = 3 , dependsOnMethods = {"login"})	
void addtocart() throws InterruptedException {
	
	driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class = 'inventory_details_back_button']")).click();
	driver.findElement(By.xpath("//div[@class = 'inventory_item_name' and text() = 'Test.allTheThings() T-Shirt (Red)']")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]")).click();
	
	
}
	@Test (priority = 4 , dependsOnMethods = {"addtocart"})
	
	void checkout() throws InterruptedException {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/a[1]/*[name()='svg'][1]/*[name()='path'][1]")).click();
		driver.findElement(By.xpath("//a[@class=\"btn_action checkout_button\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id = \"first-name\"]")).sendKeys("tasneem");
		driver.findElement(By.xpath("//input[@id = \"last-name\"]")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id =\"postal-code\"]")).sendKeys("1234");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value =\"CONTINUE\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class = \"btn_action cart_button\"]")).click();
	}
	
	@AfterClass
	@Test(priority = 4 , dependsOnMethods = {"login"})
	void logout() {
		
		driver.findElement(By.xpath("//button[text() = \"Open Menu\"]")).click();
		driver.findElement(By.xpath("//a[@id = \"logout_sidebar_link\"]")).click();
		driver.quit();
	}

}






















