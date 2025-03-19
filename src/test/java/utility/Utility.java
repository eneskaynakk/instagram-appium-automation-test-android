package utility;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utility{
    private final Actions action = new Actions(Driver.getDriver());

    public void clickElementWithWait(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            Driver.getDriver().executeScript("mobile: clickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
        } catch (TimeoutException | NoSuchElementException e) {
            ScreenshotSendEmail.screenshotMailer(element);
        }
    }

    public void scrollToCenter(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public void scrollAndClickElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            wait.until(ExpectedConditions.visibilityOf(element)).click();
        } catch (TimeoutException | NoSuchElementException e) {
            ScreenshotSendEmail.screenshotMailer(element);
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

    public static void waits(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
