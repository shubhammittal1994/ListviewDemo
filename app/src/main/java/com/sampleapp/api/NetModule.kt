package com.sampleapp.api

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Shubham_mittal on 27-Jun-20.
 */
@Module
class NetModule {

    @Provides
    @Singleton
    fun getRestService() = ApiManager.create()
}