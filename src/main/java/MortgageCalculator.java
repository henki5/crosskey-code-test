public abstract class MortgageCalculator {

    // calculate mortgage on a monthly basis using the given mortgage formula
    public static double monthlyPayment(MortgageData md) {
        double totalLoan = md.getTotalLoan();
        double monthlyInterest = md.getAnnualInterest() / 12;   // Calculates interest on monthly basis
        int payments = 12 * md.getYears();                   // Number of payment-months
        return totalLoan * monthlyInterest *
                pow(1+monthlyInterest, payments) / (pow(1+monthlyInterest, payments) - 1);
    }

    // calculate a^b in the case b is an integer
    private static double pow(double a, int b) {
        double result = 1;
        for (int i = b; i >= 1; --i) {
            result *= a;
        }
        return result;
    }
}
