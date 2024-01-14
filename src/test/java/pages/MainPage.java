package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.AuthModalWindow;
import pages.components.Header;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement searchInput = $(".search-form__input"),
                            courseLanguageDropDown = $(".select-box__toggle-btn"),
                            engLanguageOption = $(withText("На английском")),
                            ruLanguageOption = $(withText("На русском")),
                            certificateCheckBox = $x("//span[text()='С сертификатами']"),
                            freeCheckBox = $x("//span[text()='Бесплатные']"),
                            searchButton = $(".search-form__submit");

    public AuthModalWindow authModalWindow = new AuthModalWindow();
    public Header header = new Header();


    public MainPage openPage(){
        open(baseUrl);
        return this;}

    public MainPage checkVisibilitySearchInput(){
        searchInput.shouldBe(visible);
        return this;
    }

    public MainPage checkVisibilityCourseLanguageDropDown(){
        courseLanguageDropDown.shouldBe(visible);
        return this;
    }

    public MainPage checkVisibilityCertificateCheckBox(){
        certificateCheckBox.shouldBe(visible);
        return this;
    }

    public MainPage checkVisibilityFreeCheckBox(){
        freeCheckBox.shouldBe(visible);
        return this;
    }

    public MainPage checkVisibilitySearchButton(){
        searchButton.shouldBe(visible);
        return this;
    }

    public MainPage setSearch(String search){
        searchInput.setValue(search);
        return this;
    }


    public MainPage selectFreeCheckBox(){
        freeCheckBox.click();
        return this;
    }

    public SearchPage clickSearchButton(){
        searchButton.click();
        return page(SearchPage.class);
    }

    public MainPage selectEngCourseLanguage(){
        courseLanguageDropDown.click();
        engLanguageOption.click();
        return this;
    }

    public MainPage selectRuCourseLanguage(){
        courseLanguageDropDown.click();
        ruLanguageOption.click();
        return this;
    }

}
