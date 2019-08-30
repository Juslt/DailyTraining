package com.example.juslt.retorfitdemo.factory.simpleFactory

import com.example.juslt.retorfitdemo.factory.methodFactory.AbstractProduct
import com.example.juslt.retorfitdemo.factory.methodFactory.ProductA
import com.example.juslt.retorfitdemo.factory.methodFactory.ProductB

/**
 * Created by Juslt on 2019/7/17
 */
class StaticFactory {
    companion object {
        fun createProduct(productName: String): AbstractProduct {
            when (productName) {
                "A" -> {
                    val productA = ProductA()
                    return productA
                }
                "B" -> {
                    val productB = ProductB()
                    return productB
                }
            }
            return ProductB()
        }
    }
}