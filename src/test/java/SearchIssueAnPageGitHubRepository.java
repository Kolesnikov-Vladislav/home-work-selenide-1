import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
public class SearchIssueAnPageGitHubRepository {
    @Test
    public void searchIssueAnWebSite(){
    SelenideLogger.addListener("allure", new AllureSelenide());
    open("https://github.com");
    $(".header-search-input").click();
    $(".header-search-input").sendKeys("eroshenkoam/allure-example");
    $(".header-search-input").submit();
    $(linkText("eroshenkoam/allure-example")).click();
    $("#issues-tab").click();
    $("div[aria-label=\"Issues\"]").shouldBe(Condition.text("issue_to_test_allure_report")).shouldBe(Condition.visible);
            //issue_to_test_allure_report
    }

    @Test
    public void searchIssueWitchLambda(){
    step("Открываем главную страницу GitHub", () -> {
        open("https://github.com");
    });
    step("Кликаем на 'Поиск'", () -> {
        $(".header-search-input").click();
        });
    step("Вводим наименование репозитория", () -> {
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        });
    step("Подтверждаем поиск/Производим поиск", () -> {
        $(".header-search-input").submit();
        });
    step("Ищем репозиторий в списке результата поиска", () -> {
        $(linkText("eroshenkoam/allure-example")).click();
        });
    step("Ищем на странице репозитория раздел 'Issue' и переходим в него", () -> {
        $("#issues-tab").click();
        });
    step("Проверяем Issue с наименование на наличие в разделе Issue", () -> {
        $("div[aria-label=\"Issues\"]").shouldBe(Condition.text("issue_to_test_allure_report")).shouldBe(Condition.visible);
        });
    }
    @Test
    public void searchIssueWitchAnnotation(){
        WebSteps webSteps = new WebSteps();
        webSteps.openPage();
        webSteps.inputNameRepository();
        webSteps.searchRepositoryInList();
        webSteps.searchAnPageIssue();
        webSteps.checkIssueTab();
    }

}
