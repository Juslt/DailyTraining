package com.example.juslt.retorfitdemo.thread;

/**
 * Created by Juslt on 2019/8/2
 */
public class Add {
    private final String lock;

    public Add(String lock) {
        this.lock = lock;
    }

    public void add(){
        synchronized (lock){
            MyRun.list.add("addString");
            lock.notifyAll();
        }
    }
}
