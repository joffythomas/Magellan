package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Core.AccountsElements;
import Core.CommonElements;
import Core.LoginElements;
import Core.PaymentElements;

public class AccountsTestCase {
	
	public void AccountsElements (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver driver;
	public CommonElements objCommonElements;
	public CommonMethods objCommonMethods;
	public LoginElements objLoginPageElements;
	public AccountsElements objAccountsElements;
	
	@BeforeClass
	public void Setup() {
		objCommonElements = new CommonElements(driver);
		objCommonMethods = new CommonMethods();
		driver=objCommonMethods.getDriver();
		objLoginPageElements = new LoginElements(driver);
		objAccountsElements = new AccountsElements(driver);
		objCommonElements = PageFactory.initElements(driver, CommonElements.class);
		objCommonMethods = PageFactory.initElements(driver, CommonMethods.class);
		objAccountsElements = PageFactory.initElements(driver, AccountsElements.class);
		
	}
	
	@Test (priority = 6)
	public void Accounts() throws InterruptedException {
		
		objLoginPageElements.Logoutmainmenu.click();
		Thread.sleep(2000);
		objAccountsElements.AccountsMainMenu.click();
		Thread.sleep(2000);
	}
	
	@AfterClass 
	public void close() {
		driver.close();
	}
	

}
