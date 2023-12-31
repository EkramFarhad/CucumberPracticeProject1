package Utils;

import StepDefinitions.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties();
        String browserType = ConfigReader.getPropertyValue("browserType");
        switch (browserType) {
            case "Chrome":
                driver = new ChromeDriver();
                break;

            case "Firefox":
                driver = new FirefoxDriver();
                break;

            case "Safari":
                driver = new SafariDriver();
                break;

            default:
                driver = new EdgeDriver();
                break;

        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Constants.WAIT_TIME));
        initializePageObject();

        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("This is the beginning of my test case");
        Log.info("My test case is executing right now");
        Log.endTestCase("My test case may have some trival issues");
    }

    //------------------------2nd class-------------------------------

    public static void closeBrowser() {

        Log.info("This test case is about to complete");
        Log.endTestCase("This test case is finished");

        driver.close();
    }

    public static void doClick(WebElement element) {
        element.click();


    }

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);

    }
//---------------------------3rd class------------------------------------

    public static Select clickOnDropdown(WebElement element) {
        Select select = new Select(element);
        return select;
    }

    public static void selectByValue(WebElement element, String value) {
        clickOnDropdown(element).selectByValue(value);
    }

    public static void selectByVisibleText(WebElement element, String text) {
        clickOnDropdown(element).selectByVisibleText(text);
    }

    public static void selectByIndex(WebElement element, int index) {
        clickOnDropdown(element).selectByIndex(index);

    }

    public static void selectByOptions(WebElement element, String text) {
        List<WebElement> options = clickOnDropdown(element).getOptions();
        for (WebElement option : options) {
            String addLOptionText = option.getText();
            if (addLOptionText.equalsIgnoreCase(text)) ;
            {
                option.click();
            }

        }
    }

    //-------------------------------4th class -------------------------------
    //------------------------------Screenshot -------------------------------

    public static byte[] takeScreenshot(String imageName) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourcePath = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourcePath, new File(Constants.SCREENSHOT_FILEPATH + imageName + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return picBytes;


    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        return sdf.format(date);
    }


}

