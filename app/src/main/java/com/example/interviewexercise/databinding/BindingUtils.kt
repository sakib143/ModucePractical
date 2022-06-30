package com.example.interviewexercise.databinding

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.interviewexercise.R
import com.example.interviewexercise.data.Movie
import com.example.interviewexercise.data.PopularMoviesResponse
import com.example.interviewexercise.networking.common.Resource
import com.example.interviewexercise.views.gallery.GalleryFragment
import com.example.interviewexercise.views.gallery.MovieAdapter

/**
 * As per the document
 * Highlight movies with a score of over 8 in any way you want (i.e. a star icon, a colored border, etc.)
 */
@BindingAdapter("setStartVisiblity")
fun setStartVisiblity(view: AppCompatImageView, voteAverage: Double?) {
    if(voteAverage != null) {
        if(voteAverage > 8.0 ){
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }
}

/**
 * Load image from URL
 */
@BindingAdapter("loadImageUrl")
fun loadImageUrl(view: ImageView, url: String?) {
    val fullUrl = "http://image.tmdb.org/t/p/w500/" + url
    Glide.with(view.context)
        .load(fullUrl)
        .into(view)
}

/**
 * Set recyclerview to show movies list
 */

@BindingAdapter("bindMoviewList","movieslistner", requireAll = false)
fun bindMoviewList(view: RecyclerView, data: Resource<PopularMoviesResponse>?, fragment: GalleryFragment) {
    if(data?.data != null) {
        view.addItemDecoration(DividerItemDecoration(view.context,DividerItemDecoration.HORIZONTAL))
        view.addItemDecoration(DividerItemDecoration(view.context,DividerItemDecoration.VERTICAL))
        var adapter = view.adapter
        adapter = MovieAdapter(view.context, data.data.results!!,fragment)
        view.adapter = adapter
    }
}
