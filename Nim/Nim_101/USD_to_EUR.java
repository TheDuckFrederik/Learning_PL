//
import java.util.Scanner;
//
public class USD_to_EUR {
    public static void main(String[] args) {
        final double EUR_TO_USD = 1.08;
        final double USD_TO_EUR = 0.92;
        double mult = 0.00;
        double result = 0.00;
        //
        String inputCoin = "";
        String outputCoin = "";
        //
        Scanner scanner = new Scanner(System.in);
        //
        while (true) {
            System.out.println("Welcome");
            System.out.println("1. EUR to USD");
            System.out.println("2. USD to EUR");
            System.out.print("---> ");
            //
            int choice = scanner.nextInt();
            //
            if (choice == 1) {
                inputCoin = "EUR";
                outputCoin = "USD";
                mult = EUR_TO_USD;
                break;
            //
            } else if (choice == 2) {
                inputCoin = "USD";
                outputCoin = "EUR";
                mult = USD_TO_EUR;
                break;
            //
            } else {
                System.out.println("Syntax ERR\nPlease try again\n");
            }
        }
        //
        System.out.printf("\nInsert amount in %s\n---> ", inputCoin);
        double amount = scanner.nextDouble();
        //
        result = amount * mult;
        System.out.printf("\n---> %.2f %s\n", result, outputCoin);
        //
        scanner.close();
    }
}
//
