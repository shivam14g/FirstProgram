

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


 
public class fifth_part {
	
	
	public static void main(String args[]) throws InterruptedException, FileNotFoundException
	{

		
		System.setProperty("webdriver.chrome.driver","/home/shivamtiwari1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://10.0.1.86/tatoc/advanced/file/handle");
        driver.findElement(By.linkText("Download File")).click();
		
        Thread.sleep(5000);
        Scanner data = new Scanner(new File("/home/shivamtiwari1/Downloads/file_handle_test.dat"));     
    	ArrayList<String> dictionary=new ArrayList<String>();
    	
    	while(data.hasNext())
    	{
    		dictionary.add(data.next());
    	}
    	
        System.out.println(dictionary.get(6));
       		
		driver.findElement(By.id("signature")).sendKeys(dictionary.get(6));

		driver.findElement(By.className("submit")).click();	
		
	}
	    
	    
	}
	


