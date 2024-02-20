import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MortgageApplicationTest {

    @Test
    void printProspects() throws URISyntaxException {
        List<MortgageData> list = new ArrayList<>();
        MortgageData md1 = new MortgageData("Pekka Persson", 1000, 0.05, 3);
        MortgageData md2 = new MortgageData("Wilma", 4000, 0.043, 5);
        list.add(md1);
        list.add(md2);
        String actual =
            "****************************************************************************************************\n" +
            "Prospect 0: Pekka Persson " +
                    "wants to borrow 1000.000000 € for a period of 3 years and pay 29.970897 € each month\n" +
            "****************************************************************************************************\n" +
            "Prospect 1: Wilma wants to borrow 4000.000000 € for a period of 5 years and pay 74.208857 € each month\n" +
            "****************************************************************************************************\n";
        assertEquals(MortgageApplication.printProspects(list), actual);
    }
}