import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void successfulDragAndDrop(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("div#column-a").dragAndDropTo($("div#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        sleep(5000);
    }
}
