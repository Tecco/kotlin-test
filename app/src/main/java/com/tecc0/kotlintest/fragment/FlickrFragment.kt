package com.tecc0.kotlintest.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.tecc0.kotlintest.R
import com.tecc0.kotlintest.adapter.FlickrAdapter
import com.tecc0.kotlintest.api.FlickrApi
import com.tecc0.kotlintest.api.RetrofitManager
import com.tecc0.kotlintest.model.Api
import com.tecc0.kotlintest.model.Flickr
import com.tecc0.kotlintest.viewmodel.Gallery
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class FlickrFragment : Fragment() {

    @BindView(R.id.fragment_flickr_recyclerview)
    lateinit var recyclerView: RecyclerView

    private lateinit var unbinder: Unbinder

    companion object {
        fun newInstance(): FlickrFragment {
            return FlickrFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_flickr, container, false)
        unbinder = ButterKnife.bind(this, view)

        initView()
        getFlickr()
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
    }

    private fun initView() {
        recyclerView.setHasFixedSize(true);
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(3, 1)
        recyclerView.setLayoutManager(staggeredGridLayoutManager)
    }

    private fun getFlickr() {
        RetrofitManager().getRetrofit(Api.FLICKR).create(FlickrApi::class.java)
                .index("2d2e76fc5a867664d3df6fded18f9c6e", "flickr.photos.search", "cat", "any", "json", 1, 30, 1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(object : Subscriber<Flickr>() {
                    override fun onCompleted() {

                    }

                    override fun onNext(flickr: Flickr?) {
                        var galleries: ArrayList<Gallery> = ArrayList()
                        // TODO: !!使いたくないけどとりま && コレクション操作でやりたいけどまだわからん
                        for ((num, p) in flickr?.photos?.photo!!.withIndex()) {
                            galleries.add(Gallery(num, p.title, String.format("http://c2.staticflickr.com/%s/%s/%s_%s.jpg", p.farm, p.server, p.id, p.secret, p.owner), p.owner))
                        }

                        val adapter = FlickrAdapter(context, galleries)
                        recyclerView.setAdapter(adapter)
                    }

                    override fun onError(e: Throwable?) {

                    }

                })
    }
}