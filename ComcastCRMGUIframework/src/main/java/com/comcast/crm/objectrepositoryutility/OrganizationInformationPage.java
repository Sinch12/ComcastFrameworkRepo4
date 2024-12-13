package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
public WebElement getHeadermsg() {
		return headermsg;
	}

	public WebElement getActorgname() {
		return actorgname;
	}
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement headermsg; 

@FindBy(id = "dtlview_Organization Name")
private WebElement actorgname;

@FindBy(id="dtlview_Industry")
private WebElement actindname;

@FindBy(id="dtlview_Type")
private WebElement acttype;

@FindBy(id = "dtlview_Phone")
private WebElement actphnnum;

 
public WebElement getActphnnum() {
	return actphnnum;
}
public WebElement getActindname() {
	return actindname;
}
public WebElement getActtype() {
	return acttype;
}

//public void headerinfo(String text) {
	//headermsg.getText();
	//actorgname.getText();
	
	
}

