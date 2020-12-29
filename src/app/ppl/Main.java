package app.ppl;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Validator validator = new Validator();
        InputScanner inputScanner = new InputScanner("input.txt");
        FileWriter out= new FileWriter("Output.txt");
        inputScanner.getSymbols().forEach(input -> {
            try {
				out.write(input + " , " + validator.validate(input) + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}       
        });
        out.close();
        
        }
    }
