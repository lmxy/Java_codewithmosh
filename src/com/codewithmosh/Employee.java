package com.codewithmosh;

public class Employee {
    private int baseSalary;
    private int hourlyRate;

    public static int numberOfEmployees;

    public Employee(int baseSalary) {
        this(baseSalary, 0);
    }

    public Employee(int baseSalary, int hourlyRate) {
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees++;
    }

public static void printNumberOfEmployees() {
    System.out.println(numberOfEmployees);
}

    public int calculateWage(int extraHours) {
        return baseSalary + (getHourlyRate() * extraHours);
}

    private int getHourlyRate() {
        return hourlyRate;
    }
    private void setHourlyRate(int hourlyRate) {
        if (hourlyRate <= 0)
            throw new IllegalArgumentException("Hourly rate cannot be 0 or less!");
        this.hourlyRate = hourlyRate;
    }


    public void setBaseSalary(int baseSalary) {
        if (baseSalary <= 0)
            throw new IllegalArgumentException("Salary");
        this.baseSalary = baseSalary;
    }
}
