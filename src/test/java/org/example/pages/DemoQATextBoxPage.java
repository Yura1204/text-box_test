package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQATextBoxPage {
    private WebDriver driver;

    @FindBy(id = "userName")
    private WebElement userNameField;

    @FindBy(id = "userEmail")
    private WebElement userEmailField;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressField;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "output")
    private WebElement outputDiv;

    // Конструктор
    public DemoQATextBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Метод для заполнения поля имени пользователя
    public void setUserName(String name) {
        userNameField.sendKeys(name);
    }

    // Метод для заполнения поля электронной почты пользователя
    public void setUserEmail(String email) {
        userEmailField.sendKeys(email);
    }

    // Метод для заполнения поля текущего адреса
    public void setCurrentAddress(String address) {
        currentAddressField.sendKeys(address);
    }

    // Метод для заполнения поля постоянного адреса
    public void setPermanentAddress(String address) {
        permanentAddressField.sendKeys(address);
    }

    // Метод для нажатия кнопки отправки
    public void clickSubmit() {
        submitButton.click();
    }

    // Метод для получения текста вывода
    public String getOutputText() {
        return outputDiv.getText();
    }
}
