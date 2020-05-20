package testScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utility.FileUtility;

public class TestBase {
	public static String siteURL="https://vast-dawn-73245.herokuapp.com";
	WebDriver driver;
	@BeforeSuite
	public void beforeSuite() {
		String htlm="<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<style>\r\n" + 
				"table {\r\n" + 
				"  font-family: arial, sans-serif;\r\n" + 
				"  border-collapse: collapse;\r\n" + 
				"  width: 100%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"td, th {\r\n" + 
				"  border: 1px solid #dddddd;\r\n" + 
				"  text-align: left;\r\n" + 
				"  padding: 8px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"tr:nth-child(even) {\r\n" + 
				"  background-color: #dddddd;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"<h2>Test Result</h2>\r\n" + 
				"\r\n" + 
				"<table>\r\n" + 
				"  <tr>\r\n" + 
				"    <th>Scenario Name</th>\r\n" + 
				"    <th>Input</th>\r\n" + 
				"    <th>Result</th>\r\n" + 
				"  </tr>";
		try {
			FileUtility.deleteFile();
			FileUtility.writeInFile(htlm);
		}catch(Exception e) {
			System.out.println("Failed to write result");
		}
		 System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")
					+ "\\Drivers\\chromedriver.exe"));
		 
	}
	@AfterSuite
	public void afterSuite() throws Exception {
		String htlm="</table>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>";
		try {
			FileUtility.writeInFile(htlm);
		}catch(Exception e) {
			System.out.println("Failed to write result");
		}
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
	driver= new ChromeDriver();
	driver.get(siteURL);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
	driver.quit();
	}
}
