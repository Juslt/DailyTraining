package com.example.juslt.retorfitdemo.adapter

/**
 * Created by Juslt on 2019/7/17
 */
class Adapter : Adapee(), Target {
    override fun request() {
        this.requestText()
    }

}