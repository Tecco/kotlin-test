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
import kotlinx.android.synthetic.main.activity_main.*


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
    }
}