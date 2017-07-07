package com.tecc0.kotlintest.viewholder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.squareup.picasso.Picasso
import com.tecc0.kotlintest.R
import com.tecc0.kotlintest.viewmodel.Gallery

class FlickrViewHolder(private val context: Context, itemView: View?) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.item_list_flickr_textview)
    lateinit var nameTextView: TextView

    @BindView(R.id.item_list_flickr_imageview)
    lateinit var photoImageView: ImageView

    init {
        itemView?.let { ButterKnife.bind(this, itemView) }
    }

    fun bind(galleries: List<Gallery>, position: Int) {
        val gallery = galleries.get(position)
        nameTextView.setText(gallery.title)
        Picasso.with(context).load(gallery.url).into(photoImageView)
    }
}