package componentipageobject;

import static com.codeborne.selenide.Selenide.*;

public class Page {

    public void openAutoTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    public void  firstName(String value) {
        $("#firstName").setValue(value);
    }

    public void lastName(String value) {
        $("#lastName").setValue(value);
    }

    public void userEmail(String value) {
        $("#userEmail").setValue(value);
    }

    public void genderRadioButton(String value) {
        $("#gender-radio-3").parent().click();
    }

    public void userNumber(String value) {
        $("#userNumber").setValue(value);
    }
}
