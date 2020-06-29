package com.sampleapp.mvp

import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.sampleapp.utils.Extensions.getErrorMessage

/**
 * Created by Shubham_mittal on 27-Jun-20.
 */
 abstract class BaseMvpActivity
    : AppCompatActivity(), BaseMvpView {

    override fun showError(throwable: Throwable) {
        Toast.makeText(this, throwable.getErrorMessage(this), Toast.LENGTH_SHORT).show()
    }

    override fun showError(stringResId: Int) {
        Toast.makeText(this, stringResId, Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(srtResId: Int) {
        Toast.makeText(this, srtResId, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}