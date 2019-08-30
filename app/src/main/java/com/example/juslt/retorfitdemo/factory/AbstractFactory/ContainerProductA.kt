package com.example.juslt.retorfitdemo.factory.AbstractFactory

import android.util.Log

/**
 * Created by Juslt on 2019/7/17
 */
class ContainerProductA:AbstractProducts(){
    override fun show() {
        Log.e("===","生产容器A")
    }

}