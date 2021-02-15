package Testcase;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;


public class BaseClass extends BaseExample{

    public AppiumDriver<MobileElement> driver;
    public AndroidDriver<MobileElement> androidDriver;

    //This function do before execute all test
    @BeforeClass
    public void BeforeClass() {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName", "Oneplus");
            cap.setCapability("udid", "88960370");
            cap.setCapability("platformName", "Android");
            cap.setCapability("platformVersion", "10");
            cap.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
            //Just Add
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            cap.setCapability("appPackage", "com.cellcard.poukmak");
            cap.setCapability("appActivity", ".ui.activities.splashscreen.SplashScreenActivity");
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver<>(url, cap);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (Exception exp) {
            System.out.print("Cause is: " + exp);
            System.out.print("Message: " + exp.getMessage());
            exp.printStackTrace();
        }
    }

    //Set Case to Fail
    public void setFail() {
        ITestResult result = null;
        result.setStatus(ITestResult.FAILURE);
        Reporter.setCurrentTestResult(result);
    }

    //Check if view Display
    public boolean checkViewDisplay(String id) {
        MobileElement element = driver.findElement(By.id(id));
        return element.isDisplayed();
    }

    //Click Button by Xpath
    public void clickBtnBack() {
        MobileElement btnBack = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
        btnBack.click();
    }

    //Click by ID
    public void clickById(String id) {
        MobileElement click = driver.findElement(By.id(id));
        click.click();
    }

    //Send Key By ID
    public void sendKeyById(String id, String key) {
        MobileElement sendKeyElement = driver.findElement(By.id(id));
        sendKeyElement.sendKeys(key);
    }

    //Click by Xpath
    public void clickXpathElement(String element) {
        MobileElement click = driver.findElement(By.xpath(element));
        click.click();
    }

    //Get text by ID
    public String getTextByID(String element) {
        MobileElement getText = driver.findElement(By.id(element));
        return getText.getText();
    }

    //Get text by Xpath
    public String getTextByXpath(String element) {
        MobileElement getText = driver.findElement(By.xpath(element));
        print(getText.getText() + "\n");
        return getText.getText();
    }

    //Print Out the message
    public void print(String message) {
        System.out.print(message);
    }

    //Scroll until see the ID
    public void scrollByID(String Id, int index) {
        try {
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""+Id+"\").instance("+index+"));"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Take Screen Shot
    public void takeScreenShot(String title) throws IOException {
        LocalDate date = LocalDate.now();
        File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/main/resources/Screenshot/" + title + "_"+ date + "_screenshot.jpg"));
    }

    //Open Notification
    public void openNotification(){
        new TouchAction(driver)
                .press(PointOption.point(0,0))
                .moveTo(PointOption.point(450, 1750))
                .release()
                .perform();
    }

    //Open Notification
    public void closeNotification(){
        new TouchAction(driver)
                .press(PointOption.point(450,1750))
                .moveTo(PointOption.point(0, 0))
                .release()
                .perform();
    }
}