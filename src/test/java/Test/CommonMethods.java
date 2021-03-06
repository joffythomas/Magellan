package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import ExcelUtils.Constants;
import ExcelUtils.ExcelUtils;

public class CommonMethods {

	static WebDriver driver;
	public static Properties prop;
	public static FileInputStream FIS;
	
	public static void openpropfile() throws IOException
	{
		File file = new File("F:/JOFFY JOY/Auto New Workspace/Jesus/src/main/java/Core/Object.properties");
					
		try {
			prop = new Properties();
			FIS = new FileInputStream(file);
			prop.load(FIS);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 1)
	public static void openbrowser() throws IOException {
		openpropfile();
		System.setProperty("webdriver.chrome.driver", "F://JOFFY JOY//Auto New Workspace//Jesus//bin//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
	}
	
	public void getDataSheetforLogin(String SheetName) throws Exception {
		ExcelUtils.setExcelFile(Constants.ExcelPath + Constants.TestData, SheetName);
	}
	
	public WebDriver getDriver()
	{
		 
		return driver;
		
	}
	
}
 