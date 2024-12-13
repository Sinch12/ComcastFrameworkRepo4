package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
public WebElement signout;

@FindBy(linkText = "Sign Out")
private WebElement signoutbtn;

public WebElement getSignout() {
	return signout;
}

public WebElement getSignoutbtn() {
	return signoutbtn;
}
public void getLogout() {
	Actions a = new Actions(driver);
	a.moveToElement(signout).perform();
	getSignoutbtn().click();
}

}
