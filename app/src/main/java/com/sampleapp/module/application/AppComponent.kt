package com.sampleapp.module.application

import com.sampleapp.api.NetModule
import com.sampleapp.module.listview.ListViewComponent
import com.sampleapp.module.listview.ListviewModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Shubham_mittal on 27-Jun-20.
 */
@Singleton
@Component(modules = [(AppModule::class), (NetModule::class)])
interface AppComponent {

    fun plus(listviewModule: ListviewModule): ListViewComponent

}