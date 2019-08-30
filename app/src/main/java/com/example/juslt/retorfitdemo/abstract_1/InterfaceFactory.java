package com.example.juslt.retorfitdemo.abstract_1;

import android.os.Build;

import java.util.function.Supplier;

/**
 * Created by Juslt on 2019/7/30
 */
public interface InterfaceFactory {
    static TestInterface createInstance(Supplier<TestInterface> supplier){
            return supplier.get();
    }
}
