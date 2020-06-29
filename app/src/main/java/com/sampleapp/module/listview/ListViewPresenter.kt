package com.sampleapp.module.listview

import com.sampleapp.api.RestService
import com.sampleapp.mvp.BaseMvpPresenterImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**
 * Created by Shubham_mittal on 27-Jun-20.
 */
class ListViewPresenter(private val mRestService: RestService,
                        private val listViewActivity: ListViewActivity) :
        BaseMvpPresenterImpl<ListViewContract.View>(), ListViewContract.Presenter {

    private var disposable: Disposable? = null




    /**
     * Api implementation
     */
    public fun getData() {

        mView?.showProgress()
        disposable = mRestService.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mView?.hideProgress()
                    mView?.listData(it)
                }, {
                    mView?.hideProgress()
                    mView?.showError(it)
                })
    }


    override fun unRegister() {
        disposable?.dispose()
    }
}