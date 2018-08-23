package net.paulacr.rxjavastudies

import io.reactivex.Observable


class Repository {

    lateinit var movieObs: Observable<String>

    fun getMovies(page: String) : Observable<String> {
        movieObs = Observable.just("test")
        return movieObs
    }
}