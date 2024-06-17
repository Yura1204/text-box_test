package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQATextBoxPage {
    private WebDriver driver;

    // Локаторы для элементов формы
    private By userNameField = By.id("userName");
    private By userEmailField = By.id("userEmail");
    private By currentAddressField = By.id("currentAddress");
    private By permanentAddressField = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By outputDiv = By.id("output");

    // Конструктор
    public DemoQATextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для заполнения поля имени пользователя
    public void setUserName(String name) {
        driver.findElement(userNameField).sendKeys(name);
    }

    // Метод для заполнения поля электронной почты пользователя
    public void setUserEmail(String email) {
        driver.findElement(userEmailField).sendKeys(email);
    }

    // Метод для заполнения поля текущего адреса
    public void setCurrentAddress(String address) {
        driver.findElement(currentAddressField).sendKeys(address);
    }

    // Метод для заполнения поля постоянного адреса
    public void setPermanentAddress(String address) {
        driver.findElement(permanentAddressField).sendKeys(address);
    }

    // Метод для нажатия кнопки отправки
    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    // Метод для получения текста вывода
    public String getOutputText() {
        return driver.findElement(outputDiv).getText();
    }
}

