package com.mvvm_arch.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mvvm_arch.data.model.NewsData
import com.mvvm_arch.databinding.FragmentNewsDetailBinding
import com.mvvm_arch.ui.base.BaseFragment

class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNewsDetailBinding =
        FragmentNewsDetailBinding::inflate

    override fun onStart() {
        super.onStart()

        arguments?.apply {
            val data: NewsData? = getParcelable("data")
            data?.apply {
                binding.title.text = title
                binding.abstractT.text = _abstract
                binding.byLine.text = byline
                binding.date.text = pDate
                binding.source.text = source
            }
        }
    }

}