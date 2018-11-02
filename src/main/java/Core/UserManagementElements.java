package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserManagementElements {

	public WebDriver driver;
	
	public UserManagementElements() {
		this.driver = driver;
		PageFactory.initElements(driver,  this);
	}
	
	@FindBy(how=How.XPATH, using=".//*[@class=\"dropdown-menu\"]//li[2]//*[contains(text(),'User Management')]")
	public static WebElement usermanagementmenu;
	
	
	
	
}

