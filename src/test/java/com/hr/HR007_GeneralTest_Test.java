package com.hr;

import com.hr.testBase.TestBase;
import org.testng.annotations.Test;

public class HR007_GeneralTest_Test extends TestBase {

    @Test
    public void printSomething() {
        extentReports.startTest("HR007_GeneralTest_Test");
        System.out.println("** This Test is to Demo :: Health run projrct **");
        extentReports.endTest(extentTest);
    }
}
