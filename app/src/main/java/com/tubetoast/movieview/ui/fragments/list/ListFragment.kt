package com.tubetoast.movieview.ui.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.snackbar.Snackbar
import com.tubetoast.movieview.R
import com.tubetoast.movieview.databinding.FragmentListBinding
import com.tubetoast.movieview.viewmodel.MainViewModel
import com.tubetoast.movieview.viewmodel.entities.AppState

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding: FragmentListBinding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ListAdapter {
            viewModel.getAdditionalMovies()
        }
        binding.recyclerView.adapter = adapter
        viewModel.getMovies().observe(viewLifecycleOwner) { set ->
            adapter.content = set.map { it }
        }
        viewModel.getAppState().observe(viewLifecycleOwner) {
            when (it) {
                AppState.Loading -> {
                    binding.bottomInfo.visibility = View.VISIBLE
                }
                AppState.Success -> {
                    binding.bottomInfo.visibility = View.GONE
                }
                is AppState.Error -> {
                    binding.bottomInfo.visibility = View.GONE
                    doOnError(it.throwable)
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun doOnError(t: Throwable) {
        t.printStackTrace()
        Snackbar.make(binding.root,
            getString(R.string.internet_error) + ": " + t.localizedMessage,
            Snackbar.LENGTH_INDEFINITE).setAction(getString(R.string.retry)) {
            viewModel.getAdditionalMovies()
        }.show()
    }
}