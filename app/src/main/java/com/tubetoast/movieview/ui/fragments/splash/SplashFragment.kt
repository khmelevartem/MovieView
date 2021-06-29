package com.tubetoast.movieview.ui.fragments.splash

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import com.google.android.material.snackbar.Snackbar
import com.tubetoast.movieview.R
import com.tubetoast.movieview.databinding.FragmentSplashBinding
import com.tubetoast.movieview.viewmodel.MainViewModel
import com.tubetoast.movieview.viewmodel.entities.AppState

class SplashFragment : Fragment() {

    private var _binding : FragmentSplashBinding? = null
    private val binding : FragmentSplashBinding get() = _binding!!

    private val viewModel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAppState().observe(viewLifecycleOwner){
            when (it) {
                AppState.Loading -> {
                    binding.bobbin.animate()
                        .rotation(360f)
                        .setDuration(DURATION)
                        .start()
                }
                AppState.Success -> {
                    binding.bobbin.clearAnimation()

                    binding.splashIcon
                        .animate()
                        .rotation(360f)
                        .translationXBy(1000f)
                        .setDuration(DURATION)
                        .start()
                    binding.splashTitle
                        .animate()
                        .translationYBy(500f)
                        .setStartDelay(DURATION/5)
                        .setDuration(DURATION/2)
                        .start()
                    binding.background
                        .animate()
                        .translationYBy(1500f)
                        .setDuration(DURATION)
                        .withEndAction {
                            parentFragmentManager.commit {
                                remove(this@SplashFragment)
                            }
                        }
                        .start()

                }
                is AppState.Error -> {
                    binding.bobbin.clearAnimation()
                    doOnError()
                }

            }
        }
        startLoading()
    }

    private fun doOnError(){
        Snackbar.make(binding.root,
            getString(R.string.internet_error),
            Snackbar.LENGTH_INDEFINITE).setAction(getString(R.string.retry)){
            startLoading()
        }.show()
    }

    private fun startLoading() {
        viewModel.getMovies()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.splashTitle.clearAnimation()
        binding.bobbin.clearAnimation()
        binding.splashIcon.clearAnimation()
        binding.background.clearAnimation()
        _binding = null
    }

    companion object{
        const val DURATION = 1000L
    }
}