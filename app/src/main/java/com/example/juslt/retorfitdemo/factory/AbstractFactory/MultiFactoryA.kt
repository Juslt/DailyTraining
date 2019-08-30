package com.example.juslt.retorfitdemo.factory.AbstractFactory

/**
 * Created by Juslt on 2019/7/17
 */
class MultiFactoryA : AbstractFactorys() {
    override fun createTypeA(): AbstractProducts {
        return ContainerProductA()
    }

    override fun createTypeB(): AbstractProducts {
        return MuduleProductA()
    }

}