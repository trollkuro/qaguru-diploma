package tests;

import pages.components.AuthModalWindow;
import pages.components.Header;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@DisplayName("AuthModalWindow")
public class LoginTests extends BaseTest{

    private Header header = new Header();
    private AuthModalWindow authModalWindow = new AuthModalWindow();


    @Test
    @Tag("AuthModalWindow")
    @Feature("User login")
    @Owner("kegorova")
    @DisplayName("Verify login elements are returned in the modal window")
    void loginOptionIsDisplayedTest(){
        step("Open main page", () -> {
            open(baseUrl);
        });
        step("Click on Sign in button", () -> {
            header.clickOnLoginButton();
        });
        step("Verify login inputs", () -> {
            authModalWindow.modalWindowWithLoginIsDisplayed();
        });
    }

    @Test
    @Tag("AuthModalWindow")
    @Feature("User login")
    @Owner("kegorova")
    @DisplayName("Verify registration elements are returned in the modal window")
    void RegistrationOptionIsDisplayedTest(){
        step("Open main page", () -> {
            open(baseUrl);
        });
        step("Click on Sign in button", () -> {
            header.clickOnRegistrationButton();
        });
        step("Verify login inputs", () -> {
            authModalWindow.modalWindowWithRegistrationIsDisplayed();
        });
    }

    @Test
    @Tag("AuthModalWindow")
    @Feature("User login")
    @Owner("kegorova")
    @DisplayName("Auth modal window is closed by x-icon")
    void modalWindowIsClosedByIconTest(){
        step("Open main page", () -> {
            open(baseUrl);
        });
        step("Click on Sign in button", () -> {
            header.clickOnRegistrationButton();
        });
        step("Close modal window", () -> {
            authModalWindow.closeModalWindow();
        });
        step("Verify that modal window is closed", () -> {
            authModalWindow.modalWindowIsClosed();
        });
    }
}
