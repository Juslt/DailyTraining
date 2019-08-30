package com.example.juslt.retorfitdemo;

/**
 * Created by Juslt on 2019/8/27
 */
public class ExtendDemo {
    private String a = "parent";
    public void print(String a){
        System.out.printf(a);
    }

    static class Child{
        private String a = "child";
        public void print(String a){
            System.out.printf(a);
        }
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.print(child.a);

    }
}
