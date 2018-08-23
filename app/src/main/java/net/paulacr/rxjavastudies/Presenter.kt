package net.paulacr.rxjavastudies

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.subjects.BehaviorSubject

class Presenter(val viewInterface: ViewInterface) {

    companion object {
        const val TAG = "RxJava"
    }

    lateinit var subject: BehaviorSubject<Int>
    var repository: Repository = Repository()

    init {
        subject = viewInterface.onRequestMorePages()
        subscribe()
    }

    val observable: Observable<String> = Observable.just("value")

    fun subscribe() {

        Log.i(TAG, "calling subscribe method in presenter")
        subject.subscribe { page ->

            Log.i(TAG, "subscribe subject called")
            repository.getMovies(page.toString()).subscribe {
                Log.i(TAG, "result: $it")
                //show movies on view ex: view.showMovies(it)
            }
        }

        Log.i(TAG, "on next page called")
        subject.onNext(1)


        Log.i(TAG, "on next page 2 called")
        subject.onNext(2)

        val observer: Observer<String>

//        subject.doOnNext { page ->
//            repository.getMovies(page.toString()).subscribe {
//                Log.i(TAG, "get more movies called from doOnNext() call ")
//            }
//        }

//        observable.subscribe {
//            Log.i(TAG, "subcribing to observable")
//        }
    }


}