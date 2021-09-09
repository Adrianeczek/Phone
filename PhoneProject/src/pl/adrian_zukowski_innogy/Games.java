package pl.adrian_zukowski_innogy;

import java.util.Random;
import java.util.Scanner;

public class Games {
    public void guessTheNumber() {

        boolean playAgain = false;
        boolean correctNumber = false;


        while (!playAgain) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            System.out.println("Try to guess the number from 0 to 100!");


            while (!correctNumber) {
                System.out.println("Write your number");
                int choice = scanner.nextInt();

                if (choice < i) {
                    System.out.println("Your number is to small.");
                } else if (choice > i) {
                    System.out.println("Your number is to big");
                } else {
                    System.out.println("Congrats! You guessed the number");
                    System.out.println("Do you wat to play again? Write Y (YES) or N (NO)");
                    String s = scanner.nextLine();
                    if (s.equals("Y")) {
                        playAgain = true;
                    } else if (s.equals("N"))
                        correctNumber = true;
                }
            }
        }


    }
}
