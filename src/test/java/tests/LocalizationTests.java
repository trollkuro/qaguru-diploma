package tests;

import pages.MainPage;
import pages.components.Header;
import data.Languages;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@DisplayName("Localisation")
public class LocalizationTests extends BaseTest {

    private MainPage mainPage = new MainPage();

    private static final List<String> LANGUAGES = List.of("Беларуская", "Deutsch", "English", "Español",
            "Português", "Русский", "Українська", "简体中文");
    private static final List<String> BE_BUTTONS = List.of("Увайсці", "Рэгістрацыя");
    private static final List<String> DE_BUTTONS = List.of("Einloggen", "Anmelden");
    private static final List<String> EN_BUTTONS = List.of("Log in", "Register");
    private static final List<String> ES_BUTTONS = List.of("Iniciar sesión", "Registro");
    private static final List<String> PT_BUTTONS = List.of("Entrar", "Registrar");
    private static final List<String> RU_BUTTONS = List.of("Войти", "Регистрация");
    private static final List<String> UK_BUTTONS = List.of("Увійти", "Реєстрація");
    private static final List<String> ZH_BUTTONS = List.of("登录", "寄存器");


    static Stream<Arguments> availableLanguages(){
        return Stream.of(Arguments.of(LANGUAGES));
    }
    @Tag("Translations")
    @Feature("SystemLanguage")
    @Owner("kegorova")
    @MethodSource("availableLanguages")
    @ParameterizedTest
    @DisplayName("Check list of available languages in the language selector")
    void availableLanguagesTest(List<String> expectedLanguages){
        step("Open main page", () -> {
            mainPage.openPage();
        });
        step("Click on the language selector", () -> {
            mainPage.header.clickOnLanguageDropDown();
        });
        step("Verify available languages", () -> {
            mainPage.header.checkAvailableLanguages(expectedLanguages);
        });
    }

    static Stream<Arguments> navigationLinksTranslationTest() {
        return Stream.of(
                Arguments.of(Languages.Беларуская, BE_BUTTONS),
                Arguments.of(Languages.Deutsch, DE_BUTTONS),
                Arguments.of(Languages.English, EN_BUTTONS),
                Arguments.of(Languages.Español, ES_BUTTONS),
                Arguments.of(Languages.Português, PT_BUTTONS),
                Arguments.of(Languages.Русский, RU_BUTTONS),
                Arguments.of(Languages.Українська, UK_BUTTONS),
                Arguments.of(Languages.简体中文, ZH_BUTTONS)
        );
    }

    @Tag("Translations")
    @Feature("SystemLanguage")
    @Owner("kegorova")
    @MethodSource("navigationLinksTranslationTest")
    @ParameterizedTest
    @DisplayName("Check auth buttons translations according to selected language")
    void navigationLinksTranslationTest(Languages languages, List<String> expectedAuthButtons) {
        step("Open main page", () -> {
            mainPage.openPage();
        });
        step("Click on the language selector", () -> {
            mainPage.header.clickOnLanguageDropDown();
        });
        step("Select language", () -> {
            mainPage.header.selectLanguage(languages);
        });
        step("Verify translation of auth buttons in the header", () -> {
            mainPage.header.checkAuthButtonsTranslations(expectedAuthButtons);
        });
    }
}
