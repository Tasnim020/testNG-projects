package com.testng;
import org.testng.annotations.Test;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class FunctionalSaucedemo {
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"Browser","url"})
	void initialization(String browser , String url) {
		
		System.out.println("initiating the driver");
		if (browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));	
			driver.get("https://www.saucedemo.com/v1/");
		
		} else {
            driver = new EdgeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));	
			driver.get("https://www.saucedemo.com/v1/");

		}
       
		
		
	}
	
	@AfterClass
	void logout() {
		
		driver.quit();
	}
	
	
	@BeforeMethod
	@Test(enabled = false)
	void login() throws InterruptedException {

	
	driver.get("https://www.saucedemo.com/v1/");
		driver.findElement(By.xpath("//input[@class = 'form_input' and @name= 'user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@class = 'form_input' and @name= 'password']")).sendKeys("secret_sauce");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class = 'btn_action']")).click();
		
		
		
	}
	

	
	

	@Test(enabled = false)	
void aboutuscheck() throws InterruptedException {
		
	WebElement menu = driver.findElement(By.xpath("//button[text() = 'Open Menu']"));
		menu.click();
		
		driver.findElement(By.xpath("//*[@id=\"about_sidebar_link\"]")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//button[text() ='Close Menu' ]")).click();
		
		
		
		
	}

	
	@Test(enabled = false)
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
	@Test(enabled = false)
	
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

	
	
	

}
