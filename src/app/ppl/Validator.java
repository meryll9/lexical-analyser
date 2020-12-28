package app.ppl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Validator {

    File symbolTable;
    ArrayList<String> symbols;

    public Validator() {
        this.symbolTable = new File("symbl_table.txt");
        this.symbols = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(this.symbolTable))) {
            // Skip first 2 lines
            reader.readLine();
            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {
                Scanner scanner = new Scanner(line);

                this.symbols.add(scanner.next().trim());

                scanner.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validate(String inputSymbol) {
        ArrayList<String> possibleMatches = new ArrayList<>();

        this.symbols.forEach(symbol -> {
            if (symbol.charAt(0) == inputSymbol.charAt(0))
                possibleMatches.add(symbol);
        });

        if (possibleMatches.isEmpty()) {
            return false;
        } else {
            boolean match = false;
            int i;

            for (String symbol : possibleMatches) {
                if (symbol.length() < inputSymbol.length()) {
                    continue;
                }

                for (i = 0; i < symbol.length(); i++) {
                    try {
                        if (symbol.charAt(i) != inputSymbol.charAt(i))
                            break;
                    } catch (StringIndexOutOfBoundsException e) {
                        break;
                    }
                }
                
                if (i == symbol.length()) {
                    match = true;
                    break;
                }
            }

            return match;
        }
    }

}