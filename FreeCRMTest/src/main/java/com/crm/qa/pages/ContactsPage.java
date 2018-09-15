package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(name = "client_lookup")
	WebElement companyName;

	@FindBy(xpath = "//input[@value='Save' and @type='submit']")
	WebElement saveButton;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='" + name
				+ "']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']/input"));
	}

	public void createNewContact(String T, String FN, String LN, String CN) throws InterruptedException {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(T);
		firstName.sendKeys(FN);
		lastName.sendKeys(LN);
		companyName.sendKeys(CN);
		saveButton.click();
		Thread.sleep(5000);

	}

}
