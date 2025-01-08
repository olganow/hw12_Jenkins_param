package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableComponent {
    private SelenideElement
            header = $(".table");

    public void checkTableResult(String key, String value) {
        header.$(byText(key)).sibling(0).shouldHave(text(value));
    }
}
