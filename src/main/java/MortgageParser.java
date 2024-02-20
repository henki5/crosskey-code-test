import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MortgageParser {
    private String mortgageText;

    public MortgageParser(String text) {
        mortgageText = text;
    }

    // Parse the contents of mortgageFile and return the data as a list of MortgageData objects
    public List<MortgageData> getData() {
        List<MortgageData> data = new ArrayList<>();
        Scanner reader = new Scanner(mortgageText);
        boolean isInQuotes = false;
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            try {
                // Fetch data txt line, but ignore commas in quotes
                List<String> textData = new ArrayList<>();
                String currentItem = "";
                for (int i = 0; i < line.length(); ++i) {
                    char c = line.charAt(i);
                    isInQuotes = (c == '\"') ? !isInQuotes : isInQuotes;
                    if (!isInQuotes && c == ',') {
                        textData.add(currentItem);
                        currentItem = "";
                    }
                    else if (c != '\"'){
                        currentItem += c;
                    }
                }
                textData.add(currentItem);
                String customer = textData.get(0);
                double totalLoan = Double.parseDouble(textData.get(1));
                double interest = Double.parseDouble(textData.get(2)) / 100;    // convert from percentage
                int years = Integer.parseInt(textData.get(3));
                data.add(new MortgageData(customer, totalLoan, interest, years));
            }
            catch (Exception e) {
                // ignore invalid lines
            }
        }
        return data;
    }
}
