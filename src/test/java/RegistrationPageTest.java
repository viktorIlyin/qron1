import DataGenerator.UserGenerator;
import Pages.LkPage;
import Pages.RegistrationPage;
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
        userGenerator = page(UserGenerator.class);

    }

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
    @Test
    public void testMissingCheckBoxEmail() {
        registrationPage.clickEmailRegistrationCheckBox();
        registrationPage.registration(userGenerator.login, userGenerator.password, userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , userGenerator.phoneNumber);
    //Добавить ассерт какой-нибудь на то, что тест работает корректно.
    }
    @Test
    public void testMissingCheckBoxAgreement() {
        registrationPage.clickPersonalAgreementCheckBox();
        registrationPage.registration(userGenerator.login, userGenerator.password, userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , userGenerator.phoneNumber);
        //Добавить ассерт какой-нибудь на то, что тест работает корректно.
    }
    @Test
    public void testPasswordVisabilityRegistrationTest(){
        registrationPage.setPasswordField("123456");
        registrationPage.clickEyeVisibleInvisible();
        String actualResult = registrationPage.getPasswordFromPasswordField();
        Assert.assertEquals("Пароль показан", "123456", actualResult);
    }



    @After
    public void tearDown() {
        // Закрытие браузера после каждого теста
        // Можно также добавить дополнительные действия, например, сохранение скриншота или очистку cookies
        // Пример: Selenide.screenshot("screenshot_name");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        // Пример: Selenide.clearBrowserCookies();
        // Пример: Selenide.closeWebDriver();
        Selenide.closeWebDriver();
    }
}