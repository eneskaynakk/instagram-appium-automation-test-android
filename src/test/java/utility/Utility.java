package utility;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utility {
    private final Actions action = new Actions(Driver.getDriver());
    private static final Logger logger = LogManager.getLogger(Utility.class.getName());

    public void clickElementWithWait(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));

            Driver.getDriver().executeScript("mobile: clickGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId()));
        } catch (TimeoutException | NoSuchElementException e) {
            ScreenshotSendEmail.screenshotMailer(element);
        }
    }

    public static void scrollWithCoordinates(WebElement element, int left, int top, int width, int height, String direction, int x, int speed) {
        while (true) {
            try {
                Driver.getDriver().executeScript("mobile: scrollGesture", ImmutableMap.of(
                        "left", left, "top", top, "width", width, "height", height,
                        "direction", direction,
                        "percent", x,
                        "speed", speed
                ));
                if (element.isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
                logger.info("Element not yet displayed, continuing to scroll...");
            }
        }
    }

    public void doubleClickElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            Driver.getDriver().executeScript("mobile: doubleClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
        } catch (TimeoutException | NoSuchElementException e) {
            ScreenshotSendEmail.screenshotMailer(element);
        }
    }

    public void sendKeyToElement(WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            action.sendKeys(element,text).perform();
        } catch (TimeoutException | NoSuchElementException e) {
            ScreenshotSendEmail.screenshotMailer(element);
        }
    }

    public void clearInputElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            for (int i = 0; i < 30; i++) {
                action.sendKeys(Keys.END).sendKeys(Keys.BACK_SPACE).perform();
            }
        } catch (TimeoutException | NoSuchElementException e) {
            ScreenshotSendEmail.screenshotMailer(element);
        }
    }

    public String getTextElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void pressBackButton() {
        Driver.getDriver().pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public static void waits(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}