package homeWorkAllure;

import org.junit.jupiter.api.Test;

public class RunStepsTest {
    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final int NUMBER = 60;

    @Test
    public void StepsTestRun() {
        StepsTest steps = new StepsTest();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(NUMBER);
    }
}
