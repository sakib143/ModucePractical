package com.example.interviewexercise.repository

import com.example.interviewexercise.data.GenericErrorResponse
import com.example.interviewexercise.data.PopularMoviesResponse
import com.example.interviewexercise.networking.RetrofitFactory
import com.haroldadmin.cnradapter.NetworkResponse

class MovieRepository {

    private val movieApi = RetrofitFactory.getMovieApi()

    suspend fun getPopularMovies(page: Int): NetworkResponse<PopularMoviesResponse, GenericErrorResponse> {
            return movieApi.getPopularMoviesAsync()
    }

}
