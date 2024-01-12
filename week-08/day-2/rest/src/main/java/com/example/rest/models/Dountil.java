package com.example.rest.models;

public class Dountil {

    private Integer result;
    private Integer until;


    public Dountil() {
    }

    public void calculateSum(int until) {
        int sum = 0;
        for (int i = 1; i <= until; i++) {
            sum += i;
        }
        this.result = sum;
    }

    public void calculateFactorial(int until) {
        int factorial = 1;
        for (int i = 1; i <= until; i++) {
            factorial *= i;
        }
        this.result = factorial;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getUntil() {
        return until;
    }

    public void setUntil(Integer until) {
        this.until = until;
    }
}

