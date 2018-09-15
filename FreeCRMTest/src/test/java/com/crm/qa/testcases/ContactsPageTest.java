package com.crm.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;
	public String sheetname = "Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() throws InterruptedException {
		initialization();
		contactspage = new ContactsPage();
		loginpage = new LoginPage();
		homepage = new HomePage();
		testutil = new TestUtil();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactspage = homepage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		assertTrue(contactspage.verifyContactsLabel(), "Contacts label is missing on the page");
	}

	@Test(priority = 2)
	public void selectContactsTest() {
		contactspage.selectContactsByName("Amit Thakur");
	}

	@Test(priority = 3, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String Title, String firstName, String lastName, String companyName)
			throws InterruptedException {
		homepage.clickOnNewContactLink();
		contactspage.createNewContact(Title, firstName, lastName, companyName);
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data = TestUtil.getTestData(sheetname);
		return data;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
