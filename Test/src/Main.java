import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String [] a = {"A","B","C","D"};
        List<String> list = Arrays.asList(a);
        System.out.println(list);
        System.out.println(a); //Array is reference type data

        ArrayList b = new ArrayList<>();
        b.addAll(list);

        System.out.println(b);

        Rectangle r1 = new Rectangle(5,9);
        r1.printArea();

    }
}
