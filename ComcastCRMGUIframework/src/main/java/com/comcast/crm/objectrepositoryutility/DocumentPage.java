package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentPage {
	WebDriver driver;
	public DocumentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
public WebElement getDocedit() {
		return docedit;
	}

	public WebElement getCreatedoc() {
		return createdoc;
	}

	public WebElement getTitledit() {
		return titledit;
	}

	public WebElement getSavedit() {
		return savedit;
	}

	public WebElement getHeadermsg() {
		return headermsg;
	}
@FindBy(linkText = "Documents")
private WebElement docedit;

@FindBy(xpath = "//img[@alt='Create Document...']")
private WebElement createdoc;

@FindBy(name = "notes_title")
private WebElement titledit;

@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
private WebElement savedit;

@FindBy(id = "dtlview_Title")
private WebElement headermsg;

}

