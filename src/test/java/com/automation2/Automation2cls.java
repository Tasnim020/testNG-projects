package com.automation2;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation2cls {

	public static void main(String[] args) throws InterruptedException {
		
WebDriver driver = new ChromeDriver();
driver.get("https://agileteach.com/");
driver.findElement(By.className("myPortal")).click();

driver.findElement(By.name("email")).sendKeys("tasnim.tabassum020@gmail.com");
driver.findElement(By.name("password")).sendKeys("Tasnim1234++");
driver.findElement(By.className("login-btn")).click();



Thread.sleep(5000);

driver.findElement(By.className("force-logout")).click();

Thread.sleep(5000);

driver.findElement(By.className("close")).click();
		
driver.findElement(By.className("myCourse")).click();


	

Thread.sleep(3000);



WebElement parentCourses = driver.findElement(By.xpath("//*[@id=\"myCourses\"]"));

List<WebElement> childDIV = parentCourses.findElements(By.className("single"));

int numberOfDiv = childDIV.size();

	

System.out.println(numberOfDiv);









	}
}


  
		
		
		
		
		
		
		
		
		
	


