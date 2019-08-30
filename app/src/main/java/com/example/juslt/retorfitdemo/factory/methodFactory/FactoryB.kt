package com.example.juslt.retorfitdemo.factory.methodFactory

/**
 * Created by Juslt on 2019/7/17
 */
class FactoryB: AbstractFactory {
    override fun createProduct(): AbstractProduct {
        return ProductB()
    }

}