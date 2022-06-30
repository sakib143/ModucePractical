package com.example.interviewexercise.views.gallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewexercise.data.Movie
import com.example.interviewexercise.data.PopularMoviesResponse
import com.example.interviewexercise.networking.common.Resource
import com.example.interviewexercise.repository.MovieRepository
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.ArrayList


class GalleryViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private val _moviesLiveData: MutableLiveData<Resource<PopularMoviesResponse>> = MutableLiveData<Resource<PopularMoviesResponse>>()
    val moviesLiveData: LiveData<Resource<PopularMoviesResponse>> get() = _moviesLiveData

    init {
        callAPI()
    }

    private fun callAPI() = viewModelScope.launch {
        _moviesLiveData.postValue(Resource.loading())
        val response = movieRepository.getPopularMovies(1)
        when (response) {
            is NetworkResponse.Success ->  {
                _moviesLiveData.postValue(Resource.success(response.body))
            }
            is NetworkResponse.NetworkError ->{
                _moviesLiveData.postValue(Resource.error(response.error.message,null,null))
            }
            is NetworkResponse.UnknownError -> {
                _moviesLiveData.postValue(Resource.error(response.error.message,null,null))
            }
        }
    }
}
