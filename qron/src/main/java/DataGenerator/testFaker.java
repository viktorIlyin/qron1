package DataGenerator;

import com.github.javafaker.Faker;

public class testFaker {
    public static void main(String[] args) {
        UserGenerator userGenerator = new UserGenerator();

        System.out.println("Login: " + userGenerator.login);
        System.out.println("First Name: " + userGenerator.firstName);
        System.out.println("Last Name: " + userGenerator.lastName);
        System.out.println("Middle Name: " + userGenerator.middleName);
        System.out.println("Birthday: " + userGenerator.dateOfBirthday);
        System.out.println("Phone: " + userGenerator.phoneNumber);
        System.out.println("Email:" + userGenerator.email);
        System.out.println("Password:" + userGenerator.password);
    }
}