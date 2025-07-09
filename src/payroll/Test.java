package payroll;


import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("\nEntering details for employee %d:\n", i+1);
            System.out.print("Enter first name: ");
            String firstName = sc.nextLine();
            System.out.print("Enter last name: ");
            String lastName = sc.nextLine();
            System.out.print("Enter Social security number: ");
            String ssn = sc.nextLine();

            System.out.println("Employee Type: 1.Salaried 2.Hourly 3.Commission 4.Base+Commission");
            int type = sc.nextInt();
            sc.nextLine();

            switch (type) {
                case 1:
                    System.out.print("Enter weekly salary: ");
                    double weeklySalary = sc.nextDouble();
                    sc.nextLine();
                    employees[i] = new SalariedEmployee(firstName, lastName, ssn, weeklySalary);
                    break;

                case 2:
                    System.out.print("Enter hourly wage: ");
                    double hourlyWage = sc.nextDouble();
                    System.out.print("Enter hours worked: ");
                    double hoursWorked = sc.nextDouble();
                    sc.nextLine();
                    employees[i] = new HourlyEmployee(firstName, lastName, ssn, hourlyWage, hoursWorked);
                    break;

                case 3:
                    System.out.print("Enter gross sales: ");
                    double grossSales = sc.nextDouble();
                    System.out.print("Enter commission rate (example: 0.06): ");
                    double commissionRate = sc.nextDouble();
                    sc.nextLine();
                    employees[i] = new CommissionEmployee(firstName, lastName, ssn, grossSales, commissionRate);
                    break;

                case 4:
                    System.out.print("Enter gross sales: ");
                    double grossSales2 = sc.nextDouble();
                    System.out.print("Enter commission rate (example: 0.04): ");
                    double commissionRate2 = sc.nextDouble();
                    System.out.print("Enter base salary: ");
                    double baseSalary = sc.nextDouble();
                    sc.nextLine();
                    employees[i] = new BasePlusCommissionEmployee(firstName, lastName, ssn,
                            grossSales2, commissionRate2, baseSalary);
                    break;

                default:
                    System.out.println("Invalid type. Adding Salaried by default.");
                    employees[i] = new SalariedEmployee(firstName, lastName, ssn, 500);
                    break;
            }
        }

        for (Employee currentEmployee : employees) {
            System.out.println("\n" + currentEmployee);

            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee e = (BasePlusCommissionEmployee) currentEmployee;
                double oldBase = e.getBaseSalary();
                e.setBaseSalary(oldBase * 1.10);
                System.out.printf("Base salary increased by 10%%: %.2f\n", e.getBaseSalary());
            }

            System.out.printf("Earnings: %.2f\n", currentEmployee.earnings());
        }
    }
}
