import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number of students took the exam: ");
        int numOfStudents = scanner.nextInt();

        System.out.println("Please enter the maximum score: ");
        int maxScore = scanner.nextInt();

        System.out.println("Please enter each students' score: ");
        int[] score = new int[numOfStudents];

        //asking for score for each student
        for(int i = 0; i<numOfStudents;i++) {
             System.out.print("Student "+ (i+1) +" score: ");
             score[i] = scanner.nextInt();
        }

        //Display each student's score and percentage
        int sum = 0;
        for(int i = 0; i<numOfStudents;i++) {
            System.out.format("Student%d's score: %d. Percentage of exam is %.2f%%.\n", i+1, score[i], 100*(double)score[i]/maxScore);
            sum += score[i];
        }
        double mean = (double) sum/score.length;
        System.out.println("Mean: " + mean);


    }
}
