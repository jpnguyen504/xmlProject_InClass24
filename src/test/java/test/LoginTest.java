package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;
	
	String username;
	String password;
	String dashboardValidationText;
	
	@Test
	@Parameters({"username", "password", "dashboardValidationText"})
	public void validUserShouldBeAbleToLogin(String username, String password, String dashboardValidationText) {
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUsername(username);
		loginPage.insertPassword(password);
		loginPage.clickSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardValidationText);
		
//		BrowserFactory.tearDown();
	}
}
