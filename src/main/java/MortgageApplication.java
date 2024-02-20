import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

public class MortgageApplication {
    public static void main(String args[]) {
        String filePath = args[0];
        try {
            String mortgageText = Files.readString(Paths.get(filePath));
            MortgageParser parser = new MortgageParser(mortgageText);
            List<MortgageData> data = parser.getData();
            printProspects(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String printProspects(List<MortgageData> dataList) {
        String result = "";
        for (int i = 0; i < dataList.size(); ++i) {
            MortgageData md = dataList.get(i);
            double monthlyPayment = MortgageCalculator.monthlyPayment(md);
            result += "*".repeat(100) + "\n";
            result += String.format(Locale.ENGLISH, "Prospect %d: %s wants to borrow %f € for a period of %d years and pay %f € each month\n",
                    i, md.getCustomerName(), md.getTotalLoan(), md.getYears(), monthlyPayment);
        }
        result += "*".repeat(100) + "\n";
        System.out.println(result);
        return result;
    }

}
