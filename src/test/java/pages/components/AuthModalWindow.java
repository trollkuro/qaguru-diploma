package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthModalWindow {

    private SelenideElement modalWindow = $(".modal-dialog-inner"),
                            closeModalIcon = $(".modal-dialog-top__close"),
                            loginButton = $("#login_form .sign-form__btn"),
                            registerButton = $("#registration_form .sign-form__btn"),
                            fullnameInput = $("#id_registration_full-name"),
                            emailInput = $("#id_login_email"),
                            registrationEmailInput = $("#id_registration_email"),
                            registrationPasswordInput = $("#id_registration_password"),
                            agreeCheckbox = $(".auth-disclaimer__form"),
                            passwordInput = $("#id_login_password"),
                            forgotPasswordLink = $(".sign-form__sub"),
                            socialTitle = $(".social-title"),
                            vkButton = $(".btn-vk"),
                            googleButton = $(".btn-google"),
                            githubButton = $(".btn-github");

    public AuthModalWindow modalWindowWithLoginIsDisplayed(){
        modalWindow.shouldBe(visible);
        emailInput.shouldBe(visible);
        passwordInput.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        socialTitle.shouldBe(visible);
        vkButton.shouldBe(visible);
        googleButton.shouldBe(visible);
        githubButton.shouldBe(visible);
        return this;
    }

    public AuthModalWindow modalWindowWithRegistrationIsDisplayed(){
        modalWindow.shouldBe(visible);
        fullnameInput.shouldBe(visible);
        registrationEmailInput.shouldBe(visible);
        registrationPasswordInput.shouldBe(visible);
        registerButton.shouldBe(visible);
        agreeCheckbox.shouldBe(visible);
        socialTitle.shouldBe(visible);
        vkButton.shouldBe(visible);
        googleButton.shouldBe(visible);
        githubButton.shouldBe(visible);
        return this;
    }

    public AuthModalWindow closeModalWindow(){
        closeModalIcon.click();
        return this;
    }

    public AuthModalWindow modalWindowIsClosed(){
        modalWindow.shouldBe(hidden);
        return this;
    }

}