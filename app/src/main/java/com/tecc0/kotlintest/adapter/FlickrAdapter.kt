package com.tecc0.kotlintest.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tecc0.kotlintest.R
import com.tecc0.kotlintest.viewholder.FlickrViewHolder
import com.tecc0.kotlintest.viewmodel.Gallery

class FlickrAdapter(context: Context, galleries: List<Gallery>) : RecyclerView.Adapter<FlickrViewHolder>() {

    private var context: Context

    private var galleries: List<Gallery>

    init {
        this.context = context
        this.galleries = galleries
    }

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

