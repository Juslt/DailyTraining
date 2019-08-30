package com.example.juslt.retorfitdemo.proxy

/**
 * Created by Juslt on 2019/7/17
 */
class Proxy : Subject {
    override fun buyMac() {
        val realSubject = ReaSubject()
        realSubject.buyMac()
    }

}