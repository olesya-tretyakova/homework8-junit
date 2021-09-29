package com.my_company;

import com.my_company.domain.WildberriesMenuItem;
import com.my_company.page.WildberriesMainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class WildberriesParametrizedTest {
    private WildberriesMainPage wbMainPage = new WildberriesMainPage();

    static Stream<Arguments> testWithMethodSource() {
        return Stream.of(
                Arguments.of(
                        11, "Красота"
                ),
                Arguments.of(
                        12, "Игрушки"
                ),
                Arguments.of(
                        15, "Канцтовары"
                )
        );
    }

    @CsvSource(value = {
            "Женщинам",
            "Мужчинам",
            "Детям"
    })

    @ParameterizedTest(name = "Проверка названия вкладки {0}")
    void wildberriesTabNameTestWithCsvSource(String tabName) {

        wbMainPage.openMainPage()
                .choseTab(tabName)
                .checkTitleName(tabName);
    }

    @EnumSource(value = WildberriesMenuItem.class)
    @ParameterizedTest()
    @DisplayName("Open all tabs using enum source")
    void wildberriesTabNameTestWithEnumSource(WildberriesMenuItem menuItem) {
        wbMainPage.openMainPage()
                .choseTab(menuItem.getDescription())
                .checkTitleName(menuItem.getDescription());
    }

    @MethodSource("testWithMethodSource")
    @ParameterizedTest()
    @DisplayName("Open all tabs using item index and method source")
    void wildberriesTabNameTestWithMethodSource(int number, String title) {
        wbMainPage.openMainPage()
                .clickItemWithNumber(number)
                .checkTitleName(title);
    }
}
