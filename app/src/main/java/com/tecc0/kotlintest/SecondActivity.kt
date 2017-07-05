package com.tecc0.kotlintest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.tecc0.kotlintest.api.RetrofitManager
import com.tecc0.kotlintest.api.SchemaApi
import com.tecc0.kotlintest.model.SchemaResponse
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class SecondActivity : AppCompatActivity() {

    @BindView(R.id.activity_second_container)
    lateinit var container: LinearLayout

    @BindView(R.id.activity_second_textview)
    lateinit var textView: TextView

    companion object {
        fun createIntent(context: Context): Intent =
                Intent(context, SecondActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        ButterKnife.bind(this)

        textView.setText("fuga")
    }

    @OnClick(R.id.activity_second_button)
    fun buttonClicked() {
        Snackbar.make(container, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        RetrofitManager().getRetrofit().create(SchemaApi::class.java).index().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(object : Subscriber<SchemaResponse>(){
                    override fun onCompleted() {

                    }

                    override fun onNext(t: SchemaResponse?) {
                        textView.setText(t?.description)
                    }

                    override fun onError(e: Throwable?) {

                    }

                })
    }
}