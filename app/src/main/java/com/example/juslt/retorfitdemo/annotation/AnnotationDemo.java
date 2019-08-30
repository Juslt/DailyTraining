package com.example.juslt.retorfitdemo.annotation;

import java.lang.reflect.Method;

/**
 * Created by Juslt on 2019/7/29
 */
public class AnnotationDemo {
    public static void main(String[] args) {
        System.out.println("args = []");
        Method[] methods = AnnotationDemo.class.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if(methods[i].isAnnotationPresent(AnnotationTest.class)){
                AnnotationTest annotation = methods[i].getAnnotation(AnnotationTest.class);
                System.out.println(methods[i].getName());
                System.out.println(annotation.a());
                System.out.println(annotation.show());
            }

        }
    }

    @AnnotationTest(a = 100, show = "method1")
    public void method1() {

    }

    @AnnotationTest
    public void defaultMethod() {

    }

    @Deprecated
    public void test(){

    }
}
