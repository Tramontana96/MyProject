package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutoTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
       // Configuration.holdBrowserOpen = true;

    }

    @Test
    void formTextBox() {
            //открываем страницу формы
            open("https://demoqa.com/text-box");
            //заполняем поле имени
            $("#userName").setValue("Mihail");
            //заполняем поле почты
            $("#userEmail").setValue("xelysqgbhju@gmail.com");
            //пишем текущий адрес
            $("#currentAddress").setValue("Калинина 62");
            //пишем постоянный адрес
            $("#permanentAddress").setValue("Калинина 62");
            //отправка результата
            $("#submit").click();
            //проверка результатов
            $("#output").shouldHave(text("Mihail"),
                text("xelysqgbhju@gmail.com"),
                text("Калинина 62"),
                text("Калинина 62"));
    }

    @Test
    void formCheckBox() {
        //открываем страницу формы
        open("https://demoqa.com/checkbox");
        //плюсом раскрыть всё дерево
        $(".rct-option").click();
        //выбрать папку Commands
        $(".rct-title").click();
        //выбрать папку React
        $(byText("React")).click();
        //выбрать папку General
        $(".rct-title").click();
        //проверка результатов
        $("#result").shouldHave(text("commands"),
                text("react"),
                text("general"));
    }

    @Test
    void formRadioButton() {
        //открываем страницу формы
        open("https://demoqa.com/radio-button");
        //выбираем вариант "Yes"
        $("#yesRadio").parent().click();
        //проверка результатов
        $(".mt-3").parent().shouldHave(text("Yes")); // не получается найти атрибут для проверки
    }

    @Test
    void formPracticeForm() {
        //открываем страницу формы
        open("https://demoqa.com/automation-practice-form");
        //имя
        $("#firstName").setValue("Mihailo");
        //фамилия
        $("#lastName").setValue("Ivanov");
        //электронная почта
        $("#userEmail").setValue("xelysqgbhju@gmail.com");
        //пол
        $("#gender-radio-3").parent().click();
        //номер телефона
        $("#userNumber").setValue("1234567899");
        //день рождения

        //предмет
        //увлечение(хобби)
        //файл(картинка)
        //текущий адрес
        //штат
        //город


    }
}


