package com.report;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Reporter implements ITestListener{

	public static ExtentTest extentTest;

	public Reporter() {  }

	// Initialize Log4j logs
	public static Logger Log = Logger.getLogger(Reporter.class.getName());

	public static void startTestCase(String sTestCaseName) {
		Log.info(" Execution of Test Case ::" + sTestCaseName + "  has started");
	}

	public static void endTestCase(String sTestCaseName) {
		Log.info("Execution of Test Case :: " + sTestCaseName +  " has ended");
	}

	public static void info(String message) {
		try {
			Log.info(message);
			ExtentTestManager.getTest().log(Status.INFO, message);
		}catch (Exception e) {
			Log.error(e);
			e.printStackTrace();
		}
	}

	public static void pass(String message) {
		try {
			Log.info(message);
			ExtentTestManager.getTest().log(Status.PASS, message);
		}catch (Exception e) {
		}
	}

	public static void fail(String message) {
		try {
			Log.info(message);
			ExtentTestManager.getTest().log(Status.FAIL, message);
		}catch (Exception e) {
		}
	}

	public static void warn(String message) {
		try {
			Log.warn(message);
			ExtentTestManager.getTest().log(Status.WARNING, message);
		}catch (Exception e) {
		}
	}
	public static void error(String message) {
		try {
			Log.error(message);
			//ExtentTestManager.getTest().log(Status.ERROR, "<b style='color:blue;'>Failed due to >>> </b>"++"<b style='color:red;'>Reson >>> </b>"+TestUtility.errorMsg);
		}catch (Exception e) {
		}
	}

	public static void fatal(String message) {
		try {
			Log.fatal(message);
			ExtentTestManager.getTest().log(Status.FATAL, message);
		}catch (Exception e) {
		}
	}

	public void onStart(ITestContext context) {
		startTestCase("*** Test Class " + context.getName()+ " started ***");
	}

	public void onFinish(ITestContext context) {
		endTestCase("*** Test Class " + context.getName() + " ending ***");
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		Log.info(("**************************** Running Test Method " + result.getMethod().getMethodName() + "()  ****************************"));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
		ExtentTestManager.getTest().log(Status.PASS, "**************************** Running Test Method >>> " + result.getMethod().getMethodName() + "()  Start ****************************");
	}

	public void onTestSuccess(ITestResult result) {
		Log.info("**************************** Executed " + result.getMethod().getMethodName() + "() Test successfully finished ****************************");
		ExtentTestManager.getTest().log(Status.PASS, "**************************** Executed "+result.getMethod().getMethodName()+"() Test successfully finished ****************************");
	}

	public void onTestFailure(ITestResult result) {
		/*Log.error("TEST CASE FAILED DUE TO  >>>>>  "+result.getThrowable()+";"+"       Reason :  "+TestUtility.errorMsg);
		ExtentTestManager.getTest().log(Status.FAIL, "<b style='color:blue;'> TEST CASE FAILED DUE TO  >>>>>  "+"<b style='color:red;'>"+result.getThrowable()+"; "+"</b>"+"         Reason: "+"<b style='color:red;'> "+TestUtility.errorMsg+"</b>");
		*/
		Throwable errorMessage=result.getThrowable();
		String errorMsg=errorMessage.toString();
		String[] msg=errorMsg.split(",");
		//Weblocator.Text2Speech("We have found "+ msg.length+" assertion failed");
		
		
		Log.info("**************************** Test Method "+result.getName()+"() successfully finished  ****************************");
		ExtentTestManager.getTest().log(Status.PASS, "**************************** Test Method "+result.getName()+"() successfully finished ****************************");
		
		Log.error("conclusion  >>>>>  "+result.getThrowable());
		ExtentTestManager.getTest().log(Status.FAIL, "<b style='color:blue;'>CONCLUSION  >>>>></b>"+"<b style='color:red;'>"+result.getThrowable()+"; "+"</b>");
	
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		Log.info("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "****  "+result.getMethod().getMethodName()+"() Test Skipped ****");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Log.info("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}



}
