package com.sampleapp.utils

import android.content.Context
import android.support.annotation.DrawableRes
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.sampleapp.R
import com.squareup.moshi.Moshi
import com.squareup.picasso.Picasso
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

/**
 * Created by Shubham_mittal on 27-Jun-20.
 */
object Extensions {

    //return error message from webservice error code
    fun Throwable.getErrorMessage(context: Context): String {
        return if (this is HttpException || this is UnknownHostException
                || this is ConnectException) {
            context.resources.getString(R.string.warning_network_error)
        } else {
            context.resources.getString(R.string.error_occurred)
        }
    }
    //convert to response using Moshi
    inline fun <reified T> Moshi.fromJson(json: String): T? = this.adapter(T::class.java).fromJson(json)

}


