package demoqa;

import com.codeborne.selenide.Configuration;
import componentipageobject.Page;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutoTestPageObject {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void formPracticeForm() {

        //открываем страницу формы
        new Page().openAutoTest();
        //имя
        new Page().firstName();
        $("#firstName").setValue("Mihailo");
        //фамилия
        new Page().lastName();
        $("#lastName").setValue("Ivanov");
        //электронная почта
        new Page().lastName();
        $("#userEmail").setValue("xelysqgbhju@gmail.com");
        //пол
        $("#gender-radio-3").parent().click();
        //номер телефона
        $("#userNumber").setValue("1234567899");
        //день рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("May")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1996")).scrollTo().click();
        $(byText("3")).click();
        //предмет
        $("#subjectsInput").setValue("Ar").pressEnter();
        //увлечения(хобби)
        $("#hobbies-checkbox-1").parent().click();
        $("#hobbies-checkbox-2").parent().click();
        $("#hobbies-checkbox-3").parent().click();
        //файл(картинка)
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.jpg"));
        //текущий адрес
        $("#currentAddress").setValue("Калинина 74");
        //штат
        $("#react-select-3-input").setValue("NCR").pressEnter();
        //город
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        //отправка результата
        $("#submit").click();
        //проверка результата
        $(".modal-content").shouldHave(text("Thanks for submitting the form"),
                text("Mihailo Ivanov"),
                text("xelysqgbhju@gmail.com"),
                text("Other"),
                text("1234567899"),
                text("03 May,1996"),
                text("Arts"),
                text("Sports, Reading, Music"),
                text("1.jpg"),
                text("Калинина 74"),
                text("NCR Delhi"));
    }
}


