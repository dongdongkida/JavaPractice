import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String [] questions = new String[] {
        "The moon is further away from the earth than the sun is",
        "Goldfish only have a three second memory",
        "Microwaves have a longer wavelength than ultraviolet",
        "Antibiotics are used to treat viral infections",
        "Octopuses have three hearts"};

        boolean [] answers = new boolean[] {
                false,
                false,
                false,
                false,
                true
        };

        boolean [] userAnswers = new boolean [5];

        Scanner scanner = new Scanner(System.in);

        //Show user the question, and ask for answer

        System.out.println("Please type in false/true to finish the quiz below.");

        for (int i = 0; i < 5; i++ ) {
            System.out.println(questions[i]);
            userAnswers[i] = scanner.nextBoolean();
        }

        //Compare the user's answer with correct answer and show the result

        int score = 0;
        for (int i = 0; i < 5; i++) {
            if(userAnswers[i] == answers [i]) {
                System.out.println(questions[i] + " " + userAnswers[i] + "\n You are correct.");
                score += 20;
            }
            else {
                System.out.println(questions[i] + " " + userAnswers[i] + " \n You got wrong anwser.");
            }
        }

        System.out.println(" You final score: " + score);
    }
}
