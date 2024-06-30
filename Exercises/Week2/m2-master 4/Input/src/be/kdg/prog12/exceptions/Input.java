package be.kdg.prog12.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number from 1 to 10: ");
        boolean validNumber = false;
        int number = 0;

        while (!validNumber) {
            try {
                number = scanner.nextInt();
                if (number < 1 || number > 10) {
                    throw new InputMismatchException(String.format("%d is not a number from 1 to 10.", number));
                }
                validNumber = true;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear the buffer!
                System.out.println(e.getMessage());
                System.out.print("Please enter a number from 1 to 10: ");
            }
        }

        System.out.printf("%d is a valid number!", number);
    }
}
