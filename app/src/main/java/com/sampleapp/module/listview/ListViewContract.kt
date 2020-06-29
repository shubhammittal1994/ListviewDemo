package com.sampleapp.module.listview

import com.sampleapp.data.response.APIResponse
import com.sampleapp.mvp.BaseMvpPresenter
import com.sampleapp.mvp.BaseMvpView

/**
 * Created by Shubham_mittal on 27-Jun-20.
 */
object ListViewContract {

    interface View : BaseMvpView {
        fun listData(apiResponse: APIResponse)

        fun showProgress()

        fun hideProgress()

    }

    interface Presenter : BaseMvpPresenter<View> {
        fun unRegister()

    }
}