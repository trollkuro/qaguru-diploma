package tests;

import components.Header;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@DisplayName("Header")
public class HeaderTests extends TestBase {

    private Header header = new Header();


    static Stream<Arguments> availableLanguges(){
        return Stream.of(
                Arguments.of(List.of("Беларуская", "Deutsch", "English", "Español",
                        "Português", "Русский", "Українська", "简体中文"
                ))
        );
    }
    @MethodSource("availableLanguges")
    @Tag("Header")
    @ParameterizedTest
    @Feature("SystemLanguage")
    @DisplayName("Check list of available languages in the language selector")
    void availableLanguagesTest(List<String> expectedLanguages){
        step("Open main page", () -> {
            open(baseUrl);
        });
        step("Click on the language selector", () -> {
            header.clickOnLanguageDropDown();
        });
        step("Verify available languages", () -> {
            header.checkAvailableLanguages(expectedLanguages);
        });
    }

}
