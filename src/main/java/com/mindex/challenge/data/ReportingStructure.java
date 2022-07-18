package com.mindex.challenge.data;

import java.util.Objects;

/**
 * Class to represent the employee Reporting Structure.
 *
 * @author Meenu Gigi
 */
public class ReportingStructure {

    private Employee employee;

    private int numberOfReports;


    /**
     * Parameterized constructor
     * @param employee  the employee
     * @param numberOfReports   number of reports for an employee
     */
    public ReportingStructure(Employee employee, int numberOfReports) {
        this.employee = employee;
        this.numberOfReports = numberOfReports;
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
     * Gets the number of reports for an employee
     * @return number of reports
     */
    public int getNumberOfReports() {
        return numberOfReports;
    }


    /**
     * Sets the number of reports for an employee
     * @param numberOfReports   number of reports for an employee
     */
    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }


    /**
     * Checks if two objects are equal.
     * @param o     the object of class Reporting Structure against which the current object is checked
     * @return true, if both the objects are equal. else, returns false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReportingStructure)) return false;
        ReportingStructure that = (ReportingStructure) o;
        return numberOfReports == that.numberOfReports && Objects.equals(employee, that.employee);
    }


    /**
     * Computes the hashcode value of an object.
     * If two objects are equal, they have the same hashcode.
     * @return the hashcode value
     */
    @Override
    public int hashCode() {
        return Objects.hash(employee, numberOfReports);
    }


    /**
     * The string representation of the object.
     * @return the string representation of the object
     */
    @Override
    public String toString() {
        return "ReportingStructure{" +
                "employee=" + employee +
                ", numberOfReports=" + numberOfReports +
                '}';
    }
}
