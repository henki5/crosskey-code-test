import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class MortgageParserTest {

    @Test
    void getData() {
        MortgageData md1 = new MortgageData("Peter,Pan", 3500, 0.032, 2);
        String test1 = String.format(Locale.ENGLISH,"\"%s\",%f,%f,%d",
                md1.getCustomerName(), md1.getTotalLoan(), 100*md1.getAnnualInterest(), md1.getYears());
        MortgageParser parser1 = new MortgageParser(test1);
        MortgageData md2 = parser1.getData().get(0);
        assertTrue(md1.equals(md2));
    }
}