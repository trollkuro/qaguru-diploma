package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase {

    private MainPage mainPage = new MainPage();
    private SearchPage searchPage = new SearchPage();


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
    void SearchFreeCourseAnyLanguageTest(){
        step("Open main page", () -> {
            open(baseUrl);
        });
        step("Select free course checkbox", () -> {
            mainPage.selectFreeCheckBox();
        });
        step("Set search value", () -> {
            mainPage.setSearch("selenide");
        });
        step("Click on the search button", () -> {
            mainPage.clickSearchButton();
        });
        step("Verify that courses are free", () -> {
            searchPage.courseIsFree();
        });
    }

    @Test
    @Feature("Search")
    @Owner("kegorova")
    void SearchPaidCourseAnyLanguageTest(){
        step("Open main page", () -> {
            open(baseUrl);
        });
        step("Click on the search button", () -> {
            mainPage.clickSearchButton();
        });
        step("Verify that course with payment", () -> {
            searchPage.courseWithPayment();
        });
    }

    @Test
    @Feature("Search")
    @Owner("kegorova")
    void SearchFreeCourseEnglishLanguageTest(){
        step("Open main page", () -> {
            open(baseUrl);
        });
        step("Select free course checkbox", () -> {
            mainPage.selectFreeCheckBox();
        });
        step("Select English language", () -> {
            mainPage.selectEngCourseLanguage();
        });
        step("Set search value", () -> {
            mainPage.setSearch("English For Developers");
        });
        step("Click on the search button", () -> {
            mainPage.clickSearchButton();
        });
        step("Verify that search result has English course", () -> {
            searchPage.checkCourseCardTitle("English For Developers");
        });
    }

    @Test
    @Feature("Search")
    @Owner("kegorova")
    @Disabled
    void SearchFreeCourseRussianLanguageTest(){
        step("Open main page", () -> {
            open(baseUrl);
        });
        step("Select free course checkbox", () -> {
            mainPage.selectFreeCheckBox();
        });
        step("Select Russian language", () -> {
            mainPage.selectRuCourseLanguage();
        });
        step("Set search value", () -> {
            mainPage.setSearch("Английский. A1 уровень");
        });
        step("Click on the search button", () -> {
            searchPage.checkCourseCardTitle("Английский. A1 уровень");
        });
    }

}
