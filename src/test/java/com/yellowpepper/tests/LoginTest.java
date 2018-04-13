package com.yellowpepper.tests;

import com.yellowpepper.components.LoginComponent;
import com.yellowpepper.control.BaseTest;
import org.junit.Test;
import org.testng.Assert;

public class LoginTest extends BaseTest{

    LoginComponent login = new LoginComponent();
    String name = "Nayvir Zerpa";
    String username = "nayvzve";
    String password = "123456";
    String wrongUsername = "sdfsdfsdf";
    String wrongPassword = "1sdf";

    @Test
    public void loginTest() {
        login.fullLogin(username, password);
        Assert.assertTrue(login.welcomeLoginMessage(name));
    }

    @Test
    public void loginWithWrongUsernameTest() {
        login.fullLogin(wrongUsername, password);
        Assert.assertTrue(login.wrongValuesMessage());
    }

    @Test
    public void loginWithWrongPasswordTest() {
        login.fullLogin(username, wrongPassword);
        Assert.assertTrue(login.wrongValuesMessage());
    }

    @Test
    public void loginWithEmptyUsernameTest() {
        login.fullLogin("", password);
        Assert.assertTrue(login.emptyUsernameMessage());
    }

    @Test
    public void loginWithEmptyPasswordTest() {
        login.fullLogin(username, "");
        Assert.assertTrue(login.emptyPasswordMessage());
    }
}

