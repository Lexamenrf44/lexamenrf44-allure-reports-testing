package lexamenrf44.resources;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebStepsAnnotation {

    @Step ("Открыть главную страницу github")
    public void openGithubPage() {

        open("https://github.com");

    }

    @Step ("Найти репозиторий {repository}")
    public void searchGithubRepository (String repository) {

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();

    }

    @Step ("Перейти на страницу репозитория {repository}")
    public void openRepositoryPage (String repository) {

        $(linkText(repository)).click();

    }

    @Step ("Перейти на вкладку Issues репозитория {repository}")
    public void openRepositoryIssuesTab () {

        $(partialLinkText("Issues")).click();

    }

    @Step ("Проверить issue с номером {number}")
    public void checkIssuesRepositoryIssue (int number) {

        $(withText("#" + number)).should(Condition.visible);

    }

}
