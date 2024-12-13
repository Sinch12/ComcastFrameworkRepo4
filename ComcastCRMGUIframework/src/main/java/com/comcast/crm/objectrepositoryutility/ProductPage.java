package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Products")
	private WebElement productedit;
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createprod;
	
	@FindBy(name = "productname")
	private WebElement prodname;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveedit;
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement saveedt;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductedit() {
		return productedit;
	}

	public WebElement getCreateprod() {
		return createprod;
	}

	public WebElement getProdname() {
		return prodname;
	}

	public WebElement getSaveedit() {
		return saveedit;
	}

	public WebElement getSaveedt() {
		return saveedt;
	}
	
	
	

}
