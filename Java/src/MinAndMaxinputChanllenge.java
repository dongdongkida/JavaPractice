import java.util.Scanner;

public class MinAndMaxinputChanllenge {

    public static void minAndMaxInput () {
        Scanner scanner = new Scanner(System.in);
        int min = 0;
        int max = 0;
        boolean first = true;

        while(true) {
            System.out.println("Enter number");
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                int number = scanner.nextInt();
                if (first) {
                    first = false;
                    min = number;
                    max = number;
                }

                if ( number < min)
                    min = number;

                if (number > max)
                    max = number;

            } else {
                break;
            }
            scanner.nextLine(); // handle input
        }
        System.out.println("The maximum number you enter is: " + max);
        System.out.println("The minimum number you enter is: " + min);

        scanner.close();
    }
}
