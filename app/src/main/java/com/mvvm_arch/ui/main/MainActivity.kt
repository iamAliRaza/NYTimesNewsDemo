package com.mvvm_arch.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import com.mvvm_arch.databinding.ActivityMainBinding
import com.mvvm_arch.ui.base.BaseActivity

class MainActivity :  BaseActivity<ActivityMainBinding>(){

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate
    //private val  viewModel : MainActivityViewHolder = ViewModelProvider(this).get(MainActivityViewHolder::class.java)
}