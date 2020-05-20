package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class datesubmitpageObject {
	WebDriver driver;
	WebDriverWait wait;
	public datesubmitpageObject(WebDriver driver){
		this.driver= driver;
		wait = new WebDriverWait(driver, 15);
	}
	static By dateInput = By.name("date");
	static By result = By.xpath("//h3[contains(text(),'Results')]/following-sibling::div");
	static By submitButton = By.xpath("//input[@type='submit']");
	
	public void enterDate(String date) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(dateInput));
		driver.findElement(dateInput).sendKeys(date);
	}
	public void clickOnSubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
		driver.findElement(submitButton).click();;
	}
	public String getResult() {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(result));
		return driver.findElement(result).getText();
	}
}
