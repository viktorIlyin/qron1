import DataGenerator.UserGenerator;
import Pages.LkPage;
import Pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.*;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageTest {

    private static RegistrationPage registrationPage;
    private static UserGenerator userGenerator;
    private static LkPage lkPage;
    private static String REGISTRATION_PAGE_URL = "https://qron-split.joytech.store/reg";
    private static String EXISTED_LOGIN = "joytest";
    private static String EXISTED_EMAIL = "joyqa@rambler.ru";
    private static String EXISTED_PHONE = "1234565556";

    @Before
    public void setUp() {
        open(REGISTRATION_PAGE_URL);
        registrationPage = page(RegistrationPage.class);
        lkPage = page(LkPage.class);
        userGenerator = new UserGenerator();

    }
    /*ДОБАВЬ
    ТЕСТЫ
            НА
    ГАЛОЧКИ
                    !!!!!*/

    @Test
    public void testSuccessfulRegistration() {
        registrationPage.registration(userGenerator.login, userGenerator.password, userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , userGenerator.phoneNumber);
        String actualResult = registrationPage.getErrorAuthorizationMessage();
        Assert.assertEquals("Успешная регистрация", "Регистрация прошла успешно. Подтвердите учётную запись по ссылке, отправленную на указанную почту", actualResult);
    }

    @Test
    public void testRegistrationWithExistingLogin() {
        registrationPage.registration(EXISTED_LOGIN,  userGenerator.password, userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , userGenerator.phoneNumber);
        String actualResult = registrationPage.getErrorAuthorizationMessage();
        Assert.assertEquals("Ошибка регистрации", "Ошибка авторизации", actualResult);
    }

    @Test
    public void testRegistrationWithExistingEmail() {
        registrationPage.registration(userGenerator.login, userGenerator.password, userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, EXISTED_EMAIL, userGenerator.phoneNumber);
        String actualResult = registrationPage.getErrorAuthorizationMessage();
        Assert.assertEquals("Успешная регистрация", "Ошибка авторизации", actualResult);
    }

    @Test
    public void testRegistrationWithExistingPhone() {
        registrationPage.registration(userGenerator.login ,userGenerator.password, userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , EXISTED_PHONE);
        String actualResult = registrationPage.getErrorAuthorizationMessage();
        Assert.assertEquals("Успешная регистрация", "Ошибка авторизации", actualResult);
    }

    @Test
    public void testInvalidRepeatPasswords() {
        registrationPage.registration(userGenerator.login, userGenerator.password, " ", userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , userGenerator.phoneNumber);
        String actualResult = registrationPage.getErrorPasswordMessage();
        Assert.assertEquals("Текст не совпадает", "Пароли не совпадают", actualResult);
    }

    @Test
    public void testMissingPhoneField() {
        registrationPage.registration(userGenerator.login, userGenerator.password, userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , " ");
        String actualResult = registrationPage.getErrorPhoneMessage();
        Assert.assertEquals("Текст не совпадает", "Введите валидный номер", actualResult);
    }

    @Test
    public void testMissingPasswordFields() {
        registrationPage.registration(userGenerator.login, " ", userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , userGenerator.phoneNumber);
        String actualResult = registrationPage.getErrorPasswordMessage();
        Assert.assertEquals("Текст не совпадает", "Пароли не совпадают", actualResult);
    }


    @After
    public void tearDown() {
        // Закрытие браузера после каждого теста
        // Можно также добавить дополнительные действия, например, сохранение скриншота или очистку cookies
        // Пример: Selenide.screenshot("screenshot_name");
        // Пример: Selenide.clearBrowserCookies();
        // Пример: Selenide.clearBrowserLocalStorage();
        // Пример: Selenide.clearBrowserCookies();
        // Пример: Selenide.closeWebDriver();
        Selenide.closeWebDriver();
    }
}