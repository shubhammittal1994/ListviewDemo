package com.sampleapp.mvp

/**
 * Created by Shubham_mittal on 27-Jun-20.
 */
interface BaseMvpPresenter<in V : BaseMvpView> {

    fun attachView(view: V)

    fun detachView()
}