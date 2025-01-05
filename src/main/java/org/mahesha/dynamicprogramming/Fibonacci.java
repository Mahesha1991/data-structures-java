package org.mahesha.dynamicprogramming;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        int fibNum = 50;
        long [] fibNumArray = new long[fibNum + 1];


        long start = System.currentTimeMillis();
        System.out.println("Without Memoization(Caching) : " + fib.withOutMemoization(fibNum));
        long end = System.currentTimeMillis();
        System.out.println("Time : " + (end - start));
        System.out.println();

        start = System.currentTimeMillis();
        System.out.println("With Memoization(Caching) : " + fib.withMemoization(fibNum, fibNumArray));
        end = System.currentTimeMillis();
        System.out.println("Time : " + (end - start));

    }

    private long withOutMemoization(int n) {
        if(n <= 1) {
            return n;
        }

        return withOutMemoization(n - 1) + withOutMemoization(n - 2);
    }

    private long withMemoization(int n, long [] cache) {

        if(n <= 1){
            return n;
        }

        if(cache[n] != 0){
            return cache[n];
        }

        cache[n] = withMemoization(n - 1, cache) + withMemoization(n - 2, cache);

        return cache[n];
    }
}
