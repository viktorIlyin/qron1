package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exist;
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


    //метод авторизации в приложении: объединяет ввод логина, пароля и клик по кнопке
    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickSignInButton();
    }
    public void checkNotificationExist() {
        $(By.linkText("ant-notification-notice ant-notification-notice-success css-yp8pcc ant-notification-notice-closable")).should(exist);
    }

    public String getTextAuth() {
        String text = $(By.cssSelector("body > div > div > div > div > div.ant-notification-notice-description")).text();
        return text;
    }


}
