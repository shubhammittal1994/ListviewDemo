package com.sampleapp.module.listview


import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
import android.util.Log
import android.view.View
import android.widget.ListView
import com.sampleapp.R
import com.sampleapp.data.response.APIResponse
import com.sampleapp.data.response.Row
import com.sampleapp.module.application.SampleApplication
import com.sampleapp.module.listview.adapter.ListAdapterCustom
import com.sampleapp.mvp.BaseMvpActivity
import com.sampleapp.utils.ProgressBarHandler
import javax.inject.Inject


class ListViewActivity : BaseMvpActivity(), ListViewContract.View, View.OnClickListener {

    @Inject
    lateinit var mPresenter: ListViewPresenter

    @Inject
    lateinit var mProgressBarHandler: ProgressBarHandler

    private lateinit var listView: ListView
    private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout
    private  var dataList: MutableList<Row>?= mutableListOf<Row>()
    lateinit var adapter:ListAdapterCustom


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)
        (application as SampleApplication).createLoginComponent(this)?.inject(this)

        listView = findViewById(R.id.lstView)
        mSwipeRefreshLayout = findViewById(R.id.swiperefresh_items)

        //pull to refresh
        mSwipeRefreshLayout.setOnRefreshListener {
            mPresenter.getData();
            mSwipeRefreshLayout.isRefreshing = false;
        }

        mPresenter.attachView(this)

        // API call

        mPresenter.getData();
         adapter = ListAdapterCustom(this, dataList!!)
        listView.adapter = adapter



    }

    override fun listData(apiResponse: APIResponse) {
        dataList!!.addAll(apiResponse.rows)
        adapter.notifyDataSetChanged()
        Log.e("------>>>>>>>>>>", apiResponse.toString())
    }




    override fun showProgress() {
        mProgressBarHandler.showProgress()
    }

    override fun hideProgress() {
        mProgressBarHandler.hideProgress()
    }

    /**
     * click handle on views
     */
    override fun onClick(p0: View?) {

    }

    /**
     * release all listeners and components
     */
    override fun onDestroy() {
        super.onDestroy()
        (application as SampleApplication).releaseLoginComponent()
        mPresenter.detachView()
        mPresenter.unRegister()
    }
}
