package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase {

    private MainPage mainPage = new MainPage();


    @Test
    @Feature("Search")
    @Owner("kegorova")
    void SearchBarIsDisplayedTest(){
        step("Open main page", () -> {
            open(baseUrl);
        });
        step("Verify search bar elements in the main page", () -> {
            mainPage.checkSearchInput()
                    .checkCourseLanguageDropDown()
                    .certificateCheckBox()
                    .checkFreeCheckBox()
                    .checkSearchButton();
        });
    }

    @Test
    @Feature("Search")
    @Owner("kegorova")
    @Disabled
    void SearchFreeCourseAnyLanguageTest(){
        step("Select free course checkbox", () -> {
            mainPage.checkFreeCheckBox();
        });
        step("Set search value", () -> {
            mainPage.setSearch("selenide");
        });
        step("Click on the search button", () -> {
            mainPage.clickSearchButton();
        });
        //todo verify data in search result according to search settings
    }

    @Test
    @Feature("Search")
    @Owner("kegorova")
    @Disabled
    void SearchFreeCourseEnglishLanguageTest(){
        step("Select free course checkbox", () -> {
            mainPage.checkFreeCheckBox();
        });
        step("Select English language", () -> {
            mainPage.selectCourseLanguage("На английском");
        });
        step("Set search value", () -> {
            mainPage.setSearch("selenide");
        });
        step("Click on the search button", () -> {
            mainPage.clickSearchButton();
        });
        //todo verify data in search result according to search settings
    }

    @Test
    @Feature("Search")
    @Owner("kegorova")
    @Disabled
    void SearchFreeCourseRussianLanguageTest(){
        step("Select free course checkbox", () -> {
            mainPage.checkFreeCheckBox();
        });
        step("Select Russian language", () -> {
            mainPage.selectCourseLanguage("На русском");
        });
        step("Set search value", () -> {
            mainPage.setSearch("selenide");
        });
        step("Click on the search button", () -> {
            mainPage.clickSearchButton();
        });
        //todo verify data in search result according to search settings
    }

}
