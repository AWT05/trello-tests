package org.fundacionjala.core.ui.pages.forms;

import org.fundacionjala.core.ui.pages.WebObject;
import org.openqa.selenium.WebDriver;

import java.util.Map;

/**
 * Dynamic form.
 *
 * @param <T> Page object that appears after submitting the form.
 */
public abstract class FormPage<T> extends WebObject {

    protected final Map<FormFieldsEnum, IFillerField> formFields;

    public FormPage(final WebDriver driver) {
        super(driver);
        formFields = getFields();
    }

    /**
     * Provides all the fields that the form have.
     *
     * @return fields to be filled.
     */
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
                String message = String.format("Error: <%s> is not a valid field. ", entry.getKey());
                throw new IllegalArgumentException(message.concat(ex.getMessage()));
            }
        }
    }

    /**
     * Submits all information in the form.
     *
     * @return next page object.
     */
    public abstract T submit();
}
