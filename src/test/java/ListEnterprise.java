import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class ListEnterprise {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void successfulListEnterprise(){
        open("https://github.com/");
        $("div.header-menu-wrapper").$(byText("Solutions")).hover();
        $(withTagAndText("a", "Enterprise")).click();
        $("div.application-main").shouldHave(Condition.text("Build like the best"));

    }
}
