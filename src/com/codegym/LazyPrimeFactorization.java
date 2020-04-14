package com.codegym;

public class LazyPrimeFactorization implements Runnable {
    private int number;

    public LazyPrimeFactorization(int number) {
        this.number = number;
    }

    public boolean isPrime(int inputNumber) {
        if (inputNumber >= 2) {
            for (int i = 2; i < inputNumber; i++) {
                if (inputNumber % i == 0) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            synchronized (this) {
                if (isPrime(i)) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    notifyAll();
                }
            }
        }
    }
}
