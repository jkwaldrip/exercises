package exercises;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.DynamicControlsPage;

public class ExerciseTwo {

    private DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

    @Before
    public void openPage() {
        this.dynamicControlsPage.visit();
    }

    @After
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

    @Test
    public void checkboxInitiallyExists() {
        this.dynamicControlsPage.confirmCheckbox();
    }

    @Test
    public void removeCheckbox() {
        this.dynamicControlsPage
                .confirmCheckbox()
                .toggleCheckbox()
                .confirmNoCheckbox();
    }

    @Test
    public void replaceCheckbox() {
        this.dynamicControlsPage
                .confirmCheckbox()
                .toggleCheckbox()
                .confirmNoCheckbox()
                .toggleCheckbox()
                .confirmCheckbox();
    }

    @Test
    public void textFieldInitiallyDisabled() {
        this.dynamicControlsPage.confirmTextFieldDisabled();
    }

    @Test
    public void enableTextField() {
        this.dynamicControlsPage
                .confirmTextFieldDisabled()
                .toggleTextField()
                .confirmTextFieldEnabled();
    }

    @Test
    public void disableTextField() {
        this.dynamicControlsPage
                .confirmTextFieldDisabled()
                .toggleTextField()
                .confirmTextFieldEnabled()
                .toggleTextField()
                .confirmTextFieldDisabled();
    }
}
