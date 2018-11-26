package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Core.CommonElements;
import Core.LoginElements;
import Core.PaymentElements;

public class PaymentTestCase {

	public WebDriver driver;
	public static CommonElements objCommonElements;
	public CommonMethods objCommonMethods;
	public static LoginElements objLoginElements;
	public LoginTestCase objLoginTestCase;
	public static PaymentElements objPaymentElements;
	
	public void PaymentElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@BeforeClass
	public void setup() throws IOException, InterruptedException {
		
		objCommonElements = new CommonElements(driver);
		objCommonMethods = new CommonMethods();
		driver=objCommonMethods.getDriver();
		objLoginElements = new LoginElements(driver);
		objLoginTestCase = new LoginTestCase();
		objPaymentElements = new PaymentElements(driver);
		objCommonMethods = PageFactory.initElements(driver, CommonMethods.class);
		objCommonElements = PageFactory.initElements(driver, CommonElements.class);
		objLoginElements = PageFactory.initElements(driver, LoginElements.class);
		objLoginTestCase = PageFactory.initElements(driver, LoginTestCase.class);
		objPaymentElements = PageFactory.initElements(driver, PaymentElements.class);
		objCommonMethods.openpropfile();
		
	}
	
	@Test(priority = 5)
	public void Payments() throws InterruptedException {
		
		System.out.println("Entered into payments");
		objLoginElements.Logoutmainmenu.click();
		Thread.sleep(4000);
		objPaymentElements.PaymentMenu.click();
		Thread.sleep(2000);
		
	}
}
