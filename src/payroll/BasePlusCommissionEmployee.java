package payroll;

    public class BasePlusCommissionEmployee extends CommissionEmployee {
        private double baseSalary;

        public BasePlusCommissionEmployee(String firstName, String lastName, String ssn,
                                          double grossSales, double commissionRate, double baseSalary) {
            super(firstName, lastName, ssn, grossSales, commissionRate);
            this.baseSalary = baseSalary;
        }

        public void setBaseSalary(double baseSalary) {
            this.baseSalary = baseSalary;
        }

        public double getBaseSalary() {
            return baseSalary;
        }

        @Override
        public double earnings() {
            return getBaseSalary() + super.earnings();
        }

        @Override
        public String toString() {
            return String.format("Base-Salaried Commission Employee: %s\nBase Salary: %.2f",
                    super.toString(), baseSalary);
        }
    }


