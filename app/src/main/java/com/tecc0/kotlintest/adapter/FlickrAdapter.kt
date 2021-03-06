package com.tecc0.kotlintest.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tecc0.kotlintest.R
import com.tecc0.kotlintest.viewholder.FlickrViewHolder
import com.tecc0.kotlintest.viewmodel.Gallery

class FlickrAdapter(private val context: Context, private val galleries: List<Gallery>) : RecyclerView.Adapter<FlickrViewHolder>() {

    override fun getItemCount(): Int {
        return galleries.size
    }

    override fun onBindViewHolder(holder: FlickrViewHolder?, position: Int) {
        holder?.bind(galleries, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FlickrViewHolder {
        val layoutView = LayoutInflater.from(context).inflate(R.layout.list_item_flickr, null);
        return FlickrViewHolder(context, layoutView)
    }

}

