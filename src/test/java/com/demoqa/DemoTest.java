package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class DemoTest {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void simpleTest(){
        open("/automation-practice-form");
        $("#firstName").setValue("Egor");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("Egor@mail.ru");
        $("#userNumber").setValue("1234567890");
        $("#currentAddress").setValue("123 123");
        $("#genterWrapper").$(byText("Male")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--012:not(.react-datepicker__day--selected").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/X4d_bbnX60E (1).jpg");
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Egor Petrov"),
                text("Egor@mail.ru"),
                text("1234567890"),
                text("male"),
                text("12 April,1995"),
                text("Chemistry"),
                text("Sports"),
                text("X4d_bbnX60E (1).jpg"),
                text("123 123"),
                text("Haryana Karnal"));
    }


}
