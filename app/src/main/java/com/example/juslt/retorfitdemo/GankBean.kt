package com.example.juslt.retorfitdemo

/**
 * Created by Juslt on 2019/6/1
 */

data class GankBean(
    val error:Boolean,
    val results:List<GankData>
)
data class GankData(
    val id:String,
    val url:String
)