package testScenarios;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObject.datesubmitpageObject;
import utility.DataProviderClass;

@Listeners(listener.ListenerTest.class)
public class DateParser extends TestBase {
	public static String scenarioName;
	public static String input;
  @Test(priority = 1, dataProvider = "dates", dataProviderClass = DataProviderClass.class)
  public void date(String scenarioName,String input,String expected) {
	  this.scenarioName=scenarioName;
	  this.input=input;	  
	  datesubmitpageObject obj= new datesubmitpageObject(driver);
	  System.out.println("expected "+expected);
	  obj.enterDate(input);
	  obj.clickOnSubmitButton();
	  String result=obj.getResult();
	  System.out.println("Result "+result);
	  if(!result.equals(expected))
	  Assert.fail("Result not matching");
	  
  }
}
