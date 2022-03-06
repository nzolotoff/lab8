package calculator;
import java.util.Scanner;

public class Source {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type an expression:");

        while (true) {
            String expression = scan.nextLine();
            Fractions str = new Fractions(expression);

            if (str.check()) {
                str.calculation();

                break;
            }
            else {
                System.out.println("Incorrect expression. Try again:");
            }


        }
    }
}