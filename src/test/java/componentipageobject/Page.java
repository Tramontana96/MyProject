package componentipageobject;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class Page {

    public ModalResults modalResults = new ModalResults();
    public Calendar calendar = new Calendar();

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

    public void genderRadioButton() {
        $("#gender-radio-3").parent().click();
    }

    public void userNumber(String value) {
        $("#userNumber").setValue(value);
    }

    public void predmet(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
    }

    public void hobbies() {
        $("#hobbies-checkbox-1").parent().click();
        $("#hobbies-checkbox-2").parent().click();
        $("#hobbies-checkbox-3").parent().click();
    }

    public void uploadPicture(String value) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/"+value));
    }

    public void currentAddress(String value) {
        $("#currentAddress").setValue(value);
    }

    public void state(String value) {
        $("#react-select-3-input").setValue(value).pressEnter();
    }

    public void city(String value) {
        $("#react-select-4-input").setValue(value).pressEnter();
    }

    public void results() {
        $("#submit").click();
    }

    public Calendar dateOfBirthInput (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        Calendar.setDate(day, month, year);
    }

    public ModalResults checkResult(String key, String value) {
        modalResults.checkResult(key, value);
    }
}

