package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Opportunitypage {
	WebDriver driver;
	public Opportunitypage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Opportunities")
	private WebElement opportunityedt;
	
	@FindBy(xpath = "//img[@alt='Create Opportunity...']")
	private WebElement createopr;
	
	@FindBy(name = "potentialname")
	private WebElement nameedit;
	
	@FindBy(xpath = "//input[@id='related_to']/following-sibling::img")
	private WebElement orgbtn;
	
	@FindBy(name ="search_text")
	private WebElement searchedt;
	
	//@FindBy(xpath ="//input[@name="search_text"]")
	//input[@name="search_text"]
	//private WebElement searchedt;
	
	@FindBy(name = "search")
	private WebElement searchedit;
	
	//@FindBy(linkText = "orgname")
	//private WebElement orgname;
	@FindBy(xpath = "//a[text()='\"+orgname+\"']")
	private WebElement orgname;
	
	@FindBy(xpath = "(//input[@type='radio'])[2]")
	private WebElement radiobtn;
	
	@FindBy(xpath = "//select[@name='assigned_group_id']")
	private WebElement selectedt;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveedit;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveorg;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerinfo;

	public WebElement getHeaderinfo() {
		return headerinfo;
	}

	public WebElement getSaveorg() {
		return saveorg;
	}

	public WebElement getOpportunityedt() {
		return opportunityedt;
	}

	public WebElement getCreateopr() {
		return createopr;
	}

	public WebElement getNameedit() {
		return nameedit;
	}

	public WebElement getOrgbtn() {
		return orgbtn;
	}

	public WebElement getSearchedt() {
		return searchedt;
	}

	public WebElement getSearchedit() {
		return searchedit;
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getRadiobtn() {
		return radiobtn;
	}

	public WebElement getSelectedt() {
		return selectedt;
	}

	public WebElement getSaveedit() {
		return saveedit;
	}
public void select(String text) {
	Select s = new Select(selectedt);
	s.selectByVisibleText(text);
}
}
