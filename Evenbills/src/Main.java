import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dear customer,how much is total bill?");
        double totalBill = scanner.nextDouble();

        System.out.println("How many people you have?");
        int numberOfPeople = scanner.nextInt();

        System.out.format("This is how much you need to pay for everybody: %.2f", totalBill/numberOfPeople);
    }
}
