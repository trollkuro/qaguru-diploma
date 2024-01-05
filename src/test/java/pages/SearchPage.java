package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private SelenideElement freeCourseLabel = $(".format-price_free"),
                            paidCourseLabel = $(".format-price [data-type=currency]"),
                            courseCardTitle = $(".course-card__title");


    public SearchPage courseIsFree(){
        freeCourseLabel.shouldBe(visible);
        return this;
    }

    public SearchPage courseWithPayment(){
        paidCourseLabel.shouldBe(visible);
        return this;
    }

    public SearchPage checkCourseCardTitle(String title){
        courseCardTitle.shouldHave(text(title));
        return this;
    }
}
