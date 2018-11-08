import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class testweb {

    private static ChromeDriverService service;
    private WebDriver driver;

    @BeforeAll
    static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("driver/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @AfterAll
    static void createAndStopService() {
        service.stop();
    }

    @BeforeEach
    void createDriver() {
        driver = new RemoteWebDriver(service.getUrl(),
                new ChromeOptions());
    }

    @AfterEach
    void quitDriver() {
        driver.quit();
    }

    @Test
    void testGoogleSearch() {
        driver.get("https://cryptovoucher.io/buy-voucher");
        WebElement logo = driver.findElement(By.className("NavigationBar__logo"));
        logo.click();

        assertEquals("Bitcoin as gift card? Buy BTC online instantly with credit card", driver.getTitle());
        assertEquals("https://cryptovoucher.io/", driver.getCurrentUrl());

        driver.quit();
    }
}