package app.ppl;

public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();
        InputScanner inputScanner = new InputScanner("input.txt");

        inputScanner.getSymbols().forEach(input -> {
            System.out.println(input + ", " + validator.validate(input));
        });
    }
}
