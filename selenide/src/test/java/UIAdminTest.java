import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

class UIAdminTest {

    @Test
    void checkGoogleSearch() {
        System.setProperty("webdriver.chrome.driver", "src/main/browserDriver/chromedriver.exe");
        System.setProperty("selenide.browser", "chrome");
        open("https://uiadmin.g2a-test.com/#/login");
        $(By.name("login")).setValue("michal.lukasik");
        $(By.name("password")).setValue("Start123").pressEnter();
        $(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div/div/div/div[7]")).hover().
        $(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div/div/div/div[7]/div/div/div[2]/div/button[3]")).click();
        assert title().equals("G2A UI Admin");
    }

}
