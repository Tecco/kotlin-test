package com.tecc0.kotlintest.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.tecc0.kotlintest.R


class FlickrFragment : Fragment() {

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
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
    }

    private fun initView() {

    }
}