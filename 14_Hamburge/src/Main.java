import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static String[] additionsChoice = {" Lettuce", "Tomato", "Pickles", "Extra Cheese", "Spinach", "Cabbage"};
    private static Double[] additionsPrice = {0.5, 0.5, 0.5, 0.3, 0.5, 0.5};

    public static void main(String[] args) {

        Hamburger hamburger = new Hamburger("Base","Plain Roll","Pork",5.0);
        HealthyBurger healthyBurger = new HealthyBurger("Healthy Burger","Brown Rye Bread Roll","Beef", 6.5);
        DeluxeBurger deluxeBurger = new DeluxeBurger("Deluxe Burger","Brown Rye Bread Roll","Beef", 8.0);
        double price = 0;
        System.out.println("Welcome to visit Bill's Burger Store, we have best burger in town.");
        System.out.println("What would you like to order, please enter the number in front of your choice.");
        showBurgerMenu();
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choose(3,choice)) {
            switch(choice) {
                case 1:
                    int counter = 0; //reset the counter to 0
                    price += hamburger.getPrice();
                    System.out.println(hamburger.getName() + " selected, and price is " + price);
                    showAdditionMenu(4); // show additions' menu
                    System.out.println("What additions you like to add, please enter the number in front of you choice.\nIf you are done, please enter '0' to finish ordering.");
                    do {
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        if (choice==0) {
                            System.out.println("Thanks for your order, and total price is " + price);
                            break;
                        } else if (choose(4,choice) && counter<4) {
                            price = addChoice(choice,price); // add addition's price
                            counter++;
                            System.out.println(additionsChoice[choice-1] + " selected, with extra " + additionsPrice[choice -1]);
                        } else if (counter>=4){
                            System.out.println("Maximum choice reached, please enter '0' to confirm the order");
                        } else {
                            System.out.println(ERROR_MESSAGE);
                        }
                    } while (choice!=0);
                    break;
                case 2:
                    counter = 0;
                    price += healthyBurger.getPrice();
                    System.out.println(healthyBurger.getName() + " selected, and price is " + price);
                    showAdditionMenu(6); // show additions' menu
                    System.out.println("What additions you like to add, please enter the number in front of you choice.\n " +
                            "If you are done, please enter '0' to finish ordering. ");
                    do {
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        if (choice==0) {
                            System.out.println("Thanks for your order, and total price is " + price);
                            break;
                        } else if (choose(6,choice) && counter<6) {
                            price = addChoice(choice,price);
                            counter++;
                            System.out.println(additionsChoice[choice-1] + " selected, with extra " + additionsPrice[choice -1]);
                        } else if (counter>=6){
                            System.out.println("Maximum choice reached, please enter '0' to confirm the order");
                        } else {
                            System.out.println(ERROR_MESSAGE);
                        }
                    } while (choice!=0);
                    break;
                case 3:
                    counter = 0;
                    price += deluxeBurger.getPrice();
                    System.out.println(deluxeBurger.getName() + " selected, and price is " + price +". Chips and drink included in meal");
                    showAdditionMenu(4); // show additions' menu
                    System.out.println("What additions you like to add, please enter the number in front of you choice.\n" +
                            "If you are done, please enter '0' to finish ordering.");
                    do {
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        if (choice==0) {
                            System.out.println("Thanks for your order, and total price is " + price);
                            break;
                        } else if (choose(4,choice) && counter<4) {
                            price = addChoice(choice,price);
                            counter++;
                            System.out.println(additionsChoice[choice-1] + " selected, with extra " + additionsPrice[choice -1]);
                        } else if (counter>=4){
                            System.out.println("Maximum choice reached, please enter '0' to confirm the order");
                        } else {
                            System.out.println(ERROR_MESSAGE);
                        }
                    } while (choice!=0);
                    break;
            }
        } else {
            System.out.println(ERROR_MESSAGE);
        }
    }

    //show additions' menu base with parameter of choice we have
    private static void showAdditionMenu (int number) {
        for (int i = 1; i <= number; i++) {
            System.out.println(i + ". " + additionsChoice[i-1] + "   + " + additionsPrice[i-1]);
        }
    }
    //add addition's price into total price
    private static double addChoice(int choice, double price) {
        price += additionsPrice[choice-1];
        return price;
    }

    private static void showBurgerMenu() {
        System.out.println("1. Regular Burger");
        System.out.println("2. Healthy Burger");
        System.out.println("3. Deluxe Burger");
    }
    // check if an valid enter
    private static boolean choose (int maximumChoice, int choice) {
        if(choice>0 && choice <= maximumChoice)
            return true;
        else
            return false;
    }
    //show error information
    private static final String ERROR_MESSAGE = "Invalid Choice, Please only choose the number in front of your choice: ";
}
