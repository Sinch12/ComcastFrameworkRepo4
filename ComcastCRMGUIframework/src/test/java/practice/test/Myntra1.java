package practice.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverrUtility;
import com.comcast.crm.objectrepositoryutility.MyntraPage;

public class Myntra1 {

	public static void main(String[] args) throws Throwable {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");	
		//JavascriptExecutor driver;
		//JavascriptExecutor j = (JavascriptExecutor)driver;
		//j.executeScript(null, args)
WebDriver driver = new ChromeDriver(option);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
driver.get("https://www.myntra.com/");
WebElement wh = driver.findElement(By.xpath("//div[@data-reactid=\"179\"]"));
Actions a = new Actions(driver);
a.moveToElement(wh).perform();
driver.findElement(By.xpath("//a[@data-reactid=\"196\"]")).click();

WebElement wh1 = driver.findElement(By.xpath("//input[@value=\"Kurta Sets\"]"));


//WebElement wh1 = driver.findElement(By.xpath("//span[text()=\"Categories\"]"));

Actions a1 = new Actions(driver);
a1.moveToElement(wh1).click().perform();

 List<WebElement> allprod = driver.findElements(By.xpath("//h3[@class=\"product-brand\"]"));
//MyntraPage m = new MyntraPage(driver);
  //m.getKurtaedit();
 int count = allprod.size();
 System.out.println(count);
//System.out.println(text);
for (WebElement e : allprod) {
	String prod = e.getText();
	System.out.println(prod);
	Thread.sleep(2000);
	
}
/*List<WebElement> price = driver.findElements(By.xpath("//div[@class=\"product-price\"]"));
for (WebElement we : price) {
	String allprice = we.getText();
	System.out.println(price);
	
}*/
 
	}}


