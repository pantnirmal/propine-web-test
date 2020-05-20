package utility;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name = "dates")
	public static Object[][] getUserDataFromCSV() {
		try {
			return ExcelUtils.ReadExcelData("Sheet1");
		} catch (Exception e) {
			return null;
		}
	}
}
