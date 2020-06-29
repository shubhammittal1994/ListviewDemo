package com.sampleapp.module.application

import android.app.Application
import android.content.Context
import com.sampleapp.R
import com.sampleapp.module.listview.ListViewActivity
import com.sampleapp.module.listview.ListViewComponent
import com.sampleapp.module.listview.ListviewModule
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import io.github.inflationx.viewpump.ViewPumpContextWrapper

/**
 * Created by Shubham_mittal on 27-Jun-20.
 */
class SampleApplication : Application() {

    private var listViewComponent: ListViewComponent? = null

    override fun onCreate() {
        super.onCreate()

        ViewPump.init(ViewPump.builder()
                .addInterceptor(CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/roboto_regular.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build())).build())

    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    //create app component
    private fun createAppComponent(): AppComponent {
        return DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    //create login component
    fun createLoginComponent(listViewActivity: ListViewActivity): ListViewComponent? {
        listViewComponent = createAppComponent().plus(ListviewModule(listViewActivity))
        return listViewComponent
    }

    //release created login component
    fun releaseLoginComponent() {
        listViewComponent = null
    }
}