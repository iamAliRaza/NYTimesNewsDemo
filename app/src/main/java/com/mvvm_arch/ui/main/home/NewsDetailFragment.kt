package com.mvvm_arch.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mvvm_arch.databinding.FragmentNewsDetailBinding
import com.mvvm_arch.ui.base.BaseFragment

class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNewsDetailBinding =
        FragmentNewsDetailBinding::inflate

    override fun onStart() {
        super.onStart()

        arguments?.apply {
            NewsDetailFragmentArgs.fromBundle(this).data.apply outer@ {
                binding.apply {
                    title.text = this@outer.title
                    abstractT.text = _abstract
                    byLine.text = byline
                    date.text = pDate
                    source.text = this@outer.source
                }
            }
        }
    }

}