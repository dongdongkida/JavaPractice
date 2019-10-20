import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What's your name?");
        String userName = scanner.nextLine();
        System.out.println(userName + " is a nice name!");

        System.out.println("\n" + userName + ", how old are you?");
        int userAge = scanner.nextInt();
        System.out.println("You are " + userAge + " years old.");


        System.out.println("\nHow tall you are?");
        double userHeight = scanner.nextDouble();
        System.out.println("You are " + userHeight + " meters tall.");

        System.out.format("\nI have %d cats, 1 %s, and %.1f apple", 1, "dog",0.87);

        System.out.println("\nYou have lived " + userAge + " years. In another " + userAge + " years you'll be " + 2*userAge + " old.");

        System.out.format("\nYou have lived %d years. In another %d years you'll be %d years old.", userAge, userAge, 2*userAge);

        System.out.format("Your name has %d charaters.", userName.length());
    }
}
