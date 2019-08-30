package com.example.juslt.retorfitdemo.product_consumer;

/**
 * Created by Juslt on 2019/8/2
 */
public class Product {
    private final String lock;

    public Product(String lock) {
        this.lock =lock;
    }

    public void setValue(){
        try{
            synchronized (lock){
                if(!StringValue.string.equals("")){
                    lock.wait();
                }

                long time = System.currentTimeMillis();
                StringValue.string = time+"";
                Thread.sleep(1000);
                lock.notify();
            }

        }catch (InterruptedException e){

        }

    }
}
