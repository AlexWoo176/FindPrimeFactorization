package com.codegym;

public class OpimizedPrimeFactorization implements Runnable {
    private int number;

    public OpimizedPrimeFactorization(int number) {
        this.number = number;
    }

    public boolean isPrime(int inputNumber){
        if (inputNumber >= 2){
            for (int i = 2; i <= inputNumber / 2; i++){
                if (inputNumber % i == 0){
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
