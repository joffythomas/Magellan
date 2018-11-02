package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Core.CommonElements;
import Core.LoginElements;

public class LoginTestCase {

	static WebDriver driver;
	public LoginElements objLoginElements;
	public CommonMethods objCommonMethods;
	public CommonElements objCommonElements;
	

	@BeforeClass
	public void setup() throws IOException {
	
		objCommonMethods = new CommonMethods();
		driver=objCommonMethods.getDriver();
		objLoginElements = new LoginElements(driver);
		objLoginElements = PageFactory.initElements(driver, LoginElements.class);
		objCommonMethods = PageFactory.initElements(driver, CommonMethods.class);
		objCommonMethods.openpropfile();

	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
 		objLoginElements.login("preethi@yopmail.com", "Augusta@12");
		objLoginElements.LoginButton.click();
		Thread.sleep(4000);
		
		if(objLoginElements.Logoutthere.isDisplayed()) {
			objLoginElements.Logoutthere.click();
		}
		else {
			driver.navigate();
		}
	}
	
	@Test(priority = 2)
	public void logout() throws InterruptedException {
		System.out.println("******************");
 		objLoginElements.Logoutmainmenu.click();
 		objLoginElements.Logoutbutton.click();
 		objLoginElements.LogoutConfirm.click();
	}
	
	@AfterClass
	public void close() {
		driver.close();
	}
	
}
