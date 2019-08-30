package com.example.juslt.retorfitdemo

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Juslt on 2019/6/1
 */
interface RequestInterface{
    @GET("%E7%A6%8F%E5%88%A9/20/2")
    fun gankAPI(): Call<GankBean>

    @GET("%E7%A6%8F%E5%88%A9/20/2")
    fun gankImages(): Observable<GankBean>
}