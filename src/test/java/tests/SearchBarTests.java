package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@DisplayName("Search bar")
public class SearchBarTests extends BaseTest {

    private MainPage mainPage = new MainPage();
    private SearchPage searchPage = new SearchPage();

    private static final String FREE_ENG_SEARCH_VALUE = "SQL Introduction";
    private static final String FREE_RU_SEARCH_VALUE = "Английский. A1 уровень";


    @Test
    @Tag("Search bar on main page")
    @Feature("Search")
    @Owner("kegorova")
    @DisplayName("Search bar is displayed on main page")
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
    @Tag("Search")
    @Feature("Search")
    @Owner("kegorova")
    @DisplayName("Search for free course without specified language")
    void SearchFreeCourseAnyLanguageTest(){
        step("Open main page", () -> {
            open(baseUrl);
        });
        step("Select free course checkbox", () -> {
            mainPage.selectFreeCheckBox();
        });
        step("Click on the search button", () -> {
            mainPage.clickSearchButton();
        });
        step("Verify that courses are free", () -> {
            searchPage.courseIsFree();
        });
    }

    @Test
    @Tag("Search")
    @Feature("Search")
    @Owner("kegorova")
    @DisplayName("Search for course with payment without specified language")
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
    @Tag("Search")
    @Feature("Search")
    @Owner("kegorova")
    @DisplayName("Search for free course with language = English")
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
            mainPage.setSearch(FREE_ENG_SEARCH_VALUE);
        });
        step("Click on the search button", () -> {
            mainPage.clickSearchButton();
        });
        step("Verify that search result has English course", () -> {
            searchPage.checkCourseCardTitle(FREE_ENG_SEARCH_VALUE);
        });
    }

    @Test
    @Tag("Search")
    @Feature("Search")
    @Owner("kegorova")
    @DisplayName("Search for free course with language = Russian")
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
            mainPage.setSearch(FREE_RU_SEARCH_VALUE);
        });
        step("Click on the search button", () -> {
            searchPage.checkCourseCardTitle(FREE_RU_SEARCH_VALUE);
        });
    }
}