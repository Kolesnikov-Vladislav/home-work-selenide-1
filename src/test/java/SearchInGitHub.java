import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchInGitHub {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    //Configuration.browserSize = "1920*1080";
    @Test
    void successfulSearchInGithub(){
        open("https://github.com/");
        $("[placeholder='Search GitHub']").click();
        $("[placeholder='Search GitHub']").setValue("Selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(byText("SoftAssertions")).shouldBe(Condition.visible).click();
        $(".markdown-body").shouldHave(Condition.text("Using JUnit5 extend test class"));
    }

}
