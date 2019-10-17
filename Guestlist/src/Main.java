import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static ArrayList<String> guests = new ArrayList <String>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        insertTestNames();

        do {
            displayGuests();
            displayMenu();
            int option = getOption();

            if (option == 1) {
                addGuest();
            }

            else if (option == 2) {
                removeGuest();
            }

            else if (option == 3) {
                renameGuest();
            }

            else if (option == 4) {
                System.out.println("Exiting ....");
                break;
            }
        } while (true);
    }

    static void displayGuests() {
        if (guests.size() == 0) {
            System.out.println("\nGuest list is empty!");
        }
        else {
            System.out.println("____________________________\n");
            System.out.println(" - Guests - ");
            for (int i = 0; i < guests.size(); i++) {
                System.out.println((i+1) + ". " + guests.get(i));
            }
        }
    }

    static void displayMenu() {
        System.out.print("____________________________\n  - Menu -\n");
        System.out.println("1 - Add Guest");
        System.out.println("2 - Remove Guest");
        System.out.println("3 - Rename Guest");
        System.out.println("4 - Exit");
    }

    static int getOption() {
        System.out.print("Option: ");
        System.out.println();
        return scanner.nextInt();
    }

    static void addGuest() {
        System.out.println("Please enter guest's name to add");
        scanner.nextLine(); // this is to clear the keyboard buffer, otherwise you will get empty output.
        guests.add(scanner.nextLine());
    }
    //check if the name typed in exited in list, yes, find the index for that name and remove it; no then show error information
    static void removeGuest() {
        System.out.println("Please enter guest's number to remove guest name: ");
        int numRemove = scanner.nextInt();
        if (numRemove <= guests.size() && numRemove >= 1) {
            guests.remove(numRemove -1);
        }
        else {
            System.out.println("The guest is not in our guest list.");
        }
    }

    static void insertTestNames() {
        String [] testName = {"Dong Li", "Robert Jones", "Joseph Neil", "Fatima Goose"};
        guests.addAll(Arrays.asList(testName)); //Append all of elements in the specified collection to the end of this list
    }

    static void renameGuest() {
        System.out.println("Please enter guest's number you want to edit: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter guest's name: ");
        String name = scanner.nextLine();
        guests.set(num-1,name);
    }

}
