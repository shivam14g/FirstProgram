import java.io.IOException;

import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class third_part {

	public static void main(String[] args) throws IOException, JSONException, InterruptedException {

		
		
			WebDriver driver = new FirefoxDriver();
			driver.get("http://10.0.1.86/tatoc/advanced/video/player");
			JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("player.play()");
	        Thread.sleep(26000);
	        driver.findElement(By.linkText("Proceed")).click();

					
				
		
	}

}
