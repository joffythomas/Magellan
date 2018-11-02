package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Core.LoginElements;
import Core.UserManagementElements;

public class UserManagementTestCase {

	public WebDriver driver;
	LoginElements objLoginElements;
	LoginTestCase objLoginTestCase;
	CommonMethods objCommonMethods;
	UserManagementElements objUserManagementElements;
	
	@BeforeClass
	public void setup() throws IOException, InterruptedException {
		objLoginElements = new LoginElements(driver);
		objCommonMethods = new CommonMethods();
		objLoginTestCase = new LoginTestCase();
		objUserManagementElements = new UserManagementElements();
		objLoginElements = PageFactory.initElements(driver, LoginElements.class);
		objLoginTestCase = PageFactory.initElements(driver, LoginTestCase.class);
		objCommonMethods = PageFactory.initElements(driver, CommonMethods.class);
		objUserManagementElements = PageFactory.initElements(driver, UserManagementElements.class);
		objCommonMethods.openbrowser();
		objLoginTestCase.login();
		
	}
	
	@Test(priority = 3)
	public void UserManagement() {
		objUserManagementElements.usermanagementmenu.click();
		
	}
}
