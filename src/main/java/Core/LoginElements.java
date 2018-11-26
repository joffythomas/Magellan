package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginElements {

	public static WebDriver driver;
	 
	 public LoginElements(WebDriver driver) {
		 LoginElements.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	
	 @FindBy(how=How.XPATH,using=".//*[@class='row signin-bg']//*[@placeholder='Enter your email']")
	 public static WebElement emailid;
	 
	 @FindBy(how=How.XPATH,using=".//*[@class=\"form-group mar-bot-35 releative\"]//*[@id=\"pwd\"]")
	 public static WebElement pwd;
	 
	 @FindBy(how=How.XPATH,using=".//*[@class=\"form-group mar-bot-35 next-button\"]//*[@ng-click=\"login()\"]")
	 public static WebElement LoginButton;
	 
	 @FindBy(how=How.XPATH,using=".//*[@class=\"button mar-bot-10 center\"]//*[@ng-click=\"logOutThere()\"]")
	 public static WebElement Logoutthere;
	 
	 @FindBy(how=How.XPATH, using=".//*[@class='dropdown-toggle']")
	 public static WebElement Logoutmainmenu;
	 
	 @FindBy(how=How.XPATH,using=".//*[@class='dropdown-menu']//li[7]//a")
	 public static WebElement Logoutbutton;
	 
	 @FindBy(how=How.XPATH,using=".//*[@class='row forgot-password bor0 box-shadow-none']//*[@translate-attr-aria-label=\"Common_Ok\"]")
	 public static WebElement LogoutConfirm;
	 
	
	 public static void login(String eemailid, String ppassword) throws InterruptedException {
		Thread.sleep(5000);
		 emailid.sendKeys(eemailid);
		 pwd.sendKeys(ppassword);
		 LoginButton.click();
		 Thread.sleep(4000);
	 }
	 
	 public WebDriver getDriver()
		{
			 
			return driver;
			
		}
	
}
