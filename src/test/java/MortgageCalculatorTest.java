import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class MortgageCalculatorTest {

    @org.junit.jupiter.api.Test
    void monthlyPayment() {
        final double accuracy = 0.0001;

        MortgageData md1 = new MortgageData("Kalle,Anka", 5000, 0.044, 7);
        assertTrue(abs(MortgageCalculator.monthlyPayment(md1) - 69.26849333662) <= accuracy);

        MortgageData md2 = new MortgageData("Musse Pigg", 20000, 0.02, 12);
        assertTrue(abs(MortgageCalculator.monthlyPayment(md2) - 156.33673836742) <= accuracy);
    }
    private double abs(double x) {
        return (x < 0) ? -x : x;
    }
}