package com.tubetoast.movieview.ui.fragments.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import com.tubetoast.movieview.R
import com.tubetoast.movieview.databinding.FragmentListBinding
import com.tubetoast.movieview.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private var _binding : FragmentSplashBinding? = null
    private val binding : FragmentSplashBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Thread.sleep(1000)
//        requireActivity()
//            .supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.container, ListFragment())
//            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}