package com.yellowpepper.components;

import com.yellowpepper.control.BaseTest;
import com.yellowpepper.control.CustomCommands;

import static org.apache.commons.lang3.RandomStringUtils.*;

public class RegisterComponent extends BaseTest{

    public CustomCommands commands = new CustomCommands();
    private static final String REGISTER_BUTTON = "com.yellowpepper.automation_test:id/registerButton";
    private static final String NAME_TEXT_FIELD = "com.yellowpepper.automation_test:id/nameTextField";
    private static final String USERNAME_TEXT_FIELD = "com.yellowpepper.automation_test:id/usernameTextField";
    private static final String PASSWORD_TEXT_FIELD = "com.yellowpepper.automation_test:id/passwordTextField";
    private static final String REGISTER_MESSAGE = "android:id/message"; 
    private static final String SUCCESS_USER_REGISTER_TEXT = "Register successful, please login";
    private static final String USER_EXIST_ERROR_TEXT = "Account already exists for this username.";
    private static final String REGISTER_USERNAME_ERROR_TEXT = "java.lang.IllegalArgumentException: Username cannot " +
            "be missing or blank";
    private static final String REGISTER_PASSWORD_ERROR_TEXT = "java.lang.IllegalArgumentException: Password cannot " +
            "be missing or blank";

    private void registerButtonClick() {
        commands.waitForLoad(REGISTER_BUTTON, CustomCommands.FindersType.ID);
        driver.findElementById(REGISTER_BUTTON).click();
    }

    private void fillTextFields(String name, String username, String password) {
        commands.setValueInField(NAME_TEXT_FIELD, name);
        commands.setValueInField(USERNAME_TEXT_FIELD, username);
        driver.hideKeyboard();
        commands.setValueInField(PASSWORD_TEXT_FIELD, password);
        driver.hideKeyboard();
    }

    public void fullLogin(String name, String username, String password) {
        registerButtonClick();
        fillTextFields(name, username, password);
        registerButtonClick();
    }

    private boolean messageValidateText(String registerText) {
        commands.waitForLoad(REGISTER_MESSAGE, CustomCommands.FindersType.ID);
        String elementText =  driver.findElementById(REGISTER_MESSAGE).getText();
        return registerText.equals(elementText);
    }

    public boolean successRegisterMessage() {
        return messageValidateText(SUCCESS_USER_REGISTER_TEXT);
    }

    public boolean errorMessageForExistentUser() {
        return messageValidateText(USER_EXIST_ERROR_TEXT);
    }

    public boolean errorMessageForEmptyUsername() {
        return messageValidateText(REGISTER_USERNAME_ERROR_TEXT);
    }

    public boolean errorMessageForEmptyPassword() {
        return messageValidateText(REGISTER_PASSWORD_ERROR_TEXT);
    }

    public String generateRandomUsername(String username) {
        return username + randomNumeric(5);
    }

}
