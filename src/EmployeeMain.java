import java.util.Scanner;
public class EmployeeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array to hold employee objects
        Employee[] employees = new Employee[3];

        // Create 3 employees
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");
            System.out.print("First Name: ");
            String firstName = scanner.next();
            System.out.print("Last Name: ");
            String lastName = scanner.next();
            System.out.print("Employee ID: ");
            int employeeId = scanner.nextInt();
            System.out.print("Experience (in years): ");
            int experience = scanner.nextInt();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            employees[i] = new Employee(firstName, lastName, employeeId, experience, salary);
            System.out.println();
        }

        // Display each employee's monthly and yearly salary
        for (Employee employee : employees) {
            System.out.println("Employee Name: " + employee.getFirstName() + " " + employee.getLastName());
            System.out.println("Designation: " + employee.getDesignation());
            System.out.println("Monthly Salary: " + employee.calculateMonthlySalary());
            System.out.println("Yearly Salary: " + employee.calculateYearlySalary());
            System.out.println();
        }
    }

}
