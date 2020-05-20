package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testScenarios.DateParser;
import utility.FileUtility;

public class ListenerTest implements ITestListener {

	// When Test case get failed, this method is called.
	@Override
	public void onTestFailure(ITestResult Result) {
		
		String scenarioName = DateParser.scenarioName;
		String input = DateParser.input;
		String result = "FAILED";
		String row="<tr>\r\n" + 
				"    <td>"+scenarioName+"</td>\r\n" + 
				"    <td>"+input+"</td>\r\n" + 
				"    <td style=\"color:red;\">"+result+"</td>\r\n" +
				"  </tr>";
		try {
			FileUtility.writeInFile(row);
		}catch(Exception e) {
			System.out.println("Failed to write result");
		}
		System.out.println("The name of the testcase failed is :" + Result.getName());
	}

	// When Test case get Skipped, this method is called.
	@Override
	public void onTestSkipped(ITestResult Result) {
		System.out.println("The name of the testcase Skipped is :" + Result.getName());
		String scenarioName = DateParser.scenarioName;
		String input = DateParser.input;
		String result = "SKIPPED";
		String row="<tr>\r\n" + 
				"    <td>"+scenarioName+"</td>\r\n" + 
				"    <td>"+input+"</td>\r\n" + 
				"    <td style=\"color:gray;\">"+result+"</td>\r\n" +
				"  </tr>";
		try {
			FileUtility.writeInFile(row);
		}catch(Exception e) {
			System.out.println("Failed to write result");
		}
	}

	// When Test case get passed, this method is called.
	@Override
	public void onTestSuccess(ITestResult Result) {
		System.out.println("The name of the testcase passed is :" + Result.getName());
		String scenarioName = DateParser.scenarioName;
		String input = DateParser.input;
		String result = "PASSED";
		String row="<tr>\r\n" + 
				"    <td>"+scenarioName+"</td>\r\n" + 
				"    <td>"+input+"</td>\r\n" + 
				"    <td style=\"color:green;\">"+result+"</td>\r\n" +
				"  </tr>";
		try {
			FileUtility.writeInFile(row);
		}catch(Exception e) {
			System.out.println("Failed to write result");
		}
	}

	// When Test case get Started, this method is called.
	@Override
	public void onTestStart(ITestResult Result) {
		System.out.println(Result.getName() + " test case started");
	}

	@Override
	public void onFinish(ITestContext Result) {

	}

	@Override
	public void onStart(ITestContext Result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}
}