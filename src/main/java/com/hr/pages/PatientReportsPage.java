package com.hr.pages;

import com.hr.testBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientReportsPage extends TestBase {

    @FindBy(xpath = "//input[contains(@id,'display_startDate')]")
    WebElement startDate;

    @FindBy(xpath = "//input[contains(@id,'display_endDate')]")
    WebElement endDate;

    @FindBy(xpath = "//button[text()='Generate Report']")
    WebElement generateReportButton;

    @FindBy(xpath = "//h1[text()='Patient Report']")
    WebElement patientReportHeader;

    public PatientReportsPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterStartDate(String startDateToSelect) {
        startDate.sendKeys(startDateToSelect);
    }

    public void enterEndDate(String endDateToSelect) {
        endDate.sendKeys(endDateToSelect);
    }

    public void clickOnGenerateReportButton() {
        generateReportButton.click();
    }

    public boolean isPatientReportsHeaderDisplayed() {
        return patientReportHeader.isDisplayed();
    }
}
