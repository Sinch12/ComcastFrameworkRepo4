package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationsPage {
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(name = "accountname")
private WebElement createorg1;

@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
private WebElement saveorg;

@FindBy(name = "industry")
private WebElement industryDD;

@FindBy(name ="search_text")
private WebElement searchEdt;

@FindBy(name = "search_field")
private WebElement searchDd;

@FindBy(xpath = "//input[@name = 'account_name']/following-sibling::img")
private WebElement searchclick;

//@FindBy(xpath = "//a[text()='"+orgname+"']")
//private WebElement orgname;
//a[text()='"+orgname+"']
@FindBy(name = "search")
private WebElement searchfield;

public WebElement getSearchfield() {
	return searchfield;
}

//public WebElement getOrgname() {
	//return orgname;
//}

public WebElement getSearchclick() {
	return searchclick;
}


public WebElement getSearchbtn() {
	return searchbtn;
}
@FindBy(name = "submit")
private WebElement searchbtn;

@FindBy(name = "accounttype")
private WebElement acctype;

@FindBy(id = "phone")
private WebElement phnedt;

public WebElement getSearchtext() {
	return searchtext;
}
@FindBy(id = "search_txt")
private WebElement searchtext;

@FindBy(name = "accountname")
private WebElement orgname;

public WebElement getOrgname() {
	return orgname;
}

public WebElement getPhnedt() {
	return phnedt;
}

public WebElement getAcctype() {
	return acctype;
}

public WebElement getSearchEdt() {
	return searchEdt;
}

public WebElement getSearchDd() {
	return searchDd;
}

public WebElement getCreateorg1() {
	return createorg1;
}
 
public WebElement getSaveorg() {
	return saveorg;
}
public void createOrg1(String orgname) {
	createorg1.sendKeys(orgname);
	saveorg.click();
}
//createorg with industryvalue
public void createOrg1(String orgname,String industry) {
	createorg1.sendKeys(orgname);
	Select s = new Select(industryDD);
	s.selectByVisibleText(industry);
	saveorg.click();
}
public void createOrg1(String orgname,String industry,String type) {
	createorg1.sendKeys(orgname);
	Select s = new Select(industryDD);
	s.selectByVisibleText(industry);
	Select s1 = new Select(acctype);
	s1.selectByVisibleText(type);
	saveorg.click();
}
	public void createOrg2(String orgname,String phonenum) {
		createorg1.sendKeys(orgname);
		phnedt.sendKeys(phonenum);
		saveorg.click();

}
	}
