package com.example.juslt.retorfitdemo.product_consumer;

/**
 * Created by Juslt on 2019/8/2
 */
public class Consumer {
    private final String lock ;
    public Consumer(String lock){
        this.lock = lock;
    }

    public void getValues(){
        try {
            synchronized (lock){
                if(StringValue.string.equals("")){
                    lock.wait();
                }

                String value = StringValue.string;
                System.out.println(value);
                StringValue.string = "";
                lock.notify();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
