package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoQATest {
    private WebDriver driver;
    private DemoQATextBoxPage textBoxPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(ConfProperties.getProperty("registration-page"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        textBoxPage = new DemoQATextBoxPage(driver);
    }

    @Test
    public void testTextBoxForm() {
        // Заполните форму
        textBoxPage.setUserName(ConfProperties.getProperty("first-name") + " " + ConfProperties.getProperty("last-name"));
        textBoxPage.setUserEmail(ConfProperties.getProperty("email"));
        textBoxPage.setCurrentAddress(ConfProperties.getProperty("current-address"));
        textBoxPage.setPermanentAddress(ConfProperties.getProperty("current-address"));

        // Нажмите кнопку отправки
        textBoxPage.clickSubmit();

        // Проверьте вывод
        String outputText = textBoxPage.getOutputText();
        String expectedOutputText = "Name:" + ConfProperties.getProperty("first-name") + " " + ConfProperties.getProperty("last-name") + "\n" +
                "Email:" + ConfProperties.getProperty("email") + "\n" +
                "Current Address :" + ConfProperties.getProperty("current-address") + "\n" +
                "Permananet Address :" + ConfProperties.getProperty("current-address");
        assertEquals(expectedOutputText, outputText);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
