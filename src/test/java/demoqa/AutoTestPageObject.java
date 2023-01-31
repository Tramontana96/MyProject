package demoqa;

import com.codeborne.selenide.Configuration;
import componentipageobject.Calendar;
import componentipageobject.Page;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
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

        //переменные значений автотеста
        String firstName = "Mihailo",
                lastName = "Ivanov",
                userEmail = "xelysqgbhju@gmail.com",
                userNumber = "1234567899",
                predmet = "Arts",
                uploadPicture = "1.jpg",
                currentAddress = "Калинина 74",
                state = "NCR",
                city = "Delhi";

        //открываем страницу формы
        new Page().openAutoTest();
        //имя
        new Page().firstName(firstName);
        //фамилия
        new Page().lastName(lastName);
        //электронная почта
        new Page().userEmail(userEmail);
        //пол
        new Page().genderRadioButton();
        //номер телефона
        new Page().userNumber(userNumber);
        //день рождения
        new Calendar().setDate(day, month, year);
        //предмет
        new Page().predmet(predmet);
        $("#subjectsInput").setValue("Arts").pressEnter();
        //увлечения(хобби)
        new Page().hobbies();
        //файл(картинка)
        new Page().uploadPicture(uploadPicture);
        //текущий адрес
        new Page().currentAddress(currentAddress);
        //штат
        new Page().state(state);
        //город
        new Page().city(city);
        //отправка результата
        new Page().results();
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


