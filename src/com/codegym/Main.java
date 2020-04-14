package com.codegym;

public class Main {
    public static void main(String[] args) {
        LazyPrimeFactorization lazyPrime = new LazyPrimeFactorization(20);
        OpimizedPrimeFactorization opimizedPrime = new OpimizedPrimeFactorization(20);

        Thread t1 = new Thread(lazyPrime, "LPF");
        Thread t2 = new Thread(opimizedPrime, "OPF");

        t1.start();
        t2.start();
    }
}
