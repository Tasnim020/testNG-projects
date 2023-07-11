package com.agiletech.portall;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v111.log.model.ViolationSetting.Name;

import com.google.common.graph.ElementOrder.Type;

public class Automationpractice {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		 driver.get("https://parabank.parasoft.com/");
		 driver.manage().window().maximize();
		 driver.findElement(By.name("username")).sendKeys("tasnim");
		 driver.findElement(By.name("password")).sendKeys("abcd123");
		 driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
		
		
		
		
		
	}
}
