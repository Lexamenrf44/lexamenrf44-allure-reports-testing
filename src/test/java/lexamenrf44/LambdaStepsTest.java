package lexamenrf44;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepsTest {

    private final static String USERNAME = "eroshenkoam";
    private final static String REPOSITORY = "allure-example";
    private final static String TAB = "Issues";
    private final static int NUMBER = 68;


    @Test
    public void issueSearchTest() {

        step("Открыть главную страницу github", () -> {

            open("https://github.com");

        });

        step("Произвести поиск репозитория " + REPOSITORY + " пользователя " + USERNAME, () -> {

            $(".header-search-input").click();
            $(".header-search-input").sendKeys(USERNAME + "/" + REPOSITORY);
            $(".header-search-input").submit();

        });

        step("Перейти в репозитория " + REPOSITORY + " пользователя " + USERNAME, () -> {

            $(linkText(USERNAME + "/" + REPOSITORY)).click();

        });

        step("Перейти на вкладку " + TAB + " в репозитории " + REPOSITORY + " пользователя " + USERNAME, () -> {

            $(partialLinkText(TAB)).click();

        });

        step("Установить, что на вкладке " + TAB + " в репозитории " + REPOSITORY + " пользователя " + USERNAME + " присутствует Issue c номером " + NUMBER, () -> {

            $(withText("#" + NUMBER)).should(Condition.visible);

        });
    }

}
