package com.lab.web.lab_02.lib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunCalculatorTest {

    @Test
    void testLab() {
        FunCalculator calc = new FunCalculator(1.5, 0.8, 2.0, 0.005, 1.7);
        CalculationResult res = calc.compute();
        System.out.println("Item 0  : x=" + res.get_x(0) + ", y=" + res.get_y(0));
        System.out.println("Item 180: x=" + res.get_x(180) + ", y=" + res.get_y(180));
        System.out.println("Item 240: x=" + res.get_x(240) + ", y=" + res.get_y(240));
    }

    @Test
    void testRes() {
        FunCalculator calc = new FunCalculator(1.5, 0.8, 2.0, 0.005, 1.7);
        CalculationResult res = calc.compute();
        System.out.println("Max: i=" + res.get_max() + ", x=" + res.get_x(res.get_max()) + ", y=" + res.get_y(res.get_max()));
        System.out.println("Min: i=" + res.get_min() + ", x=" + res.get_x(res.get_min()) + ", y=" + res.get_y(res.get_min()));
        System.out.println("Sum Y: " + res.get_sum());
        System.out.println("Avg Y: " + res.get_avg());
    }

    @Test
    void testSteps() {
        FunCalculator calc = new FunCalculator(1.5, 0.8, 2.0, 0.005, 1.7);
        System.out.println("Steps: " + calc.steps());
    }

}