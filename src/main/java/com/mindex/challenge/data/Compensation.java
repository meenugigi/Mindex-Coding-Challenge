package com.mindex.challenge.data;

import java.time.Instant;
import java.util.Objects;

/**
 * Class to represent compensation
 *
 * @author Meenu Gigi
 */
public class Compensation {

//    Represents the employee .
    private Employee employee;

    private String salary;

//    Can also use Java LocalDateTime.
//    Instant represents a specific point in time while LocalDateTime does not.
    private Instant effectiveDate;


    /**
     * Parameterized constructor
     * @param employee  the employee
     * @param salary    salary
     * @param effectiveDate     the date
     */
    public Compensation(Employee employee, String salary, Instant effectiveDate) {
        this.employee = employee;
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    }

    /**
     * Gets employee
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets employee
     * @param employee  the employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Gets salary
     * @return the salary
     */
    public String getSalary() {
        return salary;
    }


    /**
     * Sets salary
     * @param salary    the salary
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }


    /**
     * Gets effective date
     * @return the effectiveDate
     */
    public Instant getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets effective date
     * @param effectiveDate the date
     */
    public void setEffectiveDate(Instant effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Checks if two objects are equal.
     * @param o     the object of class Compensation against which the current object is checked
     * @return true, if both the objects are equal. else, returns false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compensation)) return false;
        Compensation that = (Compensation) o;
        return Objects.equals(employee, that.employee) && Objects.equals(salary, that.salary) && Objects.equals(effectiveDate, that.effectiveDate);
    }

    /**
     * Computes the hashcode value of an object.
     * If two objects are equal, they have the same hashcode.
     * @return the hashcode value
     */
    @Override
    public int hashCode() {
        return Objects.hash(employee, salary, effectiveDate);
    }


    /**
     * The string representation of the object.
     * @return the string representation of the object
     */
    @Override
    public String toString() {
        return "Compensation{" +
                "employee=" + employee +
                ", salary='" + salary + '\'' +
                ", effectiveDate=" + effectiveDate +
                '}';
    }
}
