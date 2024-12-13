package practice.test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.webdriverutility.WebDriverrUtility;

public class CartButton {

	public static void main(String[] args) {
WebDriver driver = new ChromeDriver();
WebDriverrUtility w = new WebDriverrUtility();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get("https://www.myntra.com/");
WebElement x = driver.findElement(By.xpath("//a[text()=\"Home & Living\"]"));
Actions a = new Actions(driver);
a.moveToElement(x).perform();
driver.findElement(By.xpath("//a[text()='Plants & Planters']")).click();
//List<WebElement> allsugg = driver.findElements(By.xpath("//h3[text()='HomeShastra']"));

driver.findElement(By.xpath("//h4[text()='2 Pcs Planters With Stand' and @class=\"product-product\"]")).click();
for (int i = 0; i < 10; i++) {
	
	w.switchToTabonTitle(driver, "Buy HomeShastra Allura Gold");

	driver.findElement(By.xpath("//div[text()=\"ADD TO BAG\"]")).click();
	w.switchToTabonTitle(driver, "Home Furnishings");
	driver.findElement(By.xpath("//h4[text()='2 Pcs Planters With Stand' and @class=\"product-product\"]")).click();
	
}


//driver.findElement(By.xpath("//h4[text()='2 Pcs Planters With Stand' and @class=\"product-product\"]")).click();

//WebDriverrUtility w = new WebDriverrUtility();

//w.switchToTabonTitle(driver, "Buy HomeShastra Allura Gold");

//driver.findElement(By.xpath("//div[text()=\"ADD TO BAG\"]")).click();

	}

}
