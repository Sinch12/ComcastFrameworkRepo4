package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
/**
 * @author Sinchana K S
 * contains loginpage elements and business lib like login()
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverrUtility;

public class LoginPage extends WebDriverrUtility {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(name ="user_name")
private WebElement usernameEdit;
 
@FindBy(name ="user_password")
 private WebElement passwordEdit;

@FindBy(id ="submitButton")
private WebElement loginbtn;

public WebElement getUsernameEdit() {
	return usernameEdit;
}

public WebElement getPasswordEdit() {
	return passwordEdit;
}

public WebElement getLoginbtn() {
	return loginbtn;
}
/**
 * login to application based on un,pwd,url arguements
 * @param url
 * @param username
 * @param password
 */
public void logintoapp(String url,String username,String password) {
	waitForPageToLoad(driver);
	driver.get(url);
	driver.manage().window().maximize();
	usernameEdit.sendKeys(username);
	passwordEdit.sendKeys(password);
	loginbtn.click();
}}







