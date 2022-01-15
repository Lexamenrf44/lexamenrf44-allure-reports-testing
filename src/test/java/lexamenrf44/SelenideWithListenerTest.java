package lexamenrf44;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideWithListenerTest {

    @Test
    public void issueSearchTest() {
        open("https://github.com");

        $("header-search-input").click();
        $("header-search-input").sendKeys("eroshenkoam/allure-example");
        $("header-search-input").submit();

        $(linkText("eroshenkoam/allure-example")).click();
        $(partialLinkText("issues")).click();
        $(withText("68")).should(Condition.visible);

    }

}