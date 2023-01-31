package componentipageobject;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Calendar {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("month")).click();
        $(".react-datepicker__year-select").click();
        $(byText("year")).scrollTo().click();
        $(byText("day")).click();
    }
}
