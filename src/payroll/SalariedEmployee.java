package payroll;

    public class SalariedEmployee extends Employee {
        private double weeklySalary;

        public SalariedEmployee(String firstName, String lastName, String ssn, double weeklySalary) {
            super(firstName, lastName, ssn);
            this.weeklySalary = weeklySalary;
        }

        @Override
        public double earnings() {

            return weeklySalary;
        }

        @Override
        public String toString() {
            return String.format("Salaried Employee: %s\nWeekly Salary: %.2f",
                    super.toString(), weeklySalary);
        }
    }


