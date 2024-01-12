package com.example.bankofsimba.model;

public class BankAccount {
    private String name;
    private double balance;
    private String animalType;
    String decimalSetter;

    public String getDecimalSetter() {
        return decimalSetter;
    }

    public BankAccount(String name, double balance, String animalType) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.decimalSetter = String.format("%.2f", balance);
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
}
