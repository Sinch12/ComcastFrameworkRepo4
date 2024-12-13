package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Organizations")
	public WebElement orgpage;

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createorg;

	@FindBy(linkText = "Contacts")
	private WebElement contactlink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignlink;

	public WebElement getImgcontact() {
		return imgcontact;
	}
	@FindBy(linkText = "More")
	private WebElement morelink;

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement imgcontact;


	public WebElement getOrgpage() {
		return orgpage;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getCreateorg() {
		return createorg;
	}
	public WebElement getMorelink() {
		return morelink;
	}
	public void Createorg() {
		driver.manage().window().maximize();
		orgpage.click();
		createorg.click();

	}
	public void navigateToCampaignPage() {
		Actions a = new Actions(driver);
		a.moveToElement(morelink).perform();
		campaignlink.click();
	}



}