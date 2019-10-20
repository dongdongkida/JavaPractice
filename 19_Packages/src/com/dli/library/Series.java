package com.dli.library;

public class Series {
    public static long nSum(int n) {
        long sum = 0;
        for(int i=0; i<=n; i++) {
            sum+=i;
        }
        return sum;
    }

    public static long factorial(int n) {
        long sum=0;
        if(n==0) {
            sum = 0;
        }else{
            sum=1;
            for(int i=1; i<=n; i++) {
                sum*=i;
            }
        }
        return sum;
    }

    public static long fibonacci(int n) {
        long fibonacci;
        if(n==0) {
            fibonacci=0;
        } else if(n==1) {
            fibonacci=1;
        } else {
            fibonacci =fibonacci(n-1) + fibonacci (n-2);
        }

        return fibonacci;
    }

}
