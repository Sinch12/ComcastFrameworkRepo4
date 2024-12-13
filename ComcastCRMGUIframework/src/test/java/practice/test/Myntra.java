package practice.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Myntra {

	public static void main(String[] args) {
WebDriver driver = new ChromeDriver();
driver.get("https://www.myntra.com/");
/*WebElement x = driver.findElement(By.xpath("//a[text()=\"Home & Living\"]"));
Actions a = new Actions(driver);
a.moveToElement(x).perform();
List<WebElement> allsugg = driver.findElements(By.xpath("//a[@data-reactid=\"577\" and text()='Home Décor']/ancestor::ul[@class=\"desktop-navBlock\"]/descendant::a[@class=\"desktop-categoryLink\"]"));
//List<WebElement> allsugg = driver.findElements(By.xpath("//a[text()=\"Home Décor\"]"));
int count = allsugg.size();
for (WebElement e : allsugg) {
	String text = e.getText();
	System.out.println(text);
	
}

	}

	}*/
//img[@draggable="false"]*/

WebElement x = driver.findElement(By.xpath("//a[text()=\"Men\"]"));
Actions a = new Actions(driver);
a.moveToElement(x).perform();
driver.findElement(By.xpath("//a[@data-reactid=\"41\" and text()='Jackets']")).sendKeys(Keys.ENTER);
		//a[@data-reactid="41" and text()='Jackets']
List<WebElement> allsugg = driver.findElements(By.xpath("//h4[@class=\"product-product\"]"));
for (WebElement e : allsugg) {
	String text = e.getText();
	//System.out.println(text);
	WebElement y = driver.findElement(By.xpath("//span[text()='Recommended']"));
	Actions a1 = new Actions(driver);
	a1.moveToElement(y).perform();
	 List<WebElement> ele = driver.findElements(By.xpath("//ul[@class=\"sort-list\"]/ancestor::div[@class=\"sort-sortBy\"]/descendant::li"));
	 for (WebElement e1 : ele) {
		String rec = e1.getText();
		if(rec.equalsIgnoreCase("Customer Rating"))
		{
			e1.click();
		}
		
	}
	
	//driver.findElement(By.xpath("//input[@type=\"radio\" and @value=\"Customer Rating\"]")).click();
	//a[@data-reactid="41" and text()='Jackets']
	
}


}}