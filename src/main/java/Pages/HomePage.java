package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final String HOME_PAGE_URL = "https://qron-split.joytech.store/qronid";

    @FindBy(how = How.CSS, using = "body > main > div > header > div > div.Header_block__Esi6W > div > div.Header_menuDesktop__TU2Ng > a")
    private SelenideElement enterButton;
    //("Вход в аккаунт по кнопке Войти")
    public void clickOnEnterButton() {
        enterButton.click();
    }
    public void checkEnterButtonExists() {
        enterButton.should(exist);
    }
}