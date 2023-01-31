package componentipageobject;

import static com.codeborne.selenide.Selenide.*;

public class Page {

    public void openAutoTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    public void  firstName() {
        $("#firstName").setValue("Mihailo");
    }

    public void lastName() {
        $("#lastName").setValue("Ivanov");
    }

    public void userEmail() {
        $("#userEmail").setValue("xelysqgbhju@gmail.com");
    }

    public void genderRadioButton() {
        $("#gender-radio-3").parent().click();
    }

    public void userNumber() {
        $("#userNumber").setValue("1234567899");
    }
}
