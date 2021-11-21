package com.hr;

import com.hr.testBase.TestBase;
import com.hr.testUtils.TestUtilities;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HR007_GeneralTest_Test extends TestBase {

    @Test
    public void printSomething() {
        extentTest = extentReports.startTest("HR007_GeneralTest_Test");
        System.out.println("** This Test is to Demo :: Health run projrct **");
        Assert.fail();
    }

    @AfterMethod
    public void testTearDown(ITestResult result) throws IOException, InterruptedException {
        if (result.getStatus() == ITestResult.FAILURE) {
            TestUtilities.takeScreenshot(result.getName());
            extentTest.log(LogStatus.FAIL,"Test Failed");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(LogStatus.PASS,"Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(LogStatus.SKIP,"Test Skipped");
        }
        extentReports.endTest(extentTest);
    }
}
