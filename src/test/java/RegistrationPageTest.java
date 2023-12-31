import DataGenerator.UserGenerator;
import Pages.LkPage;
import Pages.RegistrationPage;
import com.codeborne.selenide.Selenide;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
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
        WebDriverRunner.getWebDriver().manage().window().maximize();
        registrationPage = page(RegistrationPage.class);
        lkPage = page(LkPage.class);
        userGenerator = page(UserGenerator.class);

    }

    @Test
    @Epic("Регистрация")
    @DisplayName("Успешная регистрация")
    @Description("Успешная регистрация с корректными данными")
    @Severity(SeverityLevel.BLOCKER)
    public void testSuccessfulRegistration() {
        registrationPage.registration(userGenerator.login, userGenerator.password, userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , userGenerator.phoneNumber);
        String actualResult = registrationPage.getErrorAuthorizationMessage();
        Assert.assertEquals("Успешная регистрация", "Регистрация прошла успешно. Подтвердите учётную запись по ссылке, отправленную на указанную почту", actualResult);
    }

    @Test
    @DisplayName("Регистрация с уже зарегистрированным логином")
    @Description("Регистрация с уже зарегистрированным логином, но остальные данные корректны")
    @Severity(SeverityLevel.BLOCKER)
    public void testRegistrationWithExistingLogin() {
        registrationPage.registration(EXISTED_LOGIN,  userGenerator.password, userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , userGenerator.phoneNumber);
        String actualResult = registrationPage.getErrorAuthorizationMessage();
        Assert.assertEquals("Ошибка регистрации", "Ошибка авторизации", actualResult);
    }

    @Test
    @DisplayName("Регистрация с уже зарегистрированным Email")
    @Severity(SeverityLevel.BLOCKER)
    public void testRegistrationWithExistingEmail() {
        registrationPage.registration(userGenerator.login, userGenerator.password, userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, EXISTED_EMAIL, userGenerator.phoneNumber);
        String actualResult = registrationPage.getErrorAuthorizationMessage();
        Assert.assertEquals("Успешная регистрация", "Ошибка авторизации", actualResult);
    }

    @Test
    @DisplayName("Регистрация с уже зарегистрированным номером телефона")
    @Description("Регистрация с уже зарегистрированным номером телефона, но остальные данные корректны")
    @Severity(SeverityLevel.BLOCKER)
    public void testRegistrationWithExistingPhone() {
        registrationPage.registration(userGenerator.login ,userGenerator.password, userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , EXISTED_PHONE);
        String actualResult = registrationPage.getErrorAuthorizationMessage();
        Assert.assertEquals("Успешная регистрация", "Ошибка авторизации", actualResult);
    }

    @Test
    @DisplayName("Регистрация с некорректным повторением пароля")
    @Description("Регистрация с уже некорректным повторением пароля, но остальные данные корректны")
    @Severity(SeverityLevel.CRITICAL)
    public void testInvalidRepeatPasswords() {
        registrationPage.registration(userGenerator.login, userGenerator.password, " ", userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , userGenerator.phoneNumber);
        String actualResult = registrationPage.getErrorPasswordMessage();
        Assert.assertEquals("Текст не совпадает", "Пароли не совпадают", actualResult);
    }

    @Test
    @DisplayName("Регистрация с пустым полем номера телефона")
    @Description("Регистрация с пустым полем номера телефона, но остальные данные корректны")
    @Severity(SeverityLevel.CRITICAL)
    public void testMissingPhoneField() {
        registrationPage.registration(userGenerator.login, userGenerator.password, userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , " ");
        String actualResult = registrationPage.getErrorPhoneMessage();
        Assert.assertEquals("Текст не совпадает", "Введите валидный номер", actualResult);
    }

    @Test
    @DisplayName("Регистрация с пустым полем пароля")
    @Description("Регистрация с пустым полем пароль, но остальные данные корректны")
    @Severity(SeverityLevel.CRITICAL)
    public void testMissingPasswordFields() {
        registrationPage.registration(userGenerator.login, " ", userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , userGenerator.phoneNumber);
        String actualResult = registrationPage.getErrorPasswordMessage();
        Assert.assertEquals("Текст не совпадает", "Пароли не совпадают", actualResult);
    }
    @Test
    @DisplayName("Регистрация без установленной галочки подписки на Email сообщения")
    @Description("Регистрация без установленной галочки подписки на Email сообщения, но остальные поля корректно заполненны")
    @Severity(SeverityLevel.CRITICAL)
    public void testMissingCheckBoxEmail() {
        registrationPage.clickEmailRegistrationCheckBox();
        registrationPage.registration(userGenerator.login, userGenerator.password, userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , userGenerator.phoneNumber);
    //Добавить ассерт какой-нибудь на то, что тест работает корректно.
    }
    @Test
    @DisplayName("Регистрация без установленной галочки на пользовательское соглашение")
    @Description("Регистрация без установленной галочки у пользовательского соглашения, но остальные поля корректно заполненны")
    @Severity(SeverityLevel.CRITICAL)
    public void testMissingCheckBoxAgreement() {
        registrationPage.clickPersonalAgreementCheckBox();
        registrationPage.registration(userGenerator.login, userGenerator.password, userGenerator.password, userGenerator.lastName, userGenerator.firstName, userGenerator.middleName, userGenerator.email , userGenerator.phoneNumber);
        //Добавить ассерт какой-нибудь на то, что тест работает корректно.
    }
    @Test
    @DisplayName("Кнопка глаза показывает пароль и возможно получить пароль через getValue")
    @Description("Нажатие на кнопку глаза делает видимым поле пароль и появляется возможность сделать getValue")
    @Severity(SeverityLevel.TRIVIAL)
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
        Selenide.closeWebDriver();
    }
}