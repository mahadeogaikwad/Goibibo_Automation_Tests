package com.hr;

import com.hr.pages.HomePage;
import com.hr.pages.PatientReportsPage;
import com.hr.testBase.TestBase;
import com.hr.testUtils.TestUtilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class HR21_ValidateDoctorSeePatientReportsOfSelectedDates_Test extends TestBase {
    HomePage homePage;
    PatientReportsPage patientReportsPage;

    public HR21_ValidateDoctorSeePatientReportsOfSelectedDates_Test() {
        super();
    }

    @BeforeMethod
    public void login () throws MalformedURLException {
        TestUtilities.initialize();
        TestUtilities.loginToHospitalRun();
    }

    @Test
    public void validateDoctorSeePatientReportsOfSelectedDates(){
        extentReports.startTest("Start Test :: HR21 - Validate doctor see patient reports of selected dates");
        homePage = new HomePage();
        homePage.clickOnPatientsTab();

        //To validate patient listing tab is displayed after clicking on patients tab
        Assert.assertTrue(homePage.isPatientListingTabDisplayed());
        System.out.println("Successfully validated patient listing tab displayd");

        //To validate after clicking on reports tab user placed on patient reports page
        patientReportsPage = homePage.clickOnReportsTab();
        patientReportsPage.isPatientReportsHeaderDisplayed();
        System.out.println("Successfully validated user placed on patients reports page displayd");
        System.out.println("End Test :: HR21 - Validate doctor see patient reports of selected dates");
        System.out.println("Passed Test :: HR21 - Validate doctor see patient reports of selected dates");
    }

    @Test
    public void test() {
        extentReports.startTest("Start Test :: HR21 - Validate doctor see patient reports of selected dates");
        System.out.println("Inside test 2");
    }

    @AfterMethod
    public void testTearDown(ITestResult result) throws IOException, InterruptedException {
        if (result.getStatus() == ITestResult.FAILURE) {
            TestUtilities.takeScreenshot(result.getName());
            Reporter.log("Test Failed");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            Reporter.log("Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            Reporter.log("Test Skipped");
        }
        TestUtilities.logOutOfHospitalRun();
        extentReports.endTest(extentTest);
        driver.quit();
    }
}
