package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {
	WebDriver driver;
	public InvoicePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getInvoiceedit() {
		return invoiceedit;
	}

	public WebElement getCreateinvoice() {
		return createinvoice;
	}

	public WebElement getSubedt() {
		return subedt;
	}

	public WebElement getSelectedt() {
		return selectedt;
	}

	public WebElement getSearchedit() {
		return searchedit;
	}

	public WebElement getSearchedt() {
		return searchedt;
	}
	@FindBy(linkText = "Invoice")
	private WebElement invoiceedit;
	
	@FindBy(xpath = "//img[@title='Create Invoice...']")
	private WebElement createinvoice;
	
	@FindBy(name = "subject")
	private WebElement subedt;
	
	@FindBy(xpath = "(//img[@title='Select'])[3 ]")
	private WebElement selectedt;
	
	@FindBy(id = "search_txt")
	private WebElement searchedit;
	
	@FindBy(name = "search")
	private WebElement searchedt;
	
	public WebElement getQuantityedt() {
		return quantityedt;
	}
	@FindBy(id = "qty1")
	private WebElement quantityedt;
	
	public WebElement getImgedit() {
		return imgedit;
	}
	@FindBy(name = "invoicedate")
	private WebElement dateedit;
	
	@FindBy(xpath ="//img[@id ='searchIcon1']")
	private WebElement imgedit;
	
	@FindBy(name = "ship_street")
	private WebElement billedit;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveedit;
	
	public WebElement getSaveedit() {
		return saveedit;
	}
	public WebElement getBilledit() {
		return billedit;
	}
	public WebElement getDateedit() {
		return dateedit;
	}
	public WebElement getDuedate() {
		return duedate;
	}
	@FindBy(name = "duedate")
	private WebElement duedate;
	
	

}
