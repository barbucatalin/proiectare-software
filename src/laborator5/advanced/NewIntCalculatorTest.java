package laborator5.advanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewIntCalculatorTest {

    @Test
    void testAddPositive() {
        NewIntCalculator calculator = new NewIntCalculator(10);

        calculator.add(5);

        assertEquals(15, calculator.result());
    }

    @Test
    void testAddNegatives() {
        NewIntCalculator calculator = new NewIntCalculator(-10);

        calculator.add(-5);

        assertEquals(-15, calculator.result());
    }

    @Test
    void testSubtractPositives() {
        NewIntCalculator calculator = new NewIntCalculator(20);

        calculator.subtract(5);

        assertEquals(15, calculator.result());
    }

    @Test
    void testSubtractNegatives() {
        NewIntCalculator calculator = new NewIntCalculator(-20);

        calculator.subtract(-5);

        assertEquals(-15, calculator.result());
    }

    @Test
    void testMultiplyPositives() {
        NewIntCalculator calculator = new NewIntCalculator(5);

        calculator.multiply(3);

        assertEquals(15, calculator.result());
    }

    @Test
    void testMultiplyNegatives() {
        NewIntCalculator calculator = new NewIntCalculator(-5);

        calculator.multiply(-3);

        assertEquals(15, calculator.result());
    }

    @Test
    void testMultiplyBy0() {
        NewIntCalculator calculator = new NewIntCalculator(5);

        calculator.multiply(0);

        assertEquals(0, calculator.result());
    }

    @Test
    void testDividePositives() {
        NewIntCalculator calculator = new NewIntCalculator(20);

        calculator.divide(4);

        assertEquals(5, calculator.result());
    }

    @Test
    void testDivideNegatives() {
        NewIntCalculator calculator = new NewIntCalculator(-20);

        calculator.divide(-4);

        assertEquals(5, calculator.result());
    }

    @Test
    void testDivideBy0() {
        NewIntCalculator calculator = new NewIntCalculator(10);

        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(0);
        });
    }
}