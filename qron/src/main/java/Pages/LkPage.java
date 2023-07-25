package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exist;

public class LkPage {
    @FindBy(how = How.CSS, using = "body > main > div > div > div.QronIdInfo_wrapper__5gD8b > div.QronIdInfo_profileWrapper__1d5h8 > h1")
    private SelenideElement userName;

    public boolean userNameIsExist(){
        userName.should(exist);
        return userNameIsExist();
    }
}
