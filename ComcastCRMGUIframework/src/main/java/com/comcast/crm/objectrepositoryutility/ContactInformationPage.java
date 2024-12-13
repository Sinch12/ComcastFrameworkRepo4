package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	WebDriver driver;
	public ContactInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(id = "dtlview_Last Name")
private WebElement lastnameedit;

@FindBy(id = "mouseArea_Organization Name")
private WebElement organizationname;

@FindBy(id = "dtlview_Support Start Date")
private WebElement startedit;

@FindBy(id = "dtlview_Support End Date")
private WebElement enddate;

public WebElement getStartedit() {
	return startedit;
}

public WebElement getEnddate() {
	return enddate;
}

public WebElement getOrganizationname() {
	return organizationname;
}

public WebElement getHeadermsg() {
	return headermsg;
}
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement headermsg;

public WebElement getLastnameedit() {
	return lastnameedit;
}

}
