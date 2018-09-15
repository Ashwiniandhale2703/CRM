package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;

	@FindBy(xpath = "//a/font[text()='Sign Up']")
	WebElement signInLink;

	@FindBy(xpath = "//img[@class='img-responsive' and @alt='free crm logo']")
	WebElement crmLogo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCrmLogo() {
		return crmLogo.isDisplayed();
	}

	public HomePage login(String un, String pswd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pswd);
		Thread.sleep(2000);
		loginButton.click();
		return new HomePage();
	}

}
