package payroll;


    public class CommissionEmployee extends Employee {
        private double grossSales;
        private double commissionRate;

        public CommissionEmployee(String firstName, String lastName, String ssn,
                                  double grossSales, double commissionRate) {
            super(firstName, lastName, ssn);
            this.grossSales = grossSales;
            this.commissionRate = commissionRate;
        }
        public double getGrossSales() { return grossSales; }
        public double getCommissionRate() { return commissionRate; }

        @Override
        public double earnings() {

            return grossSales * commissionRate;
        }
        protected String employeeToString() {
            return super.toString();
        }


        @Override
        public String toString() {
            return String.format("Commission Employee: %s\nGross Sales: $%.2f; Commission Rate: %.2f",
                    super.toString(), grossSales, commissionRate);
        }
    }


