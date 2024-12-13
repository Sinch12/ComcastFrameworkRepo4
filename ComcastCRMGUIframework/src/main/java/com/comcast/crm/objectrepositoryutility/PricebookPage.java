package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricebookPage {
	WebDriver driver;
	public PricebookPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(linkText = "More")
private WebElement moreedt;

@FindBy(linkText = "Price Books")
private WebElement pricebook;

@FindBy(xpath = "//img[@title='Create Price Book...']")
private WebElement createPricebook;

@FindBy(name = "bookname")
private WebElement bookedt;

@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
private WebElement saveedt;

@FindBy(id = "dtlview_Price Book Name")
private WebElement verifypr;

public WebElement getMoreedt() {
	return moreedt;
}

public WebElement getPricebook() {
	return pricebook;
}

public WebElement getCreatePricebook() {
	return createPricebook;
}

public WebElement getBookedt() {
	return bookedt;
}

public WebElement getSaveedt() {
	return saveedt;
}

public WebElement getVerifypr() {
	return verifypr;
}


}
