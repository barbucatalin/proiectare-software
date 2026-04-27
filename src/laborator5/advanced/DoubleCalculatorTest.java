package laborator5.advanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleCalculatorTest {

    @Test
    void testAddPositive() {
        DoubleCalculator calculator = new DoubleCalculator(10.0);

        calculator.add(5.0);

        assertEquals(15.0, calculator.result());
    }

    @Test
    void testAddNegatives() {
        DoubleCalculator calculator = new DoubleCalculator(-10.0);

        calculator.add(-5.0);

        assertEquals(-15.0, calculator.result());
    }

    @Test
    void testSubtractPositives() {
        DoubleCalculator calculator = new DoubleCalculator(20.0);

        calculator.subtract(5.0);

        assertEquals(15.0, calculator.result());
    }

    @Test
    void testSubtractNegatives() {
        DoubleCalculator calculator = new DoubleCalculator(-20.0);

        calculator.subtract(-5.0);

        assertEquals(-15.0, calculator.result());
    }

    @Test
    void testMultiplyPositives() {
        DoubleCalculator calculator = new DoubleCalculator(5.0);

        calculator.multiply(3.0);

        assertEquals(15.0, calculator.result());
    }

    @Test
    void testMultiplyNegatives() {
        DoubleCalculator calculator = new DoubleCalculator(-5.0);

        calculator.multiply(-3.0);

        assertEquals(15.0, calculator.result());
    }

    @Test
    void testMultiplyBy0() {
        DoubleCalculator calculator = new DoubleCalculator(5.0);

        calculator.multiply(0.0);

        assertEquals(0.0, calculator.result());
    }

    @Test
    void testDividePositives() {
        DoubleCalculator calculator = new DoubleCalculator(20.0);

        calculator.divide(4.0);

        assertEquals(5.0, calculator.result());
    }

    @Test
    void testDivideNegatives() {
        DoubleCalculator calculator = new DoubleCalculator(-20.0);

        calculator.divide(-4.0);

        assertEquals(5.0, calculator.result());
    }

    @Test
    void testDivideBy0() {
        DoubleCalculator calculator = new DoubleCalculator(10.0);

        calculator.divide(0.0);

        assertTrue(Double.isInfinite((Double) calculator.result()));
    }
}