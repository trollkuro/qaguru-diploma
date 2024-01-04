package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configs.WebBrowserConfig;
import helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        WebBrowserConfig webBrowserConfig = ConfigFactory.create(WebBrowserConfig.class, System.getProperties());
        Configuration.baseUrl = "https://stepik.org/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = webBrowserConfig.browserName();
        Configuration.browserVersion = webBrowserConfig.browserVersion();
        Configuration.browserSize = webBrowserConfig.browserSize();
        if(webBrowserConfig.isRemote()){
            Configuration.remote = webBrowserConfig.remoteURL();
        }
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


    @AfterEach
    void addAttachments() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();
        closeWebDriver();
    }
}