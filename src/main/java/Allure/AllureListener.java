package Allure;


import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;


public class AllureListener extends RunListener {



    @Override
    public void testIgnored(Description description) throws Exception {
        // Код для обработки отключенных тестов
        System.out.println("Тест был отключен: " + description.getMethodName());
    }

    @Override
    public void testFinished(Description description) throws Exception {
        // Код для обработки успешных тестов
        System.out.println("Тест успешно завершен: " + description.getMethodName());
    }

    @Override
    public void testAssumptionFailure(Failure failure) {
        // Код для обработки прерванных тестов
        System.out.println("Тест был прерван: " + failure.getDescription().getMethodName());
    }
}