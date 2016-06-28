
import java.io.BufferedReader;
		import java.io.DataOutputStream;
		import java.io.IOException;
		import java.io.InputStreamReader;
		import java.net.HttpURLConnection;
		import java.net.URL;
		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.sql.Statement;
		import java.util.List;

		import org.json.JSONException;
		import org.json.JSONObject;
		import org.openqa.selenium.By;
		import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.openqa.selenium.interactions.Actions;


public class FIRST_SECONT_PART {

			
			public static void main(String args[]) throws InterruptedException, SQLException, ClassNotFoundException, IOException, JSONException
			{
				
				WebDriver driver = new FirefoxDriver();
				
				driver.get("http://10.0.1.86/tatoc");
				driver.findElement(By.linkText("Advanced Course")).click();
				
				WebElement menu=driver.findElement(By.className("menutitle"));
				   
			    Actions actions = new Actions(driver);
			    
			    actions.moveToElement(menu).perform();
			    List<WebElement> array=driver.findElements(By.className("menuitem"));
			    array.get(3).click();
			    
			    String str1=driver.findElement(By.id("symboldisplay")).getText().toString();
			    
			   
			    Class.forName("com.mysql.jdbc.Driver");
			    Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.86/tatoc","tatocuser","tatoc01"); 	  

			    Statement query = con.createStatement();
			    String strname="SELECT id  FROM identity where Symbol="+"'"+str1+"'";
			    ResultSet set=query.executeQuery(strname);
		 	    set.first();
			   
			    String str=set.getString("id");
			    //System.out.print(set.getString("id"));
			    String strnameandpass="SELECT name,passkey  FROM credentials where id="+"'"+str+"'";
			   
			    set=query.executeQuery(strnameandpass);
			    set.first();
			  
			   
			    WebElement nametext=driver.findElement(By.id("name"));
			    WebElement passtext=driver.findElement(By.id("passkey"));
			    nametext.sendKeys(set.getString("name"));
			    passtext.sendKeys(set.getString("passkey"));
			    driver.findElement(By.id("submit")).click();;
			    set.close();
			  
			    
				
				
			}
			    
	
}
