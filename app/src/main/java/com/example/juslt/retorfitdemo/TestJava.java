package com.example.juslt.retorfitdemo;

import com.example.juslt.retorfitdemo.thread.Add;
import com.example.juslt.retorfitdemo.thread.MyRun;
import com.example.juslt.retorfitdemo.thread.Subtract;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;

/**
 * Created by Juslt on 2019/7/16
 */


public class TestJava {
    private String a = "a";
    public static void main(String[] args) throws InterruptedException {
//        MyRun run = new MyRun();
//        new Thread(run.run).start();
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        run.notifyRun();

        String lock = new String("");
        Subtract subtract = new Subtract(lock);
        Thread  subThread01 = new Thread(subtract::subtract,"substract---01");
        subThread01.start();
        Thread  subThread02 = new Thread(subtract::subtract,"substract---02");
        subThread02.start();

        Thread.sleep(200);
        Add add = new Add(lock);
        add.add();
        add.add();

    }

    class InnerClass{
        public void showA(){
            a = "b";
        }
    }

}
