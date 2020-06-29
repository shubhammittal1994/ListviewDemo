package com.sampleapp.module.listview

import com.sampleapp.api.RestService
import com.sampleapp.utils.ProgressBarHandler
import dagger.Module
import dagger.Provides

/**
 * Created by Shubham_mittal on 27-Jun-20.
 */
@Module
class ListviewModule(private var listViewActivity: ListViewActivity) {
    @Provides
    fun getPresenter(restService: RestService): ListViewPresenter = ListViewPresenter(restService,  listViewActivity)

    @Provides
    fun getProgressBar(): ProgressBarHandler {
        return ProgressBarHandler(listViewActivity)
    }
}