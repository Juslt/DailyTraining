package com.example.juslt.retorfitdemo.factory.AbstractFactory

/**
 * Created by Juslt on 2019/7/17
 */
class MultiFactoryB:AbstractFactorys(){
    override fun createTypeA(): AbstractProducts {
        return ContainerProductB()
    }

    override fun createTypeB(): AbstractProducts {
        return MuduleProductB()
    }

}