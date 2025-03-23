package utility;

import io.qameta.allure.Allure;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotSendEmail extends Utility {
    private static File screenshotFile = null;
    private static final Logger logger = LogManager.getLogger(ScreenshotSendEmail.class.getName());

    public static void screenshotMailer(WebElement element) {
        try {
            try (FileInputStream screenshotStream = new FileInputStream(ScreenshotSendEmail.takeScreenshot())) {
                Allure.addAttachment("Screenshot", "image/png", screenshotStream, ".png");
            }
            sendingMail(ScreenshotSendEmail.takeScreenshot());
        } catch (IOException | EmailException ex) {
            ex.printStackTrace();
        }
        logger.error("Element not found");
        Assert.fail("Element not found: " + element.toString());
    }

    public static File takeScreenshot() throws IOException {
        if (screenshotFile != null && screenshotFile.exists()) {
            return screenshotFile;
        }

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        String formattedDate = myDateObj.format(myFormatObj);

        File takeScreenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        File folder = new File("src/test/java/screenshots");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        screenshotFile = new File(folder, formattedDate + ".png");
        Files.copy(takeScreenshot.toPath(), screenshotFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        return screenshotFile;
    }

    public static void sendingMail(File screenshotFile) throws EmailException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(ConfigReader.getProperty("yourEmail"), ConfigReader.getProperty("appPasswords")));
        email.setSSLOnConnect(true);
        email.setFrom(ConfigReader.getProperty("yourEmail"), "Instagram Appium Android Test Automation");
        email.setSubject("Instagram Appium Android Test Raporu");
        email.setMsg("Test basarisiz oldu. Ekteki ekran görüntüsüne bakabilirsiniz.");

        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(screenshotFile.getAbsolutePath());
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Hata Ekran Görüntüsü");
        attachment.setName(screenshotFile.getName());
        email.attach(attachment);

        email.addTo(ConfigReader.getProperty("sendEmail"));
        email.send();
    }
}