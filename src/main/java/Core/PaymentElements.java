package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaymentElements {

	static WebDriver driver;
	
	public PaymentElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(how=How.XPATH, using=".//*[@class='dropdown-menu']//li[4]//*[contains(text(),'Payments')]")
	public WebElement PaymentMenu;

public WebDriver getdriver() {
	
	return driver;
	
}
}