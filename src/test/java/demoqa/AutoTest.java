package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.name;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutoTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }


    @Test
    void formTest() {
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
            //проверка результата
            $("#output").shouldHave(text("Mihail"),
                text("xelysqgbhju@gmail.com"),
                text("Калинина 62"),
                text("Калинина 62"));
    }
}