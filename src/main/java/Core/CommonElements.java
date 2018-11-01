package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CommonElements {
static WebDriver driver;

	public CommonElements(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
}
