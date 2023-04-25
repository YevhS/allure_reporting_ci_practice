package org.hung;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Description;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import io.qameta.allure.Allure;

@SpringBootTest
class MyApplicationTests {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Testing Addition")
    @Description("Test for Addition method in Calculator class")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Calculator")
    void testAddition() {
        int result = calculator.add(2, 3);
        Allure.addAttachment("Result", Integer.toString(result));
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Testing Subtraction")
    @Description("Test for Subtraction method in Calculator class")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Calculator")
    void testSubtraction() {
        int result = calculator.subtract(5, 3);
        Allure.addAttachment("Result", Integer.toString(result));
        assertEquals(2, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    @DisplayName("Testing Multiplication")
    @Description("Test for Multiplication method in Calculator class")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Calculator")
    void testMultiplication(int number) {
        int result = calculator.multiply(number, 2);
        Allure.addAttachment("Result", Integer.toString(result));
        assertEquals(number * 2, result);
    }

    @ParameterizedTest
    @CsvSource({"10, 5, 2", "20, 4, 5", "15, 3, 5"})
    @DisplayName("Testing Division")
    @Description("Test for Division method in Calculator class")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Calculator")
    void testDivision(int dividend, int divisor, int expected) {
        int result = calculator.divide(dividend, divisor);
        Allure.addAttachment("Result", Integer.toString(result));
        assertEquals(expected, result);
    }
}
