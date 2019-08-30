package com.example.juslt.retorfitdemo.thread;

/**
 * Created by Juslt on 2019/8/2
 */
public class Subtract {
    private final String lock;

    public Subtract(String lock) {
        this.lock = lock;
    }

    public void subtract() {

        try {
            synchronized (lock) {
                while (MyRun.list.size() == 0) {
                    System.out.println("subtract start " +Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("subtract end " +Thread.currentThread().getName());
                }
                MyRun.list.remove(0);
                System.out.println("subtract end size = " + MyRun.list.size());
            }
        } catch (InterruptedException e) {

        }
    }
}
