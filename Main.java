import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            String output;
            while (!(input = br.readLine().toUpperCase()).equals("ESC")) {
                try {
                    ExpressionDTO expr = ExpressionParser.parse(input);
                    output = Calculator.calc(expr);
                    System.out.println("Result is: "+ output);
                    System.out.println("Enter new expression or type \"ESC<CR>\" to end program");
                } catch (CustomException e) {
                    System.out.println(e.toString());
                    System.out.println("Try again");
                }
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
