public class Loops {


    public static void main(String[] args) {
        for (int i=1; i<=40; i++) {
            if (i%3 == 0){
                System.out.println("Quack");
                continue;
            }
            System.out.println(i);
        }
    }
}
