package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactpage {
	WebDriver driver;
	public CreatingNewContactpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
 
@FindBy(name = "support_start_date")
private WebElement supportstartdate;
	
@FindBy(name = "support_end_date")
private WebElement supportenddate;

public WebElement getSupportstartdate() {
	return supportstartdate;
}

public WebElement getSupportenddate() {
	return supportenddate;
}

}
