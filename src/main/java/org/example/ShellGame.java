package org.example;

import java.util.*;

public class ShellGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Display display = new Display();

        System.out.println("\n______________________________________");
        System.out.println("|     Welcome To My Shell Game        |");
        System.out.println("|Try to guess which hat the ball is in|");
        System.out.println("|Magician hats are numbered 1, 2 and 3|");
        System.out.println("_______________________________________\n");


        System.out.print("\nHow many rounds would you like to play? ");

        int rounds = scanner.nextInt();

        int wins = 0;

        for (int i = 1; i <= rounds; i++) {
            System.out.println("\n    Round " + i + "    ");

            display.showFrame();



            int correctShell = random.nextInt(3) + 1;
            display.setBallInCup(correctShell);


            System.out.print("Shuffling the \uD83C\uDFA9" + "\n");
            System.out.println("\n_________________");
            System.out.println("\n");

                for (int x = 0; x < 3; x++) {
                    System.out.print("  \uD83C\uDFA9  ");
                }
            System.out.println("\n");
            System.out.println("\n____________________");



            System.out.print("\n" + "Guess the hat using number (1, 2, or 3): ");
            int guess = scanner.nextInt();


            if (guess == correctShell) {
                System.out.println("Correct the ball was under the hat " + correctShell );
                wins++;
            } else {
                System.out.println("Wrong the ball was under hat " + correctShell );
            }
            display.restCups();
        }
        System.out.println("Your score is " + wins + " out of " + rounds + "!!!!" );

        scanner.close();
    }
}
