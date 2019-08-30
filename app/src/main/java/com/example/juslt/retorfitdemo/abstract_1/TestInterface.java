package com.example.juslt.retorfitdemo.abstract_1;

/**
 * Created by Juslt on 2019/7/30
 */
public interface TestInterface {
    void method();
    default void defaltMethod(){
        System.out.println("default method");
    }
}
