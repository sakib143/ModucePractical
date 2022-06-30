package com.example.interviewexercise.views.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewexercise.data.Movie
import com.example.interviewexercise.databinding.AdapterMoviesBinding
import com.example.interviewexercise.BR
import com.example.interviewexercise.listner.MoviesListner


class MovieAdapter (
    private val context: Context,
    private val dataList: ArrayList<Movie>,
    private val listner: MoviesListner
) : RecyclerView.Adapter<MovieAdapter.BindingViewHolder>() {

    override fun getItemCount() = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val rootView: ViewDataBinding = AdapterMoviesBinding.inflate(LayoutInflater.from(context), parent, false)
        return BindingViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val model = dataList[position]
        holder.itemBinding.setVariable(BR.model, model)
        holder.itemBinding.setVariable(BR.listner, listner)
        holder.itemBinding.executePendingBindings()
    }

    class BindingViewHolder(val itemBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(itemBinding.root)
}