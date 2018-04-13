package com.yellowpepper.components;

import com.yellowpepper.control.BaseTest;
import com.yellowpepper.control.CustomCommands;

public class LoginComponent extends BaseTest{

    public CustomCommands commands = new CustomCommands();
    private static final String LOGIN_BUTTON = "com.yellowpepper.automation_test:id/loginButton";
    private static final String USERNAME_FIELD = "com.yellowpepper.automation_test:id/usernameTextField";
    private static final String PASSWORD_FIELD = "com.yellowpepper.automation_test:id/passwordTextField";
    private static final String LOGIN_ALERT = "android:id/message";
    private static final String LOGIN_ALERT_TEXT = "Welcome ";
    private static final String LOGIN_ALERT_WRONG_ERROR_TEXT = "Invalid username/password.";
    private static final String LOGIN_ALERT_EMPTY_USERNAME_TEXT = "username is required.";
    private static final String LOGIN_ALERT_EMPTY_PASSWORD_TEXT = "password is required.";

    private void clickLoginButton() {
        commands.waitForLoad(LOGIN_BUTTON, CustomCommands.FindersType.ID);
        driver.findElementById(LOGIN_BUTTON).click();
    }

    private void fillLoginFields(String username, String password) {
        commands.setValueInField(USERNAME_FIELD, username);
        commands.setValueInField(PASSWORD_FIELD, password);
        driver.hideKeyboard();
    }

    public void fullLogin(String username, String password) {
        clickLoginButton();
        fillLoginFields(username, password);
        clickLoginButton();
    }

    private boolean messageValidateText(String loginText) {
        commands.waitForLoad(LOGIN_ALERT, CustomCommands.FindersType.ID);
        String elementText =  driver.findElementById(LOGIN_ALERT).getText();
        return loginText.equals(elementText);
    }

    public boolean welcomeLoginMessage(String name) {
        return messageValidateText(LOGIN_ALERT_TEXT + name);
    }

    public boolean wrongValuesMessage() {
        return messageValidateText(LOGIN_ALERT_WRONG_ERROR_TEXT);
    }

    public boolean emptyUsernameMessage() {
        return messageValidateText(LOGIN_ALERT_EMPTY_USERNAME_TEXT);
    }

    public boolean emptyPasswordMessage() {
        return messageValidateText(LOGIN_ALERT_EMPTY_PASSWORD_TEXT);
    }
}
