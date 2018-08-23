package net.paulacr.rxjavastudies

import io.reactivex.subjects.BehaviorSubject


interface ViewInterface {

    fun onRequestMorePages(): BehaviorSubject<Int>
}