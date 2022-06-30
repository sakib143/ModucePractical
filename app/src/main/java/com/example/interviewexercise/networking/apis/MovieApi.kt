package com.example.interviewexercise.networking.apis

import com.example.interviewexercise.data.Movie
import com.example.interviewexercise.data.PopularMoviesResponse
import com.haroldadmin.cnradapter.NetworkResponse
import com.example.interviewexercise.data.GenericErrorResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular?api_key=bf718d4dd8b23985d9c3edbcfd440a27")
    suspend fun getPopularMoviesAsync() : NetworkResponse<PopularMoviesResponse, GenericErrorResponse>
}
