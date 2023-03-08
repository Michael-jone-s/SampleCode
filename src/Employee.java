import java.util.Scanner;

public class Employee {
    private String firstName;
    private String lastName;
    private int employeeId;
    private int experience;
    private String designation;
    private double salary;

    public Employee(String firstName, String lastName, int employeeId, int experience, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.experience = experience;
        this.salary = salary;

        if (experience >= 3 && experience <= 5) {
            this.designation = "Team Lead";
        } else if (experience >= 6 && experience <= 10) {
            this.designation = "Manager";
        } else {
            this.designation = "Employee";
        }

        if (experience >= 3 && experience <= 5) {
            this.salary *= 1.10;
        } else if (experience >= 6 && experience <= 10) {
            this.salary *= 1.20;
        }
    }

    // Getter and Setter methods for all instance variables
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Method to calculate monthly salary
    public double calculateMonthlySalary() {
        return salary / 12.0;
    }

    // Method to calculate yearly salary
    public double calculateYearlySalary() {
        return salary;
    }
}
