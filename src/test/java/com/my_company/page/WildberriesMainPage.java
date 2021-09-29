package com.my_company.page;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WildberriesMainPage {
    public WildberriesMainPage openMainPage() {
        Configuration.startMaximized = true;
        open("https://www.wildberries.kz/");
        return this;
    }

    public WildberriesMainPage choseTab(String tabName) {
        $(".j-menu-burger-btn").click();
        $(".j-menu-active").$(byText(tabName)).click();
        return this;
    }

    public WildberriesMainPage checkTitleName(String tabName) {
        $(".catalog-title").shouldHave(text(tabName));
        return this;
    }

    public WildberriesMainPage clickItemWithNumber(int number) {
        $(".j-menu-burger-btn").click();
        $(".menu-burger__main-list-item--subcategory", number).click();
        return this;
    }
}
