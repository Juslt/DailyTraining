package com.example.juslt.retorfitdemo.factory.methodFactory

/**
 * Created by Juslt on 2019/7/17
 */
class FactoryA : AbstractFactory {
    override fun createProduct(): AbstractProduct {
        return ProductA()
    }

}