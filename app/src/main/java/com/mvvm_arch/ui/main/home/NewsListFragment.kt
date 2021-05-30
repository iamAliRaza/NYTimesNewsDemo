package com.mvvm_arch.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm_arch.R
import com.mvvm_arch.data.DataState
import com.mvvm_arch.databinding.FragmentNewsListBinding
import com.mvvm_arch.ui.adapters.NewsAdapter
import com.mvvm_arch.ui.base.BaseFragment
import com.mvvm_arch.utils.showToast

class NewsListFragment : BaseFragment<FragmentNewsListBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNewsListBinding =
        FragmentNewsListBinding::inflate

    private val viewModel: NewsListFragmentViewModel by viewModels()
    private lateinit var adapter: NewsAdapter

    override fun onStart() {
        super.onStart()

        context?.let {

            binding.swipeToRefresh.setOnRefreshListener {
                viewModel.fetchNews()
            }


            binding.articleList.layoutManager = LinearLayoutManager(it)
            adapter = NewsAdapter { data ->
                findNavController().navigate(
                    R.id.action_newsListFragment_to_newsDetailFragment,
                    bundleOf("data" to data)
                )
            }
            binding.articleList.adapter = adapter
        }

        viewModel.apiResponseLiveData.observe(viewLifecycleOwner, {
            when (it) {
                is DataState.Error -> showToast(it.message)
                is DataState.Success -> {
                    binding.swipeToRefresh.isRefreshing = false
                    adapter.updateItems(it.data)
                }
            }
        })

        binding.swipeToRefresh.isRefreshing = true
        viewModel.fetchNews()

    }

}