public class MortgageData {
    private String customerName;
    private double totalLoan;
    private double annualInterest;
    private int years;

    public MortgageData(String customerName, double totalLoan, double annualInterest, int years) {
        this.customerName = customerName;
        this.totalLoan = totalLoan;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public double getAnnualInterest() {
        return annualInterest;
    }

    public int getYears() {
        return years;
    }

    @Override
    public boolean equals(Object obj) {
        MortgageData md = (MortgageData) obj;
        return md.getCustomerName().equals(customerName)
                && md.getTotalLoan() == totalLoan
                && md.getAnnualInterest() == annualInterest
                && md.getYears() == years;
    }
}
