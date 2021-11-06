package com.github.jjfhj;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void checkingJUnit5CodeOnTheSoftAssertionsPage() {
        //Открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        //Проверить наличие страницы SoftAssertions в списке страниц (Pages) и открыть эту страницу
        $$("#wiki-body a").findBy(text("Soft assertions")).click();
        //Проверить наличие примера кода для JUnit5 на странице SoftAssertions
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
