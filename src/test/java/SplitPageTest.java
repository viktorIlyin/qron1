import DataGenerator.UserGenerator;
import Pages.HomePage;
import Pages.LkPage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SplitPageTest {
    private static RegistrationPage registrationPage;
    private static UserGenerator userGenerator;
    private static LkPage lkPage;
    private static LoginPage loginPage;
    private static HomePage homePage;
    String HOME_PAGE_URL = "https://qron-split.joytech.store/split";

    @Before
    public void setUp() {
        open(HOME_PAGE_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        registrationPage = page(RegistrationPage.class);
        lkPage = page(LkPage.class);
        userGenerator = page(UserGenerator.class);
        homePage = page(HomePage.class);

    }
    @After
    public void tearDown() {
        // Закрытие браузера после каждого теста
        // Можно также добавить дополнительные действия, например, сохранение скриншота или очистку cookies
        // Пример: Selenide.screenshot("screenshot_name");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
    @Test
    @Epic("Проверка дизайна")
    @DisplayName("Кликабельность ответа на вопрос 1")
    @Description("Кликабельность ответа на вопрос и соответствие текста ответа на вопрос 1")
    @Severity(SeverityLevel.TRIVIAL)
    public void checkTextFromFirstQuestion() {
        homePage.clickFirstQuestion();
        Assert.assertEquals("Защита финансовых данных является приоритетом для всех организаций и пользователей. Платежная система обеспечивает безопасность платежных транзакций и защите конфиденциальных данных клиентов. Вот несколько причин, почему использование QRON является безопасным:", homePage.firstQuestionGetText());
    }
    @Test
    @DisplayName("Кликабельность ответа на вопрос 2")
    @Description("Кликабельность ответа на вопрос и соответствие текста ответа на вопрос 2")
    public void checkTextFromSecondQuestion(){
        homePage.clickSecondQuestion();
        Assert.assertEquals("В платежной системе функция сплит (разделение) предоставляет возможность равномерного распределения дохода между несколькими участниками. Этот механизм работает независимо от количества участников, позволяя им безопасно и эффективно получать свои доли дохода. Такая гибкость особенно полезна в случае, когда требуется справедливое распределение прибыли среди большого числа участников. Благодаря прозрачности и удобству использования, сплит обеспечивает эффективное управление финансами и удовлетворяет потребности команд или групп, которые стремятся совместно получать доходы без рисков.",homePage.secondQuestionGetText());
    }
    @Test
    @DisplayName("Кликабельность ответа на вопрос 3")
    @Description("Кликабельность ответа на вопрос и соответствие текста ответа на вопрос 3")
    public void checkTextFromThirdQuestion(){
        homePage.clickThirdQuestion();
        Assert.assertEquals("Да, конечно! В платежных системах существуют механизмы и функциональность, которые обеспечивают юридическую и правовую обвязку для всех участников сплита. Это позволяет установить четкие правила и условия, которые регулируют распределение дохода между участниками. Важно, чтобы все участники были зарегистрированы и имели договорные обязательства, определяющие их права и обязанности в рамках сплита. Такие меры гарантируют соблюдение законодательства и защиту интересов всех сторон, обеспечивая прозрачность и законность в процессе распределения доходов.", homePage.thirdQuestionGetText());
    }
    @Test
    @DisplayName("Кликабельность ответа на вопрос 4")
    @Description("Кликабельность ответа на вопрос и соответствие текста ответа на вопрос 4")
    public void checkTextFromFourthQuestion(){
        homePage.clickFourthQuestion();
        Assert.assertEquals("QRON Split - Продукт «Сплит» - инновационное решение в области инфобиза, которое на данный момент не предоставляется другими компаниями.", homePage.fourthQuestionGetText());
    }
    @Test
    @DisplayName("Кликабельность ответа на вопрос 5")
    @Description("Кликабельность ответа на вопрос и соответствие текста ответа на вопрос 5")
    public void checkTextFromFifthQuestion(){
        homePage.clickFifthQuestion();
        Assert.assertEquals("Конечно! Продукт QRON Split предоставляет уникальные возможности для самозанятых, позволяя им законно работать в рамках системы.", homePage.fifthQuestionGetText());
    }
    @Test
    @DisplayName("Кликабельность ответа на вопрос 6")
    @Description("Кликабельность ответа на вопрос и соответствие текста ответа на вопрос 6")
    public void checkTextFromSixthQuestion(){
        homePage.clickSixthQuestion();
        Assert.assertEquals("В продукте \"QRON Split\" предлагается использование встроенной платежной системы для проведения платежей. Вот несколько причин, почему использование этой платежной системы является обязательным в рамках нашей системы:", homePage.sixthQuestionGetText());
    }
    @Test
    @DisplayName("Кликабельность ответа на вопрос 7")
    @Description("Кликабельность ответа на вопрос и соответствие текста ответа на вопрос 7")
    public void checkTextFromSeventhQuestion(){
        homePage.clickSeventhQuestion();
        Assert.assertEquals("Да, обычно для использования сплитов Вам нужен инвайт (приглашение). Однако, доступ к сплитам можно получить без инвайта, обратившись в службу поддержки по номеру телефона + 8 800 300 84 90 или написав на почту info@qronclub.ru.", homePage.seventhQuestionGetText());
    }
}
