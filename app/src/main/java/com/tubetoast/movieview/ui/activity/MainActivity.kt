package com.tubetoast.movieview.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.tubetoast.movieview.R
import com.tubetoast.movieview.databinding.ActivityMainBinding
import com.tubetoast.movieview.ui.fragments.list.ListFragment
import com.tubetoast.movieview.ui.fragments.splash.SplashFragment
import com.tubetoast.movieview.viewmodel.AbstractViewModel
import com.tubetoast.movieview.viewmodel.MainViewModel
import com.tubetoast.movieview.viewmodel.entities.AppState

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : AbstractViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null)
            supportFragmentManager.commit {
                add(R.id.container, SplashFragment())
            }
    }

}