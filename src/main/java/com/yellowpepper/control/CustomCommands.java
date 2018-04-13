package com.yellowpepper.control;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomCommands extends BaseTest{


    public void sleep(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ignored) {
        }
    }

    public void waitForLoad(String value, FindersType type) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        switch (type) {
            case CLASSNAME:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
                break;
            case ID:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
                break;
            case XPATH:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
                break;
        }
    }

    public enum FindersType {
        ID, CLASSNAME, XPATH
    }

    public void setValueInField(String id, String value) {
        waitForLoad(id, CustomCommands.FindersType.ID);
        driver.findElementById(id).click();
        driver.findElementById(id).setValue(value);
    }

}
