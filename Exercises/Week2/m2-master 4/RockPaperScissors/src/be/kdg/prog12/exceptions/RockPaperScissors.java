package be.kdg.prog12.exceptions;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        final String[] options = {"rock", "paper", "scissors"};
        final Random random = new Random();
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter 'rock', 'paper', or 'scissors' (or 'stop'): ");
        String input = scanner.next();
        while (!input.equals("stop")) {
            // 'Arrays.binarySearch()' would be a better implementation of translating the 'input' to the 'userChoice'.
            // However, this method hasn't been discussed yet in the course material.

            int userChoice;
            switch (input) {
                case "rock":
                    userChoice = 0;
                    break;
                case "paper":
                    userChoice = 1;
                    break;
                case "scissors":
                    userChoice = 2;
                    break;
                default:
                    throw new InputMismatchException("Input is invalid.");
            }

            int computerChoice = random.nextInt(options.length);

            System.out.printf("Computer chose %s.%n", options[computerChoice]);
            if (computerChoice == userChoice) {
                System.out.println("    It's a draw!");
            } else if ((computerChoice - userChoice + options.length) % options.length == 1) {
                System.out.println("    Computer won!");
            } else {
                System.out.println("    You won, congratulations!");
            }

            System.out.print("Please enter 'rock', 'paper', or 'scissors' (or 'stop'): ");
            input = scanner.next();
        }
    }
}
