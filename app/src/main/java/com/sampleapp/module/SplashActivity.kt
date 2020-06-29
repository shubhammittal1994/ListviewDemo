package com.sampleapp.module

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sampleapp.R
import com.sampleapp.module.listview.ListViewActivity
import rx.Observable
import rx.Subscription
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {
    /**
     * subscription to Observe our timer Observable
     */
    private var mSubscriber: Subscription? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //start next activity after delay of 3 seconds
        mSubscriber = Observable.timer(3, TimeUnit.SECONDS).subscribe {
            startActivity(Intent(this, ListViewActivity::class.java))
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mSubscriber?.unsubscribe()
    }
}
