package Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final String HOME_PAGE_URL = "https://qron-split.joytech.store/split";
    /// Локаторы для кнопок
    @FindBy(how = How.CSS, using = "body > main > div > header > div > div.Header_block__Esi6W > div > div.Header_menuDesktop__TU2Ng > a")
    private SelenideElement enterButton;
    @FindBy(how = How.CSS, using = "#faq > div:nth-child(2) > div.Accordion_wrapper__vVfpx > h4")
    private SelenideElement firstQuestion;
    @FindBy(how = How.CSS, using = "#faq > div:nth-child(3) > div > h4")
    private SelenideElement secondQuestion;
    @FindBy(how = How.CSS, using = "#faq > div:nth-child(4) > div > h4")
    private SelenideElement thirdQuestion;
    @FindBy(how = How.CSS, using = "#faq > div:nth-child(5) > div > h4")
    private SelenideElement fourthQuestion;
    @FindBy(how = How.CSS, using = "#faq > div:nth-child(6) > div > h4")
    private SelenideElement fifthQuestion;
    @FindBy(how = How.CSS, using = "#faq > div:nth-child(7) > div.Accordion_wrapper__vVfpx > h4")
    private SelenideElement sixthQuestion;
    @FindBy(how = How.CSS, using = "#faq > div:nth-child(8) > div > h4")
    private SelenideElement seventhQuestion;
    ///Локаторы для текста ответов
    @FindBy(how = How.CSS, using = "#faq > div:nth-child(2) > p:nth-child(2)")
    private SelenideElement firstQuestionText;
    @FindBy(how = How.CSS, using = "#faq > div.Accordion_item__x0Qr_.Accordion_itemOpen__sA1SZ.dark\\:bg-gray-900.bg-gray-200 > p")
    private SelenideElement secondQuestionText;
    @FindBy(how = How.CSS, using = "#faq > div.Accordion_item__x0Qr_.Accordion_itemOpen__sA1SZ.dark\\:bg-gray-900.bg-gray-200 > p")
    private SelenideElement thirdQuestionText;
    @FindBy(how = How.CSS, using = "#faq > div.Accordion_item__x0Qr_.Accordion_itemOpen__sA1SZ.dark\\:bg-gray-900.bg-gray-200 > p")
    private SelenideElement fourthQuestionText;
    @FindBy(how = How.CSS, using = "#faq > div.Accordion_item__x0Qr_.Accordion_itemOpen__sA1SZ.dark\\:bg-gray-900.bg-gray-200 > p")
    private SelenideElement fifthQuestionText;
    @FindBy(how = How.CSS, using = "#faq > div.Accordion_item__x0Qr_.Accordion_itemOpen__sA1SZ.dark\\:bg-gray-900.bg-gray-200 > p:nth-child(2)")
    private SelenideElement sixthQuestionText;
    @FindBy(how = How.CSS, using = "#faq > div.Accordion_item__x0Qr_.Accordion_itemOpen__sA1SZ.dark\\:bg-gray-900.bg-gray-200 > p")
    private SelenideElement seventhQuestionText;



    @Step("Клик по кнопке Войти")
    public void clickOnEnterButton() {
        enterButton.click();
    }
    @Step("Кнопка Войти есть на странице")
    public void checkEnterButtonExists() {
        enterButton.should(exist);
    }
    ///Клики по вопросам
    @Step("Клик по вопросу Почему это безопасно?")
    public void clickFirstQuestion(){ firstQuestion.click();}
    @Step("Клик по вопросу Может ли быть больше двух частников сплита?")
    public void clickSecondQuestion(){secondQuestion.click();}
    @Step("Клик по вопросу Это все официально, так можно?")
    public void clickThirdQuestion(){thirdQuestion.click();}
    @Step("Клик по вопросу Уже кто-то так делает?")
    public void clickFourthQuestion(){fourthQuestion.click();}
    @Step("Клик по вопросу А если я самозанятый?")
    public void clickFifthQuestion(){fifthQuestion.click();}
    @Step("Клик по вопросу Обязательно проводить платежи через вашу платежную систему QRON?")
    public void clickSixthQuestion(){sixthQuestion.click();}
    @Step("Клик по вопросу Без инвайта я не могу начать пользоваться сплитами?")
    public void clickSeventhQuestion(){seventhQuestion.click();}
    //Получение текста из вопросов
    @Step("Получить текст из ответа на первый вопрос")
    public String firstQuestionGetText(){
        return firstQuestionText.getText();
    }
    @Step("Получить текст из ответа на второй вопрос")
    public String secondQuestionGetText(){
        return secondQuestionText.getText();
    }
    @Step("Получить текст из ответа на третий вопрос")
    public String thirdQuestionGetText(){
        return thirdQuestionText.getText();
    }

    @Step("Получить текст из ответа на четвёртый вопрос")
    public String fourthQuestionGetText(){
        return fourthQuestion.getText();
    }

    @Step("Получить текст из ответа на пятый вопрос")
    public String fifthQuestionGetText(){
        return fifthQuestion.getText();
    }
    @Step("Получить текст из ответа на шестой вопрос")
    public String sixthQuestionGetText(){
        return sixthQuestion.getText();
    }
    @Step("Получить текст из ответа на седьмой вопрос")
    public String seventhQuestionGetText(){
        return seventhQuestion.getText();
    }




}