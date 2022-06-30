package com.example.interviewexercise.listner

import com.example.interviewexercise.data.Movie

interface MoviesListner {
    fun clickItems(model: Movie)
}