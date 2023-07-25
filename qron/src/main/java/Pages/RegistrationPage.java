package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEnter;
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

    public String getErrorPasswordMessage() {
        return errorPasswordMessage.getText();
    }
    public String getErrorPhoneMessage(){
        return errorPhoneMessage.getText();
    }
    //Метод клика по кнопке регистрации
    public void clickRegistrationButton() {
        registrationButton.click();
    }
    //метод заполнения поля Имени
    public void setFirstNameField(String firstName) {
        firstNameField.setValue(firstName);
    }

    //метод заполнения Фамилии
    public void setLastNameField(String lastName) {
        lastNameField.setValue(lastName);
    }

    //метод заполнения Отчества
    public void setMiddleNameField(String middleName) {
        middleNameField.setValue(middleName);
    }

    //Метод заполнения логина
    public void setLoginField(String login) {
        loginField.setValue(login);
    }

    //Метод заполнения даты рождения
    public void fillDateOfBirthField() {
        dateOfBirthField.click();
        dateOfBirthField.setValue("01/01/2000").sendKeys(Keys.ENTER);
        /*
        $x("/html/body/div/div/div/div/div/div[1]/div[1]/div").click();
        $("body > div > div > div > div > div > div > div.ant-picker-header > div > button").click();
        $x("/html/body/div/div/div/div/div/div/div[1]/div/button").click();
        $x("/html/body/div/div/div/div/div/div/div[2]/table/tbody/tr[1]/td[2]/div").click();
        $("body > div > div > div > div > div > div > div.ant-picker-body > table > tbody > tr:nth-child(1) > td:nth-child(2) > div").click();
        $("body > div > div > div > div > div > div > div.ant-picker-body > table > tbody > tr:nth-child(1) > td:nth-child(1) > div").click();
    */
    }

    //Метод заполнения поля пароль
    public void setPasswordField(String password) {
        newPasswordField.setValue(password);
    }

    //Метод заполнения поля повторите пароль
    public void setRepeatPasswordField(String repeatPassword) {
        repeatPasswordField.setValue(repeatPassword);
    }

    //метод заполнения поля email
    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    //метод заполнения поля телефон
    public void setPhoneField(String phone) {
        phoneField.setValue(phone);
    }
    //Метод получения сообщения из оповещения
    public String getMessageFromNotification(){
        return notificationMessage.getText();
    }
    public String getErrorAuthorizationMessage(){
        wrongRegistrationMessage.shouldBe(visible);
        return wrongRegistrationMessage.getText();
    }

    //метод регистрации в приложении: объединяет все поля регистрации
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