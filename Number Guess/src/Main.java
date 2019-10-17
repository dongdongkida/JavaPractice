import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        System.out.println("Number Guess");
        System.out.println("Just pick a number between 1 - 100, and keep it in your mind. Then let computer to guess it.");
        System.out.println("You just type 'higher' if the program guess too low, or 'lower' if too high, or 'correct' if he get your number");
        System.out.println("Are you ready, let's go!");

        Scanner scanner = new Scanner(System.in);

        // games begin

        int max = 100;
        int min = 1;

        // comprare the anwers to prepare for next guess, if answer is not correct, stay in while loop
        while (true) {

            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
            System.out.println(" Your number is: " + randomNum);
            String answer = scanner.next();

            if (answer.equals("higher")) {
                min = randomNum + 1;
            } else if (answer.equals("lower")) {
                max = randomNum - 1;
            } else if (answer.equals("correct")) {
                System.out.println("Hooray, Your number is " + randomNum + ", I know I can get it.");
                break;
            } else {
                System.out.println("Please type 'higher' if guess is too low, 'lower' if it's too high, and 'correct' if it's correct guess.");
                answer = scanner.next();
            }

            //This if statement checks to see if it's still possible to win

            if (min == max + 1) {
                System.out.println("It's not possible. Let's try it again.");
                min = 1;
                max = 100;

            }
        }


    }
}
