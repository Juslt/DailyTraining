package com.example.juslt.retorfitdemo.abstract_1;

import java.util.Objects;

/**
 * Created by Juslt on 2019/7/30
 */
public class TestClassInterface {
    public static void main(String[] args) {
        Objects.requireNonNull(InterfaceFactory.createInstance(DefaultMethodClass::new)).defaltMethod();
        Objects.requireNonNull(InterfaceFactory.createInstance(OverideMethodClass::new)).defaltMethod();
    }
}
