package DataGenerator;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;
public class UserGenerator {
    Faker faker = new Faker();

    public Date dateOfBirthday = faker.date().birthday();
    public String login = faker.name().username();
    public String firstName = faker.name().firstName().replaceAll("\\d", "");
    public String middleName = faker.name().firstName().replaceAll("\\d", "");
    public String lastName = faker.name().lastName().replaceAll("\\d", "");
    public String phoneNumber = faker.number().digits(10);
    public String email = faker.internet().emailAddress();
    // Генерируем случайную строку с цифрами, маленькими и большими буквами, и специальными символами
    int passwordLength = faker.random().nextInt(8, 17); // Генерируем случайную длину пароля от 8 до 16 символов
    public String password = RandomStringUtils.random(passwordLength, true, true) + RandomStringUtils.randomNumeric(1) + faker.lorem().characters(2, 4, true, true);
}
