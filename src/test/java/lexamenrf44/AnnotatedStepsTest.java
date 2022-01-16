package lexamenrf44;

import lexamenrf44.resources.WebStepsAnnotation;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int NUMBER = 68;


    @Test
    public void issueSearchAnnotationTest() {

        WebStepsAnnotation steps = new WebStepsAnnotation();
        steps.openGithubPage();
        steps.searchGithubRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.openRepositoryIssuesTab();
        steps.checkIssuesRepositoryIssue(NUMBER);

    }

}
