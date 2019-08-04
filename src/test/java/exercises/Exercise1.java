package exercises;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Exercise1 {

    @Before
    public void openPage() {
        open("http://the-internet.herokuapp.com/challenging_dom");
    }

    @Test
    public void deleteRows() {
        List<String> targetText = Arrays.asList(
                "Apeirian4",
                "Definiebas6",
                "Consequuntur1",
                "Phaedrum9"
        );

        for (String text : targetText) {
            deleteRowContainingText(text);
        }
    }

    public void deleteRowContainingText(String which) {
        SelenideElement tableRow = $x(
                "//table/tbody/tr[td[contains(text(),'" + which + "')]]"
        );

        if (tableRow.exists()) {
            tableRow.$x("//a[text()='delete']").click();
        }
    }
}
