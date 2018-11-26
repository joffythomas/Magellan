package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NotificationElement {
	
	WebDriver driver;
	public NotificationElement(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='dropdown-menu']//li[5]//*[contains(text(),'Notifications')]")
	public WebElement Notification;
	
	public WebDriver GetDriver() {
		return driver;
	}
	
}
