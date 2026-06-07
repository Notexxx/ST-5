package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private static final double DELTA = 1e-6;

    // --- Тесты метода calc() ---

    @Test
    public void testSqrtOf4() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testSqrtOf9() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testSqrtOf2() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), DELTA);
    }

    @Test
    public void testSqrtOf1() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testSqrtOf0() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(0.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testSqrtOf100() {
        Sqrt sqrt = new Sqrt(100.0);
        assertEquals(10.0, sqrt.calc(), DELTA);
    }

    @Test
    public void testSqrtOf0Point25() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), DELTA);
    }

    // --- Тесты метода average() ---

    @Test
    public void testAverageOfTwoNumbers() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(3.0, sqrt.average(2.0, 4.0), DELTA);
    }

    @Test
    public void testAverageOfSameNumbers() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(5.0, sqrt.average(5.0, 5.0), DELTA);
    }

    @Test
    public void testAverageOfZeroAndNumber() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(2.5, sqrt.average(0.0, 5.0), DELTA);
    }

    // --- Тесты метода good() ---

    @Test
    public void testGoodReturnsTrueForExactSqrt() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    public void testGoodReturnsFalseForBadGuess() {
        Sqrt sqrt = new Sqrt(4.0);
        assertFalse(sqrt.good(1.0, 4.0));
    }

    // --- Тесты метода improve() ---

    @Test
    public void testImproveConvergesCloser() {
        Sqrt sqrt = new Sqrt(4.0);
        double improved = sqrt.improve(1.0, 4.0);
        double distBefore = Math.abs(1.0 * 1.0 - 4.0);
        double distAfter = Math.abs(improved * improved - 4.0);
        assertTrue(distAfter < distBefore);
    }

    // --- Тесты метода iter() ---

    @Test
    public void testIterConvergesFor9() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.iter(1.0, 9.0), DELTA);
    }

    // --- Точность результата ---

    @Test
    public void testCalcAccuracy() {
        Sqrt sqrt = new Sqrt(2.0);
        double result = sqrt.calc();
        assertTrue(Math.abs(result * result - 2.0) < 1e-7);
    }
}
