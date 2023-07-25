package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class LkPage {
    //Локтор для имени пользователя
    @FindBy(how = How.CSS, using = "body > main > div > div > div.QronIdInfo_wrapper__5gD8b > div.QronIdInfo_profileWrapper__1d5h8 > h1")
    private SelenideElement userName;
    //Локатор для сообщения об авторизации
    @FindBy(how = How.CSS, using = "body > div > div > div > div > div.ant-notification-notice-description")
    private SelenideElement authMessage;


    public boolean userNameIsExist(){
        userName.should(exist);
        return userNameIsExist();
    }
    public String getSuccessAuthorizationMessage(){
        authMessage.shouldBe(visible);
        return authMessage.getText();
    }
}
