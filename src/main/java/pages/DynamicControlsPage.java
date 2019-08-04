package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DynamicControlsPage extends Page {

    // Elements
    private SelenideElement checkbox =
            $("#checkbox");
    private SelenideElement checkboxToggle =
            $("#checkbox-example button");
    private SelenideElement textField =
            $("#input-example > input");
    private SelenideElement textFieldToggle =
            $("#input-example > button");

    public DynamicControlsPage visit() {
        open("http://the-internet.herokuapp.com/dynamic_controls");
        return this;
    }

    // Controls
    public DynamicControlsPage confirmCheckbox() {
        this.checkbox.waitUntil(exist, TIMEOUT);
        return this;
    }

    public DynamicControlsPage confirmNoCheckbox() {
        this.checkbox.waitUntil(not(exist), TIMEOUT);
        return this;
    }

    public DynamicControlsPage toggleCheckbox() {
        this.checkboxToggle.click();
        return this;
    }

    public DynamicControlsPage confirmTextFieldEnabled() {
        this.textField.waitUntil(enabled, TIMEOUT);
        return this;
    }

    public DynamicControlsPage confirmTextFieldDisabled() {
        this.textField.waitUntil(disabled, TIMEOUT);
        return this;
    }

    public DynamicControlsPage toggleTextField() {
        this.textFieldToggle.click();
        return this;
    }

}
