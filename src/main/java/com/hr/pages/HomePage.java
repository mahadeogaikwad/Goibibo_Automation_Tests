package com.hr.pages;

import com.hr.testBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase {

    @FindBy(linkText = "Patients")
    WebElement patientsTab;

    @FindBy(linkText = "Reports")
    WebElement reportsTab;

    @FindBy(linkText = "Patient Listing")
    WebElement patientListingTab;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnPatientsTab() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(patientsTab));
        patientsTab.click();
    }

    public PatientReportsPage clickOnReportsTab() {
        reportsTab.click();
        return new PatientReportsPage();
    }

    public boolean isPatientListingTabDisplayed() {
        return patientListingTab.isDisplayed();
    }
}
