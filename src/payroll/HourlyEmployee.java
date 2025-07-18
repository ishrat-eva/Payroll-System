package payroll;


    public class HourlyEmployee extends Employee {
        private double hourlyWage;
        private double hoursWorked;

        public HourlyEmployee(String firstName, String lastName, String ssn, double hourlyWage, double hoursWorked) {
            super(firstName, lastName, ssn);
            this.hourlyWage = hourlyWage;
            this.hoursWorked = hoursWorked;
        }

        @Override
        public double earnings() {
            if (hoursWorked <= 40) {
                return hourlyWage * hoursWorked;
            } else {
                return 40 * hourlyWage + (hoursWorked - 40) * hourlyWage * 1.5;
            }
        }

        @Override
        public String toString() {
            return String.format("Hourly Employee: %s\nHourly Wage: %.2f; Hours Worked: %.2f",
                    super.toString(), hourlyWage, hoursWorked);
        }
    }


