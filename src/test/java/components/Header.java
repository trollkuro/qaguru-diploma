package components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Header {

    private SelenideElement languageDropDown = $(".language-selector");
    private ElementsCollection listOfLanguages = $$(".menu_right li");

    public Header clickOnLanguageDropDown(){
        languageDropDown.click();
        return this;
    }

    public Header checkAvailableLanguages(List<String> Languages){
        listOfLanguages.shouldHave(CollectionCondition.texts(Languages));
        return this;
    }
}
