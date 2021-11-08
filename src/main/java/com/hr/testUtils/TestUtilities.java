package com.hr.testUtils;

import com.hr.pages.LoginPage;
import com.hr.testBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TestUtilities extends TestBase {

    public static void loginToHospitalRun() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(prop.getProperty("doctorsUsername"));
        loginPage.enterPassword(prop.getProperty("doctorsPassword"));
        loginPage.clickOnSignInButton();
    }

    public static void logOutOfHospitalRun() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='settings-trigger ']")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("logout")).click();
    }

    public static void takeScreenshot(String testName) throws IOException {
        Timestamp currentDateTime = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timeStamp = sdf.format(currentDateTime);
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir")+"/ScreenShots/"+testName+timeStamp+".png");
        FileHandler.copy(source, destination);
    }


}
