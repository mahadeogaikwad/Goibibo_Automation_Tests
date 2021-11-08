package com.hr.testBase;

import com.beust.jcommander.Parameter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static Logger log = Logger.getLogger(TestBase.class.getName());
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeSuite
    public void startReport(){
        extentReports = new ExtentReports(System.getProperty("user.dir")+"/hospitalRun_Automation_Tests.html", true);
    }

    public TestBase(){
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
            prop = new Properties();
            try {
                prop.load(file);
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void initialize() throws MalformedURLException {
        if (prop.getProperty("browser").equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (prop.getProperty("browser").equals("FireFox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (prop.getProperty("browser").equals("remoteChrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
            options.addArguments("--log-level=3");
            options.addArguments("--silent");

            capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            driver = new RemoteWebDriver(new URL("url of node"),capabilities);
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("testEnvironmentUrl"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void extentClose(){
        extentReports.flush();
        extentReports.close();
    }
}
