package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(name = "lastname")
private WebElement contactedt;

@FindBy(id = "phone")
private WebElement phnedt;

@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
private WebElement saveedt;

@FindBy(xpath = "//input[@name = 'account_name']/following-sibling::img")
		private WebElement orgclick;
public WebElement getContactedt() {
	return contactedt;
}

public WebElement getPhnedt() {
	return phnedt;
}

public WebElement getSaveedt() {
	return saveedt;
}

public WebElement getOrgclick() {
	return orgclick;
}






}
