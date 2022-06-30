package com.example.interviewexercise.views.gallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.interviewexercise.R
import com.example.interviewexercise.data.Movie
import com.example.interviewexercise.data.PopularMoviesResponse
import com.example.interviewexercise.databinding.FragmentGalleryBinding
import com.example.interviewexercise.listner.MoviesListner
import com.example.interviewexercise.networking.common.Resource
import com.example.interviewexercise.repository.MovieRepository
import com.example.interviewexercise.views.ViewModelProviderFactory
import com.google.android.material.snackbar.Snackbar


class GalleryFragment : Fragment(), MoviesListner {

    companion object {
        fun newInstance() = GalleryFragment()
    }

    private lateinit var viewModel: GalleryViewModel
    private val movieRepository: MovieRepository = MovieRepository()

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity(),ViewModelProviderFactory(movieRepository)).get(GalleryViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewmodel = viewModel
            listner = this@GalleryFragment
        }
        val view = binding.root
        return view
    }

    override fun clickItems(model: Movie) {
        Snackbar.make(binding.root, model.title.toString(), Snackbar.LENGTH_LONG).show();
    }

}
