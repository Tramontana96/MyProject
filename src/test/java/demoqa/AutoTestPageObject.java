package demoqa;

import com.codeborne.selenide.Configuration;
import componentipageobject.Calendar;
import componentipageobject.Page;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
                day = "3",
                month = "May",
                year = "1996",
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
        new Calendar().dateOfBirthInput(day, month, year); //не получилось с календарём
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
        new Page().checkResult("Student Name", firstName + " " + lastName);
        new Page().checkResult("Student Email", userEmail);
        new Page().checkResult("Gender", "Other");
        new Page().checkResult("Mobile", userNumber);
        new Page().checkResult("Date of Birth");
        new Page().checkResult("Subjects", predmet);
        new Page().checkResult("Hobbies", "Sports, Reading, Music");
        new Page().checkResult("Picture", uploadPicture);
        new Page().checkResult("Address", currentAddress);
        new Page().checkResult("State and City", state + " " + city);
    }
}


