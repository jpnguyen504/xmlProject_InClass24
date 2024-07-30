package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;
	
	@Test
	@Parameters({"username", "password", "dashboardValidationText", "addCustomerValidationText", "fullName", "companyVisibleText"})
	public void validUserShouldBeAbleToAddNewCustomer(String username, String password, String dashboardValidationText, String addCustomerValidationText, String fullName, String companyVisibleText ) {
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUsername(username);
		loginPage.insertPassword(password);
		loginPage.clickSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardValidationText);
		dashboardPage.clickCustomerMenu();
		dashboardPage.clickAddCustomerMenu();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddCustomerPage(addCustomerValidationText);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropDown(companyVisibleText);
		addCustomerPage.insertEmail();
		addCustomerPage.insertPhoneNum();
		addCustomerPage.clickSaveButton();
	}
}
