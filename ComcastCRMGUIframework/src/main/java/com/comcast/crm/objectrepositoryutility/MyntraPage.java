package com.comcast.crm.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class MyntraPage {
	WebDriver driver;
	public MyntraPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//h3[@class=\"product-brand\"]")
	private List<WebElement>  kurtaedit;
	
	public List<WebElement> getKurtaedit() {
		return kurtaedit;
	}
	
	
	
	}
	
	


