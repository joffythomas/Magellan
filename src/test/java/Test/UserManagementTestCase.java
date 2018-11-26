package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Core.CommonElements;
import Core.LoginElements;
import Core.UserManagementElements;

public class UserManagementTestCase {

	public static WebDriver driver;
	public static CommonElements objCommonElements;
	public CommonMethods objCommonMethods;
	public static LoginElements objLoginElements;
	public LoginTestCase objLoginTestCase;
	public static UserManagementElements objUserManagementElements;
	
	 public void UserManagementElements(WebDriver driver) {
		 UserManagementElements.driver = driver;
		 PageFactory.initElements(driver, this);
    }
	
	@BeforeClass
	public void setup() throws IOException, InterruptedException {
		
		objCommonElements = new CommonElements(driver);
		objCommonMethods = new CommonMethods();
		driver=objCommonMethods.getDriver();
		objLoginElements = new LoginElements(driver);
		objLoginTestCase = new LoginTestCase();
		objUserManagementElements = new UserManagementElements(driver);
		objCommonMethods = PageFactory.initElements(driver, CommonMethods.class);
		objCommonElements = PageFactory.initElements(driver, CommonElements.class);
		objLoginElements = PageFactory.initElements(driver, LoginElements.class);
		objLoginTestCase = PageFactory.initElements(driver, LoginTestCase.class);
		objUserManagementElements = PageFactory.initElements(driver, UserManagementElements.class);

		objCommonMethods.openpropfile();
		
	}
	
	
	@Test(priority = 4)
	public void UserManagement() throws InterruptedException, IOException {
		System.out.println("Entered into usernamagement");
		objLoginElements.Logoutmainmenu.click();
		Thread.sleep(4000);
		objUserManagementElements.usermanagementmenu.click();
		
	}
	
//	@AfterClass
//	public void closeapp() {
//		driver.close();
//	}
	
	public WebDriver getDriver()
	{
		 
		return driver;
		
	}
}
