package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Core.AccountsElements;
import Core.CommonElements;
import Core.LoginElements;
import Core.NotificationElement;

public class NotificationTestCase {

	WebDriver driver;
	public void Notification(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public CommonMethods objCommonMethods;
	public CommonElements objCommonElements;
	public LoginElements objLoginElements;
	public LoginTestCase objLoginTestCase;
	public NotificationElement objNotificationElement;
	public AccountsElements objAccountsElements;
	
	@BeforeClass
	public void Setup() {
		objCommonMethods = new CommonMethods();
		driver = objCommonMethods.getDriver();
		objCommonElements = new CommonElements(driver);
		objLoginElements = new LoginElements(driver);
		objLoginTestCase = new LoginTestCase();
		objAccountsElements = new AccountsElements(driver);
		objNotificationElement = new NotificationElement(driver);
		objCommonMethods = PageFactory.initElements(driver, CommonMethods.class);
		objCommonElements = PageFactory.initElements(driver, CommonElements.class);
		objLoginElements = PageFactory.initElements(driver, LoginElements.class);
		objLoginTestCase = PageFactory.initElements(driver, LoginTestCase.class);
		objNotificationElement = PageFactory.initElements(driver, NotificationElement.class);
		objAccountsElements = PageFactory.initElements(driver, AccountsElements.class);

	}
	
	@Test (priority = 16)
	public void Notifications() throws InterruptedException {
		
		Thread.sleep(2000);
		objLoginElements.Logoutmainmenu.click();
		Thread.sleep(2000);
		objAccountsElements.AccountsMainMenu.click();
		Thread.sleep(2000);
		objLoginElements.Logoutmainmenu.click();
		Thread.sleep(2000);
		objNotificationElement.Notification.click();
		
	}
}
