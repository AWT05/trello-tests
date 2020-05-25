package org.fundacionjala.trello.pages.forms;

import org.fundacionjala.trello.pages.trello.PageObject;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public abstract class FormPage<T> extends PageObject {
    protected final Map<FormFieldsEnum, IFillerField> formFields;

    public FormPage(final WebDriver driver) {
        super(driver);
        formFields = getFields();
    }

    protected abstract Map<FormFieldsEnum, IFillerField> getFields();

    /**
     * Fills all fields passed as parameters.
     *
     * @param data contains the name of the values and the fields ​​to be filled.
     */
    public void fillForm(final Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            try {
                FormFieldsEnum fieldKey = FormFieldsEnum.valueOf(entry.getKey().toUpperCase());
                IFillerField field = formFields.get(fieldKey);
                field.fill(entry.getValue());
            } catch (IllegalArgumentException ex) {
                // To do throw a custom exception
                String message = String.format("Error: <%s> is not a valid field. ", entry.getKey());
                throw new IllegalArgumentException(message.concat(ex.getMessage()));
            }
        }
    }

    public void clearForm() {
        // To do
    }

    public abstract T submit();
}
