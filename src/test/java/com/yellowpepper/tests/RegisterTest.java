package com.yellowpepper.tests;

import com.yellowpepper.components.RegisterComponent;
import com.yellowpepper.control.BaseTest;
import org.junit.Test;
import org.testng.Assert;

public class RegisterTest extends BaseTest{

    RegisterComponent register = new RegisterComponent();
    String name = "Nayvir Zerpa";
    String username = "nayvzve";
    String password = "123456";
    String newUsername = register.generateRandomUsername(username);

    @Test
    public void registerSuccessTest() {
        register.fullLogin(name, newUsername, password);
        Assert.assertTrue(register.successRegisterMessage());
    }

    @Test
    public void registerWithExistentUsernameTest() {
        register.fullLogin(name, username, password);
        Assert.assertTrue(register.errorMessageForExistentUser());
    }

    @Test
    public void registerWithEmptyUsernameTest() {
        register.fullLogin(name, "", password);
        Assert.assertTrue(register.errorMessageForEmptyUsername());
    }

    @Test
    public void registerWithEmptyPasswordTest() {
        register.fullLogin(name, username, "");
        Assert.assertTrue(register.errorMessageForEmptyPassword());
    }
}
