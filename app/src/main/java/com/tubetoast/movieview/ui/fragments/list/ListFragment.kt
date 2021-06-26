package com.tubetoast.movieview.ui.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.tubetoast.movieview.databinding.FragmentListBinding
import com.tubetoast.movieview.viewmodel.MainViewModel

class ListFragment : Fragment() {

    private var _binding : FragmentListBinding? = null
    private val binding : FragmentListBinding get() = _binding!!

    private val viewModel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}