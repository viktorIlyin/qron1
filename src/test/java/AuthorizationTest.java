import DataGenerator.UserGenerator;
import Pages.LkPage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class AuthorizationTest {
    String AUTH_PAGE_URL = "https://qron-split.joytech.store/auth";
    private static RegistrationPage registrationPage;
    private static UserGenerator userGenerator;
    private static LkPage lkPage;
    private static LoginPage loginPage;
    String CORRECT_PASSWORD = "Test1234@";
    String CORRECT_LOGIN = "Joytest";

    @Before
    public void setUp() {
        open(AUTH_PAGE_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        registrationPage = page(RegistrationPage.class);
        lkPage = page(LkPage.class);
        userGenerator = page(UserGenerator.class);
        loginPage = page(LoginPage.class);
    }
    //Тест с корректным логином и паролем
    @Test
    public void testSuccessfulAuthorizationWithCorrectData() {
        loginPage.filLoginAndAuth(CORRECT_LOGIN, CORRECT_PASSWORD);
        String actualResult = lkPage.getSuccessAuthorizationMessage();
        Assert.assertEquals("Успешная авторизация", "Авторизация прошла успешно", actualResult);
    }
    //Тест с корректным логином и рандомным паролем
    @Test
    public void testAuthorizationWithIncorrectPassword() {
        loginPage.filLoginAndAuth(CORRECT_LOGIN, userGenerator.password);
        String actualResult = lkPage.getSuccessAuthorizationMessage();
        Assert.assertEquals("Неудачная авторизация с некорректным паролем", "Ошибка авторизации", actualResult);
    }
    //Тест с некорректным логином и корректным паролем
    @Test
    public void testAuthorizationWithIncorrectLogin() {
        loginPage.filLoginAndAuth(userGenerator.login, CORRECT_PASSWORD);
        String actualResult = lkPage.getSuccessAuthorizationMessage();
        Assert.assertEquals("Неудачная авторизация с некорректным логином", "Ошибка авторизации", actualResult);
    }
    //Тест на попытку авторизации без пароля
    @Test
    public void testAuthorizationWithoutPassword() {
        loginPage.filLoginAndAuth(CORRECT_LOGIN,"");
        String actualResult = loginPage.getFailedEmptyPasswordMessage();
        Assert.assertEquals("Пустой пароль", "Введите пароль", actualResult);
    }
    @Test
    public void testAuthorizationWithoutLogin() {
        loginPage.filLoginAndAuth("",CORRECT_PASSWORD);
        String actualResult = loginPage.getFailedEmptyLoginMessage();
        Assert.assertEquals("Пустой пароль", "Введите логин", actualResult);
    }

    @Test
    public void testClickRegistrationButton(){
        loginPage.clickRegButton();
        Assert.assertTrue("Кнопка не найдена", registrationPage.registrationButtonIsDisplayed());
    }
    @Test
    public void testPasswordAuthorizationVisabilityTest(){
        loginPage.setPassword("123456");
        loginPage.clickEyeVisibleInvisible();
        String actualResult = loginPage.getPasswordFromPasswordField();
        Assert.assertEquals("Пароль показан", "123456", actualResult);
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
}
