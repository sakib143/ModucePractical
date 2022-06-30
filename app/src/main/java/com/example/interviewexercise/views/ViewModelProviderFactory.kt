package com.example.interviewexercise.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.interviewexercise.repository.MovieRepository
import com.example.interviewexercise.views.gallery.GalleryViewModel

class ViewModelProviderFactory(val movieRepository: MovieRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GalleryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GalleryViewModel(movieRepository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class [$modelClass]")
        }
    }

}