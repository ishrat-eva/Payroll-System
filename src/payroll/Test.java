
package payroll;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Employee[] employees = new Employee[5];

        employees[0] = new SalariedEmployee("Ishrat", "Jahan", "101", 1000);
        employees[1] = new HourlyEmployee("Rahim", "Hossain", "102", 50, 30);
        employees[2] = new CommissionEmployee("Anita", "Pervin", "103", 10000, 0.05);
        employees[3] = new BasePlusCommissionEmployee("Oishe", "Islam", "104", 5000, 0.04, 1000);

        System.out.println("\nAdd a new employee:");
        System.out.println("1. Salaried\n2. Hourly\n3. Commission\n4. BasePlusCommission");
        System.out.print("Select type (1-4): ");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter SSN: ");
        String ssn = sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter weekly salary: ");
                double weeklySalary = sc.nextDouble();
                employees[4] = new SalariedEmployee(firstName, lastName, ssn, weeklySalary);
                break;
            case 2:
                System.out.print("Enter hourly wage: ");
                double hourlyWage = sc.nextDouble();
                System.out.print("Enter hours worked: ");
                double hours = sc.nextDouble();
                employees[4] = new HourlyEmployee(firstName, lastName, ssn, hourlyWage, hours);
                break;
            case 3:
                System.out.print("Enter gross sales: ");
                double grossSales = sc.nextDouble();
                System.out.print("Enter commission rate (like 0.06 for 6%): ");
                double commissionRate = sc.nextDouble();
                employees[4] = new CommissionEmployee(firstName, lastName, ssn, grossSales, commissionRate);
                break;
            case 4:
                System.out.print("Enter gross sales: ");
                double gs = sc.nextDouble();
                System.out.print("Enter commission rate: ");
                double cr = sc.nextDouble();
                System.out.print("Enter base salary: ");
                double baseSalary = sc.nextDouble();
                employees[4] = new BasePlusCommissionEmployee(firstName, lastName, ssn, gs, cr, baseSalary);
                break;
            default:
                System.out.println("Invalid type selected. Skipping input employee.");
                employees[4] = null;
        }


        System.out.println("Employee Payroll Information");
        System.out.println();


        for (Employee currentEmployee : employees) {
            if (currentEmployee == null) continue;

            System.out.println(currentEmployee);

            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee emp = (BasePlusCommissionEmployee) currentEmployee;
                double oldBase = emp.getBaseSalary();
                emp.setBaseSalary(oldBase * 1.10);
                System.out.printf("Base salary increased by 10%%: %.2f\n", emp.getBaseSalary());
            }

            System.out.printf("Earnings: %.2f\n\n", currentEmployee.earnings());
        }
    }
}

