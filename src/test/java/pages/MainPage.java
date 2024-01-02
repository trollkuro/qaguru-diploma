package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement searchInput = $(".search-form__input"),
                            courseLanguageDropDown = $("#ember38_tb"),
                            engLanguageOption = $("#ember48"),
                            ruLanguageOption = $("#ember46"),
                            anyLanguageOption = $("#ember44"),
                            certificateCheckBox = $x("//span[text()='С сертификатами']"),
                            freeCheckBox = $x("//span[text()='Бесплатные']"),
                            searchButton = $(".search-form__submit");


    public MainPage checkSearchInput(){
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
