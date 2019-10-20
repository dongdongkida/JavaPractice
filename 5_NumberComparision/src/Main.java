import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number for X:  ");
        int X = scanner.nextInt();

        System.out.println("Please enter another number for Y: ");
        int Y = scanner.nextInt();

        if(X>Y) {
            System.out.println("X is bigger than Y.");
        }
        else if (X<Y) {
            System.out.println("X is smaller than Y.");
        }
        else {
            System.out.println("X and Y are the equal.");
        }
    }
}



