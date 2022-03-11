package by.it_academy.homework6.pageobject;

import by.it_academy.homework6.framework.AbstractPage;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class Header extends AbstractPage {
    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTERN =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";

    public void clickOnMainNavigationLink(String link) {
        $x(String.format(MAIN_NAVIGATION_LINK_XPATH_PATTERN, link))
                .shouldBe(Condition.visible, ofSeconds(45))
                .click();
    }

}