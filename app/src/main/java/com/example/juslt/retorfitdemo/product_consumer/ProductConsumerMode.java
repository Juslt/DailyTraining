package com.example.juslt.retorfitdemo.product_consumer;

/**
 * Created by Juslt on 2019/8/2
 */
public class ProductConsumerMode {
    public static void main(String[] args) {
        String lock = "";
        Product product = new Product(lock);
        Consumer consumer = new Consumer(lock);

        new Thread(() -> {
                   while (true){
                       product.setValue();
                   }
        }).start();

        new Thread(() -> {
            while (true){
                consumer.getValues();
            }
        }).start();

        while (true){

        }
    }
}
