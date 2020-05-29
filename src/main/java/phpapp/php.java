package phpapp;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class php {
	ChromeDriver driver;
	  @BeforeMethod
	  public void launch() {
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("http://192.168.56.103:3001");
		  
	  }
	  
	  @Test
	  public void verify() {
		  driver.findElement(By.xpath("//a[@href='/content/about-us.php']")).click();
		  String x = driver.getCurrentUrl();
		  System.out.println(x);  
		  driver.navigate().back();
		  driver.findElement(By.xpath("//a[@href='/content/products.php']")).click();
		  String y = driver.getCurrentUrl();
		  System.out.println(y);		  
		  driver.navigate().back();
		  driver.findElement(By.xpath("//a[@href='/content/contact.php']")).click();
		  String z = driver.getCurrentUrl();
		  System.out.println(z);
		  driver.navigate().back();
	  }
	  
	  @AfterMethod
	  public void close() {
		  driver.quit();
		  
	  }

	  public static void main(String[] args) {
			System.out.println("Main Function");
			php abc = new php();
			abc.launch();
			abc.verify();
			abc.close();
	  }

}
