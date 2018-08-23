package net.paulacr.rxjavastudies

import android.util.Log
import android.widget.Button
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import rx.Subscription
import java.util.*
import java.util.concurrent.TimeUnit


const val TAG = "RxJava"

class Basics {

    fun runRxJava() {

        val days = arrayOf("friday", "saturday", "sunday")
        val observable = Observable.just("test")


        /**
         *  .subscribe returns a subscription
         */

        Observable.fromArray(days).subscribe(
                { next ->
                    Log.i(TAG, "onNext ${next.asList()}")
                },
                { error ->
                    Log.i(TAG, "onError $error")
                },
                {
                    Log.i(TAG, "onComplete")
                })

        Observable.fromArray("red", "orange", "blue").doOnNext { color ->
            Log.i(TAG, "doOnNext Color = $color")
        }.subscribe {
            Log.i("TAG", "subscribing color = $it")
        }
    }

    fun Button.debounceButton(lenght: Long, unit: TimeUnit) {
        isEnabled = false

        Observable.timer(lenght, unit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe() {
                    isEnabled = true
                }
    }

    fun downloadStuff() {

//        return Observable.create<Unit> {s ->
//            val outputFile = writeOutputFile(mediaFile)
//
//            when (type) {
//                Type.Photo
//
//            }
//
//        }
    }

}
