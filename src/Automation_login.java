import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class Automation_login {
	
	@Test
	public static void main (String[] args){
	
	String projectPath = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", projectPath +"/chromedriver");	
		
	//Open Browser
	
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");
	
	// Delay 
				try{
					Thread.sleep(2000);
					}
					catch(InterruptedException ie){
					}
					
	
	//Find Username Element and Enter the username
	driver.findElement(By.id("user-name")).sendKeys("standard_user");

	//Find Password Element and enter the password
	
	driver.findElementById("password").sendKeys("secret_sauce");
	
	try{
		Thread.sleep(1000);
		}
		catch(InterruptedException ie){
		}
	
	//Login

	driver.findElementById("login-button").click();
	
	// Delay 
				try{
					Thread.sleep(2000);
					}
					catch(InterruptedException ie){
					}
					
	
	String at=driver.getCurrentUrl();
	String et= "https://www.saucedemo.com/inventory.html";
	
	if (at.equalsIgnoreCase(et))
	{
		System.out.println(" Test case1: Login Sucesfull using Standeard user");
	}
	
	else {
		System.out.println("Login Failed");
	}
	
	driver.findElementByClassName("btn_primary").click();
		
    
	//to add the second product	
	//driver.findElementByClassName("btn_primary").click();
	
	//Navigate to the cart
	
	driver.findElementById("shopping_cart_container").click();
		
	//driver.navigate().to("https://www.saucedemo.com/cart.html");
	
	// Delay 
				try{
					Thread.sleep(2000);
					}
					catch(InterruptedException ie){
					}

					

	driver.findElement(By.className("checkout_button")).click();
	
	// Delay 
				try{
					Thread.sleep(2000);
					}
					catch(InterruptedException ie){
					}
	
	
	//Enter checkout information
	
	driver.findElement(By.id("first-name")).sendKeys("Aditya");
	
	driver.findElement(By.id("last-name")).sendKeys("Panwar");
	
	driver.findElement(By.id("postal-code")).sendKeys("12616");
	
	try{
		Thread.sleep(1000);
		}
		catch(InterruptedException ie){
		}
	//Continue to checkout
	driver.findElement(By.xpath("//input[@value='CONTINUE' and @type='submit']")).click();
	
	// Delay 
			try{
				Thread.sleep(2000);
				}
				catch(InterruptedException ie){
				}

				
	// Final confirmation for order			
	driver.findElement(By.className("cart_button")).click();

	driver.close();
	}	

	
}


