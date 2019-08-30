package com.example.juslt.retorfitdemo.thread;

import java.util.ArrayList;

/**
 * Created by Juslt on 2019/8/2
 */
public class MyRun {
    private final String lock = new String("");
    public static ArrayList<String> list = new ArrayList<>();
    public Runnable run = () -> {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName());
                lock.wait();
                System.out.println("a======");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    public void notifyRun(){
        synchronized (lock){
            lock.notify();
        }
    }
}
