package homeWorkAllure;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RunStepsTest {
    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final int NUMBER = 60;

    @Test
    @Owner("christinchcik")
    @Feature("Issues")
    @DisplayName("Проверка Issue для авторизованного пользователя")
    @Link(value = "GitHub", url = "https://github.com")
    public void StepsTestRun() {
        StepsTest steps = new StepsTest();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(NUMBER);
    }
}
