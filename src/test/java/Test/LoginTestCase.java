package Test;

import java.io.IOException;
import java.util.Properties;

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
	public static LoginElements objLoginElements;
	public static CommonMethods objCommonMethods;
	public CommonElements objCommonElements;
	public static Properties prop;
	
	 public void LoginElements(WebDriver driver) {
		 LoginElements.driver = driver;
		 PageFactory.initElements(driver, this);
    }

	@BeforeClass
	public void setup() throws IOException, InterruptedException {
	
		objCommonMethods = new CommonMethods();
		driver=objCommonMethods.getDriver();
		objLoginElements = new LoginElements(driver);
		objLoginElements = PageFactory.initElements(driver, LoginElements.class);
		objCommonMethods = PageFactory.initElements(driver, CommonMethods.class);
		objCommonMethods.openpropfile();

	}
	
	@Test(priority = 2)
	public static void login() throws InterruptedException {
 		//objLoginElements.login("preethi@yopmail.com", "Augusta@12");
 		Core.LoginElements.login(objCommonMethods.prop.getProperty("emailid"),objCommonMethods.prop.getProperty("password")); 		
 		//objLoginElements.LoginButton.click();
		Thread.sleep(4000);

		if(objLoginElements.Logoutthere.isDisplayed()) {
			objLoginElements.Logoutthere.click();
			Thread.sleep(4000);
		}
		else if(objLoginElements.Logoutthere.isDisplayed()==false)  {
			driver.navigate();
		}
	}
	
//	@Test(priority = 3)
//	public void logout() throws InterruptedException {
//		System.out.println("******************");
// 		objLoginElements.Logoutmainmenu.click();
// 		Thread.sleep(4000);
// 		objLoginElements.Logoutbutton.click();
// 		Thread.sleep(4000);
// 		objLoginElements.LogoutConfirm.click();
//	}
	
	public WebDriver getDriver()
	{
		 
		return driver;
		
	}
	
//	@AfterClass
//	public void close() {
//		driver.close();
//	}
	
}
