import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
	for(int i = 1; i <=10; i++) {

	    if(i==3){
	        continue;
        }

	    if(i==8){
	        break;
        }

	    System.out.println(i);
    }
		Scanner scanner = new Scanner(System.in);
		String again;

		do {
			int num = ThreadLocalRandom.current().nextInt(1,7);
			System.out.println("You rolled a " + num + ".");
			System.out.println("Do you like to roll again? y/n: ");
			again = scanner.next();
		} while(again.equals("y"));



    }
}
