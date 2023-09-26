package com.lab.web.lab_02.lib;

import java.util.Arrays;


public class CalculationResult {
    private final double[] xArray;
    private final double[] yArray;
    private final int steps;

    public CalculationResult(int res_len) {
        this.steps = res_len;
        this.xArray = new double[res_len];
        this.yArray = new double[res_len];
    }

    public int get_steps() {
        return this.steps;
    }

    public int get_max() {
        int req_index = 0;
        for (int i = 0; i < this.yArray.length; i++) {
            if (this.yArray[i] > this.yArray[req_index]) {
                req_index = i;
            }
        }
        return req_index;
    }

    public int get_min() {
        int req_index = 0;
        for (int i = 0; i < this.yArray.length; i++) {
            if (this.yArray[i] < this.yArray[req_index]) {
                req_index = i;
            }
        }
        return req_index;
    }

    public double get_sum() {
        return Arrays.stream(this.yArray).sum();
    }
    public double get_avg() {
        return Arrays.stream(this.yArray).average().orElse(0);
    }

    public void set_x_i(double x, int i) {
        this.xArray[i] = x;
    }
    public double get_x(int i) {
        return this.xArray[i];
    }

    public void set_y_i(double y, int i) {
        this.yArray[i] = y;
    }
    public double get_y(int i) {
        return this.yArray[i];
    }

}
