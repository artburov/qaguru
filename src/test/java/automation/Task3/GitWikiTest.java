package automation.Task3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitWikiTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void verifyGitWikiSoftAssertion() {
        open("https://github.com/");
        $(byName("q")).setValue("Selenide").pressEnter();
        $(byText("Wikis")).click();
        $("#wiki_search_results").shouldHave(text("SoftAssertions"));
        $(byTitle("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("@ExtendWith"));
    }
}
