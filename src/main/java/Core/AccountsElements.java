package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountsElements {

	public static WebDriver driver;
	
	public AccountsElements (WebDriver driver) {
		AccountsElements.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.XPATH, using = ".//*[@class='dropdown-menu']//li[3]//*[contains(text(),'Accounts')]")
	public WebElement AccountsMainMenu;
	
	
	
	
}
