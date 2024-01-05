package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement searchInput = $(".search-form__input"),
                            courseLanguageDropDown = $(".select-box__toggle-btn"),
                            engLanguageOption = $(withText("На английском")),
                            ruLanguageOption = $(withText("На русском")),
                            anyLanguageOption = $(withText("На любом языке")),
                            certificateCheckBox = $x("//span[text()='С сертификатами']"),
                            freeCheckBox = $x("//span[text()='Бесплатные']"),
                            searchButton = $(".search-form__submit");


    public MainPage openPage(){
        open(baseUrl);
        return this;
    }public MainPage checkSearchInput(){
        searchInput.shouldBe(visible);
        return this;
    }

    public MainPage checkCourseLanguageDropDown(){
        courseLanguageDropDown.shouldBe(visible);
        return this;
    }

    public MainPage certificateCheckBox(){
        certificateCheckBox.shouldBe(visible);
        return this;
    }

    public MainPage checkFreeCheckBox(){
        freeCheckBox.shouldBe(visible);
        return this;
    }

    public MainPage checkSearchButton(){
        searchButton.shouldBe(visible);
        return this;
    }

    public MainPage setSearch(String search){
        searchInput.setValue(search);
        return this;
    }

    public MainPage selectCertificateCheckBox(){
        certificateCheckBox.click();
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

    public MainPage selectAnyCourseLanguage(){
        courseLanguageDropDown.click();
        anyLanguageOption.click();
        return this;
    }






}
