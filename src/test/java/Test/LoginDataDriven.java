package Test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Core.CommonElements;
import Core.LoginElements;
import ExcelUtils.Constants;
import ExcelUtils.ExcelUtils;

public class LoginDataDriven {

	static WebDriver driver;
	public static LoginElements objLoginElements;
	public CommonMethods objCommonMethods;
	public CommonElements objCommonElements;
	public static Properties prop;
	int rowindex;
	
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
	public void usernameEmptyValidation() throws Exception {
		try {
			objCommonMethods.getDataSheetforLogin(Constants.Login_SheetName);
			rowindex = ExcelUtils.findRow(Thread.currentThread().getStackTrace()[1].getMethodName());
			Core.LoginElements.login(ExcelUtils.getCellData(1, 0), ExcelUtils.getCellData(1, 1));
			} catch (Error e) {
			e.printStackTrace();
		}
	}
	
}
