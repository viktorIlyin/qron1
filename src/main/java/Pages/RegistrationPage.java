package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEnter;
import com.codeborne.selenide.conditions.Visible;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    private final String REGISTRATION_PAGE_URL = "https://qron-split.joytech.store/reg";
    //Локатор для поля логин
    @FindBy(how = How.CSS, using = "#login")
    private SelenideElement loginField;
    //Локатор для поля пароль
    @FindBy(how = How.CSS, using = "#password")
    private SelenideElement newPasswordField;
    //Локатор для поля введите повторно пароль
    @FindBy(how = How.CSS, using = "#repeatPassword")
    private SelenideElement repeatPasswordField;
    //Локатор для поля Имя
    @FindBy(how = How.CSS, using = "#firstName")
    private SelenideElement firstNameField;
    //Локатор для поля Фамилия
    @FindBy(how = How.CSS, using = "#lastName")
    private SelenideElement lastNameField;
    //Локатор для поля Отчество
    @FindBy(how = How.CSS, using = "#middleName")
    private SelenideElement middleNameField;
    //Локатор для поля телефон
    @FindBy(how = How.CSS, using = "#phone")
    private SelenideElement phoneField;
    //Локатор для поля email
    @FindBy(how = How.CSS, using = "#email")
    private SelenideElement emailField;
    //Локатор для поля Дата рождения
    @FindBy(how = How.CSS, using = "#dateOfBirth")
    private SelenideElement dateOfBirthField;
    //Локатор для кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "/html/body/main/div/form/button/span")
    private SelenideElement registrationButton;
    //Локатор для сообщения под полем пароль
    @FindBy(how = How.XPATH, using = "/html/body/main/div/form/div[4]/div[2]/div[1]/div/div[2]/div[1]/div")
    private SelenideElement errorPasswordMessage;
    //Локатор для сообщения под полем телефон
    @FindBy(how = How.CSS, using = "#phone_help > div")
    private SelenideElement errorPhoneMessage;
    //Локатор для оповещения
    @FindBy(how = How.CSS, using = "body > div > div > div > div > div.ant-notification-notice-description")
    private SelenideElement notificationMessage;
    //Локатор для оповещения "Ошибка авторизации"
    @FindBy(how = How.CSS, using = "body > div.ant-notification.ant-notification-top.css-yp8pcc > div > div > div > div.ant-notification-notice-description")
    private SelenideElement wrongRegistrationMessage;
    //Локатор для чек-бокса email оповещений
    @FindBy(how = How.CSS, using = "body > main > div > form > div:nth-child(6) > div > div > div > div > label")
    private SelenideElement emailRegistrationCheckBox;
    //
    @FindBy(how = How.CSS, using = "body > main > div > form > div:nth-child(7) > div > div > div > div > label")
    private SelenideElement personalAgreementCheckBox;
    //Локатор для глаза видимый/невидимый пароль
    @FindBy(how = How.CSS, using = "body > main > div > form > div.RegForm_passwordWrapper__C5wpB > div:nth-child(1) > div > div > div > div > span > span > span")
    private SelenideElement eyeVisibleInvisible;


    //Клик по глазу локатору.
    @Step("Клик по глазу видимости")
    public void clickEyeVisibleInvisible(){eyeVisibleInvisible.click();}
    //Получение введённого пароля из поля пароль
    @Step("Получение значения из поля password")
    public String getPasswordFromPasswordField(){
        newPasswordField.shouldBe(visible);
        return newPasswordField.getValue();
    }
    @Step("Кнопка регистрации существует")
    public boolean registrationButtonIsDisplayed() {
        return registrationButton.exists();
    }
    @Step("Клик по чек-боксу Email")
    public void clickEmailRegistrationCheckBox(){
        emailRegistrationCheckBox.click();
    }
    @Step("Клик по чек-боксу Персональное соглашение")
    public void clickPersonalAgreementCheckBox(){
        personalAgreementCheckBox.click();
    }
    @Step("Получение сообщения об ошибке под полем Пароль")
    public String getErrorPasswordMessage() {
        return errorPasswordMessage.getText();
    }
    @Step("Получение сообщения об ошибке под полем Телефон")
    public String getErrorPhoneMessage() {
        return errorPhoneMessage.getText();
    }
    @Step("Клик по кнопке Регистрации")
    public void clickRegistrationButton() {
        registrationButton.click();
    }
    @Step("Установка полю Имя значения {firstName}")
    public void setFirstNameField(String firstName) {
        firstNameField.setValue(firstName);
    }
    @Step("Установка полю Фамилия значения {lastName}")
    public void setLastNameField(String lastName) {
        lastNameField.setValue(lastName);
    }
    @Step("Установка полю Отчество значения {middleName}")
    public void setMiddleNameField(String middleName) {
        middleNameField.setValue(middleName);
    }
    @Step("Установка полю Логин значения {login}")
    public void setLoginField(String login) {
        loginField.setValue(login);
    }
    @Step("Установка календаря на дату 01/01/2020 и нажатие кнопки ENTER")
    public void fillDateOfBirthField() {
        dateOfBirthField.click();
        dateOfBirthField.setValue("01/01/2000").sendKeys(Keys.ENTER);
    }
    @Step("Установка полю Пароль значения {password}")
    public void setPasswordField(String password) {
        newPasswordField.setValue(password);
    }
    @Step("Установка полю Повторите пароль значения {repeatPassword}")
    public void setRepeatPasswordField(String repeatPassword) {
        repeatPasswordField.setValue(repeatPassword);
    }
    @Step("Установка полю Email значения {email}")
    public void setEmailField(String email) {
        emailField.setValue(email);
    }
    @Step("Установка полю Телефон значения {phone}")
    public void setPhoneField(String phone) {
        phoneField.setValue(phone);
    }
    @Step("Получение текста из оповещения")
    public String getMessageFromNotification() {
        return notificationMessage.getText();
    }
    @Step("Получение текста из оповещения авторизации")
    public String getErrorAuthorizationMessage() {
        wrongRegistrationMessage.shouldBe(visible);
        return wrongRegistrationMessage.getText();
    }
    @Step("Конструктор для заполнения полей регистрации и клик по кнопке регистрации")
    public void registration(String login, String password, String repeatPassword, String lastName, String firstName, String middleName, String email, String phone) {
        setLoginField(login);
        setPasswordField(password);
        setRepeatPasswordField(repeatPassword);
        setLastNameField(lastName);
        setFirstNameField(firstName);
        setMiddleNameField(middleName);
        setEmailField(email);
        setPhoneField(phone);
        fillDateOfBirthField();
        clickRegistrationButton();
    }

}