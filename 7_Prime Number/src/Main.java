public class Main {

    public static void main(String[] args) {
        for (int num = 2; num <1000000; num++) {
            boolean isPrime = true;
            //Checking any specific number is prime or not. Test
            for (int div = 2; div*div < num; div++) {
                if (num % div == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                System.out.println(num +" is Prime");
            }
        }
    }
}
