package homeWorkAllure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepsTest {

    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final int NUMBER = 51;

    @Test
    @Owner("christinchcik")
    @Feature("Issues")
    @DisplayName("Проверка Issue для авторизованного пользователя")
    @Link(value = "GitHub", url = "https://github.com")
    public void lambdaStepTest() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем наличие Issue с номером " + NUMBER, () -> {
            $(withText("#" + NUMBER)).should(Condition.visible);
        });
    }
}
