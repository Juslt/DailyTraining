package com.example.juslt.retorfitdemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.juslt.retorfitdemo.GankBean
import com.example.juslt.retorfitdemo.R
import com.example.juslt.retorfitdemo.RequestInterface
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_rx.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.util.concurrent.TimeUnit

class RxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx)

        btn_simple.setOnClickListener {
            simpleRxJava()
        }

        btn_interval.setOnClickListener {
            intervalReq()
        }

        btn_error.setOnClickListener {
            handleError()
        }
        btn_retry_when.setOnClickListener {
            retryWhen()
        }

    }

    private fun retryWhen() {
        Observable.create(ObservableOnSubscribe <Int>{
            it.onNext(1)
            it.onNext(2)
            it.onError(Exception("发送错误信息"))

        }).retryWhen(object :Function<Observable<Throwable>,ObservableSource<Int>>{
            override fun apply(t: Observable<Throwable>): ObservableSource<Int> {
             return t.flatMap(object :Function<Throwable,ObservableSource<Int>>{
                 override fun apply(t: Throwable): ObservableSource<Int> {
                     return Observable.error(Throwable("retryWhen终止"))
//                     return Observable.just(1)
                 }

             })
            }

        }).subscribe(object :Observer<Int>{
            override fun onComplete() {
                Log.e("====", "onComplete")
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Int) {
                Log.e("====", "接收到了事件$t")
            }

            override fun onError(e: Throwable) {
            }

        })
    }

    private fun handleError() {
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onError(Throwable())
        }).onErrorReturn(object : Function<Throwable, Int> {
            override fun apply(t: Throwable): Int {
                Log.e("====","onErrorResumeNext")
                return 11
            }
        }).subscribe(object : Observer<Int> {
            override fun onComplete() {
                Log.e("====","onComplete")
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Int) {
                Log.e("====","onNext->$t")
            }

            override fun onError(e: Throwable) {
                Log.e("====","onError")
            }

        })
    }

    private fun intervalReq() {
        Observable.intervalRange(0, 10, 1, 1, TimeUnit.SECONDS)
            .doOnNext {
                Log.e("====", "进行第${it}次轮询")

                val retrofit = Retrofit.Builder()
                    .baseUrl("http://gank.io/api/data/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val request = retrofit.create(RequestInterface::class.java)
                request.gankImages()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : Observer<GankBean> {
                        override fun onComplete() {
                        }

                        override fun onSubscribe(d: Disposable) {
                        }

                        override fun onNext(t: GankBean) {
                            Log.e("====", "服务器返回数据——>${t.results[0].url}")
                        }

                        override fun onError(e: Throwable) {
                        }

                    })


            }.subscribe(object : Observer<Long> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: Long) {
                }

                override fun onError(e: Throwable) {
                }

            })
    }

    private fun simpleRxJava() {
        val observable = Observable.create(ObservableOnSubscribe<String> {
            it.onNext("A")
            it.onNext("B")
            it.onNext("C")
            it.onComplete()
        })

        val observer = object : Observer<String> {
            override fun onComplete() {
                Log.e("====", "onComplete")
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: String) {
                Log.e("====", "onNext->$t")
            }

            override fun onError(e: Throwable) {
            }

        }
        observable.subscribe(observer)
    }
}
