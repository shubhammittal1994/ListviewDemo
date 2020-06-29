package com.sampleapp.mvp

import android.support.annotation.StringRes

/**
 * Created by Shubham_mittal on 27-Jun-20.
 */
interface BaseMvpView {

    fun showError(throwable: Throwable)

    fun showError(@StringRes stringResId: Int)

    fun showError(error: String)

    fun showMessage(@StringRes srtResId: Int)

    fun showMessage(message: String)

}
