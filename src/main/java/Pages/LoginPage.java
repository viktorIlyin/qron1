package Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;


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

    @Step("Клик по глазу видимости")
    public void clickEyeVisibleInvisible(){eyeVisibleInvisible.click();}
    @Step("Получение введённого пароля из поля пароль")
    public boolean registrationButtonIsDisplayed() {
        return registrationButton.exists();
    }
    @Step("Получение текста ошибки под полем логин")
    public String getFailedEmptyLoginMessage(){
        emptyLoginErrorMessage.shouldBe(visible);
        return emptyLoginErrorMessage.getText();
    }
    @Step("Метод получение текста ошибки под полем пароль")
    public String getFailedEmptyPasswordMessage(){
        emptyPasswordErrorMessage.shouldBe(visible);
        return emptyPasswordErrorMessage.getText();
    }
    @Step("Получение Value из поля пароль")
    public String getPasswordFromPasswordField(){
        passwordField.shouldBe(visible);
        return passwordField.getValue();
    }


    @Step("Заполнение поля логин значением {username}")
    public void setUsername(String username) {
        loginField.setValue(username);
    }

    @Step("Заполнение поля пароль значением {password}")
    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    @Step("Клик по кнопке Войти")
    public void clickSignInButton() {
        enterLoginButton.click();
    }

    @Step("Клик по кнопке Регистрация")
    public void clickRegButton() {
        registrationButton.click();
    }


    @Step("Заполнение полей Логин и Пароль и клик по кнопке Войти")
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
