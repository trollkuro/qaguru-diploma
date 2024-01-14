package tests;

import pages.MainPage;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


@DisplayName("AuthModalWindow")
public class AuthModalWindowTests extends BaseTest{

    private MainPage mainPage = new MainPage();


    @Test
    @Tag("AuthModalWindow")
    @Feature("User login")
    @Owner("kegorova")
    @DisplayName("Verify login elements are returned in the modal window")
    void loginOptionIsDisplayedTest(){
        step("Open main page", () -> {
            mainPage.openPage();
        });
        step("Click on Sign in button", () -> {
            mainPage.header.clickOnLoginButton();
        });
        step("Verify login inputs", () -> {
            mainPage.authModalWindow.modalWindowWithLoginIsDisplayed();
        });
    }

    @Test
    @Tag("AuthModalWindow")
    @Feature("User login")
    @Owner("kegorova")
    @DisplayName("Verify registration elements are returned in the modal window")
    void RegistrationOptionIsDisplayedTest(){
        step("Open main page", () -> {
            mainPage.openPage();
        });
        step("Click on Sign in button", () -> {
            mainPage.header.clickOnRegistrationButton();
        });
        step("Verify registration inputs", () -> {
            mainPage.authModalWindow.modalWindowWithRegistrationIsDisplayed();
        });
    }

    @Test
    @Tag("AuthModalWindow")
    @Feature("User login")
    @Owner("kegorova")
    @DisplayName("Auth modal window is closed by x-icon")
    void modalWindowIsClosedByIconTest(){
        step("Open main page", () -> {
            mainPage.openPage();
        });
        step("Click on Sign in button", () -> {
            mainPage.header.clickOnRegistrationButton();
        });
        step("Close modal window", () -> {
            mainPage.authModalWindow.closeModalWindow();
        });
        step("Verify that modal window is closed", () -> {
            mainPage.authModalWindow.modalWindowIsClosed();
        });
    }
}
