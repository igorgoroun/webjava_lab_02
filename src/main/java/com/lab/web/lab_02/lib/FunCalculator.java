package com.lab.web.lab_02.lib;


public class FunCalculator {
    public final static double TOLERANCE = 1.0e-6;
    public double a;
    public double x_min;
    public double x_max;
    public double x_step;
    public double breakline;

    public FunCalculator(double a, double x_min, double x_max, double x_step, double breakline) {
        this.a = a;
        this.x_min = x_min;
        this.x_max = x_max;
        this.x_step = x_step;
        this.breakline = breakline;
    }


    public CalculationResult compute() {
        CalculationResult result = new CalculationResult(this.steps());
        int i = 0;
        for (double x = this.x_min; x <= this.x_max; x += this.x_step) {
            result.set_x_i(x, i);
            result.set_y_i(this.apply_fun(x), i);
            i++;
        }
        return result;
    }

    public int steps() {
        return (int) ((this.x_max - this.x_min) / x_step) + 1;
    }

    private double apply_fun(double x) {
        if (x < this.breakline - TOLERANCE) {
            return this.fun_lt(x);
        } else if (Math.abs(x - this.breakline) < TOLERANCE) {
            return this.fun_eq(x);
        } else {
            return this.fun_gt(x);
        }
    }

    private double fun_lt(double x) {
        return Math.PI * Math.pow(x, 2) - 7 / Math.pow(x, 2);
    }
    private double fun_eq(double x) {
        return this.a * Math.pow(x, 3) + 7 * Math.sqrt(x);
    }
    private double fun_gt(double x) {
        return Math.log10(x + 7 * Math.sqrt(x));
    }


}
