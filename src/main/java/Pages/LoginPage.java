package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    //локатор поля ввода логина
    @FindBy(how = How.CSS, using = "#name")
    private SelenideElement loginField;
    //локатор поля ввода пароля
    @FindBy(how = How.CSS, using = "#password")
    private SelenideElement passwordField;
    //локатор кнопки входа в приложение
    @FindBy(how = How.CSS, using = "body > main > div > form > button > span")
    private SelenideElement enterLoginButton;
    //Локатор кнопки регистрации на странице авторизации
    @FindBy(how = How.CSS, using = "body > main > div > form > div.AuthForm_registrationLink__ykywF > a")
    private SelenideElement registrationButton;
    //Локатор для поиска красного текста ошибки отсутствия пароля
    @FindBy(how = How.CSS, using = "#password_help > div")
    private SelenideElement emptyPasswordErrorMessage;
    //Локатор для поиска красного текста ошибки отсутствия логина
    @FindBy(how = How.CSS, using = "#name_help > div")
    private SelenideElement emptyLoginErrorMessage;
    //Локатор для глаза видимый/невидимый пароль
    @FindBy(how = How.CSS, using = "body > main > div > form > div.ant-form-item.AuthForm_formItem__Eizm8.AuthForm_formItemPassword__WHfok.css-1l7cij0.ant-form-item-has-success > div > div > div > div > span > span > span")
    private SelenideElement eyeVisibleInvisible;

    //Клик по глазу локатору.
    public void clickEyeVisibleInvisible(){eyeVisibleInvisible.click();}
    //Получение введённого пароля из поля пароль
    public boolean registrationButtonIsDisplayed() {
        return registrationButton.exists();
    }
    //Метод получения текста из ошибки логина
    public String getFailedEmptyLoginMessage(){
        emptyLoginErrorMessage.shouldBe(visible);
        return emptyLoginErrorMessage.getText();
    }
    //Метод получения текста ошибки из пароля
    public String getFailedEmptyPasswordMessage(){
        emptyPasswordErrorMessage.shouldBe(visible);
        return emptyPasswordErrorMessage.getText();
    }
    //Метод получения текста из поля пароль
    public String getPasswordFromPasswordField(){
        passwordField.shouldBe(visible);
        return passwordField.getValue();
    }


    //метод заполнения поля ввода логина
    public void setUsername(String username) {
        loginField.setValue(username);
    }

    //метод заполнения поля ввода пароля
    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    //метод клика по кнопке авторизации
    public void clickSignInButton() {
        enterLoginButton.click();
    }

    //метод клика по кнопке регистрации
    public void clickRegButton() {
        registrationButton.click();
    }


    //метод авторизации в приложении: объединяет ввод логина, пароля и клик по кнопке входа
    public void filLoginAndAuth(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickSignInButton();
    }


    /*
    Я забыл чё за ебала, но пусть будет
    public void checkNotificationExist() {
        $(By.linkText("ant-notification-notice ant-notification-notice-success css-yp8pcc ant-notification-notice-closable")).should(exist);
    }

    public String getTextAuth() {
        String text = $(By.cssSelector("body > div > div > div > div > div.ant-notification-notice-description")).text();
        return text;
    }*/


}
