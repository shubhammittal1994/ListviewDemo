package com.sampleapp.module.listview

import dagger.Subcomponent
/**
 * Created by Shubham_mittal on 27-Jun-20.
 */

@ListViewScope
@Subcomponent(modules = [(ListviewModule::class)])
interface ListViewComponent {
    fun inject(listViewActivity: ListViewActivity)
}