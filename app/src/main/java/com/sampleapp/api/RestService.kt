package com.sampleapp.api

import com.sampleapp.constants.ApiConstants
import com.sampleapp.data.response.APIResponse
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by Shubham_mittal on 27-Jun-20.
 */
interface RestService {


    @GET(ApiConstants.END_POINT)
    fun getData(): Observable<APIResponse>

}