package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverrUtility {
public void waitForPageToLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
public void waitForElementPresent(WebDriver driver ,WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
	
}
public void switchToTabonURL(WebDriver driver,String partialURL) {
	Set<String> wh = driver.getWindowHandles();
	Iterator<String> it = wh.iterator();
	while(it.hasNext()){
		String wh1 = it.next();//capture the program
		driver.switchTo().window(wh1);
		String acturl = driver.getCurrentUrl();
		if(acturl.contains(partialURL)) {
			break;
		}


	}}
	

public void switchToTabonTitle(WebDriver driver,String partialTitle) {
	Set<String> wh = driver.getWindowHandles();
	Iterator<String> it = wh.iterator();
	while(it.hasNext()){
		String wh1 = it.next();//capture the program
		driver.switchTo().window(wh1);
		String acturl = driver.getTitle();
		if(acturl.contains(partialTitle)) {
			break;
		}}
}
public void SwitchToFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}
public void SwitchToFrame(WebDriver driver,String nameID) {
	driver.switchTo().frame(nameID);
}
public void SwitchToFrame(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
public void SwitchToAlertAndAccept(WebDriver driver) {
	driver.switchTo().alert().accept();
}
public void SwitchToAlertAndCancel(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
public void select(WebElement element,String text) {
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
}
public void select(WebElement element,int index) {
	Select sel = new Select(element);
	sel.selectByIndex(index);
}
public void mousemoveOnElement(WebDriver driver,WebElement element) {
	Actions a = new Actions(driver);
	a.moveToElement(element).perform();
}
public void doubleclick(WebDriver driver,WebElement element) {
	Actions a = new Actions(driver);
	a.doubleClick(element).perform();
}
//extra methods

public void selectByValue(WebElement element,String value) {
	Select sel = new Select(element);
	sel.selectByValue(value);
}

public void Deselect(WebElement element,String text) {
	Select sel = new Select(element);
	sel.deselectByVisibleText(text);
}
public void DeselectByIndex(WebElement element,int index) {
	Select sel = new Select(element);
	sel.deselectByIndex(index);
}
public void DeselectByValue(WebElement element,String value) {
	Select sel = new Select(element);
	sel.deselectByValue(value);
}
public void Rightclick(WebDriver driver,WebElement element) {
	Actions a = new Actions(driver);
	a.contextClick(element).perform();
	
}
public void SendkeysAction(WebDriver driver,WebElement element,CharSequence keys) {
	Actions a = new Actions(driver);
	a.sendKeys(element, keys).perform();
}
public void ScrolldownToElement(WebDriver driver,WebElement element) {
	Actions a = new Actions(driver);
	a.scrollToElement(element).perform();
}
public void ScrolldownByAmount(WebDriver driver,int x,int y ) {
	Actions a = new Actions(driver);
	a.scrollByAmount(x, y).perform();
}
public void WaitForElementTitle(WebDriver driver,String title) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.titleIs(title));
}
public void WaitForElementAlertIs(WebDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.alertIsPresent());	
}
public void WaitForElementToBeClickable(WebDriver driver,WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void waitForElementInvisibility(WebDriver driver ,WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.invisibilityOf(element));
}
}