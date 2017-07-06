package com.tecc0.kotlintest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.tecc0.kotlintest.fragment.FlickrFragment
import com.tecc0.kotlintest.fragment.QiitaFragment


class SecondActivity : AppCompatActivity(), QiitaFragment.Listener {

    companion object {
        fun createIntent(context: Context): Intent =
                Intent(context, SecondActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initFragment()
    }

    fun initFragment() {
        val ft: FragmentTransaction = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.activity_second_container, QiitaFragment.newInstance(), QiitaFragment.newInstance()::class.java.getSimpleName());
        ft.commit();
    }

    fun replaceFragment(fragment: Fragment) {
        val ft: FragmentTransaction = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.activity_second_container, fragment, fragment::class.java.getSimpleName());
        ft.addToBackStack(null);
        ft.commit();
    }

    override fun onNext() {
        replaceFragment(FlickrFragment.newInstance())
    }
}