package com.tecc0.kotlintest.fragment

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder
import com.tecc0.kotlintest.R
import com.tecc0.kotlintest.api.RetrofitManager
import com.tecc0.kotlintest.api.SchemaApi
import com.tecc0.kotlintest.model.Api
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class QiitaFragment : Fragment() {

    @BindView(R.id.fragment_qiita_container)
    lateinit var container: LinearLayout

    @BindView(R.id.fragment_qiita_textview)
    lateinit var textView: TextView

    private lateinit var unbinder: Unbinder

    private lateinit var listener: Listener

    companion object {
        fun newInstance(): QiitaFragment {
            return QiitaFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_qiita, container, false)
        unbinder = ButterKnife.bind(this, view)

        listener = activity as Listener

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
    }

    @OnClick(R.id.fragment_qiita_button)
    fun buttonClicked() {
        Snackbar.make(container, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        RetrofitManager().getRetrofit(Api.QIITA).create(SchemaApi::class.java)
                .index()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe({ schema ->
                    textView.setText(schema?.description)
                }, { e: Throwable? ->
                    e?.printStackTrace()
                })
    }

    @OnClick(R.id.fragment_qiita_next_button)
    fun nextButtonClicked() {
        listener.onNext()
    }

    interface Listener {
        fun onNext()
    }
}
