package components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class Header {

    private SelenideElement languageDropDown = $(".language-selector"),
                            loginButton = $(".navbar__auth_login"),
                            registrationButton = $(".navbar__auth_reg ");
    private ElementsCollection listOfLanguages = $$(".menu_right li");


    public Header clickOnLanguageDropDown(){
        languageDropDown.click();
        return this;
    }

    public Header checkAvailableLanguages(List<String> Languages){
        listOfLanguages.shouldHave(CollectionCondition.texts(Languages));
        return this;
    }

    public AuthModalWindow clickOnLoginButton(){
        loginButton.click();
        return page(AuthModalWindow.class);
    }

    public AuthModalWindow clickOnRegistrationButton(){
        registrationButton.click();
        return page(AuthModalWindow.class);
    }
}
