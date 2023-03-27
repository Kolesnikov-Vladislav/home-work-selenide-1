import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
        @Step("Кликаем на 'Поиск'")
        public void openPage(){
            open("https://github.com");
        }
        @Step("Вводим наименование репозитория и производим поиск")
        public void inputNameRepository(){
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("eroshenkoam/allure-example");
            $(".header-search-input").submit();
        }
        @Step("Ищем репозиторий в списке")
        public void searchRepositoryInList(){
            $(linkText("eroshenkoam/allure-example")).click();
        }
        @Step("Ищем на странице репозитория раздел 'Issue' и переходим в него")
        public void searchAnPageIssue(){
            $("#issues-tab").click();
        }
        @Step("Проверяем Issue с наименование на наличие в разделе Issue")
        public void checkIssueTab(){
            $("div[aria-label=\"Issues\"]").shouldBe(Condition.text("issue_to_test_allure_report")).shouldBe(Condition.visible);
        }

}
