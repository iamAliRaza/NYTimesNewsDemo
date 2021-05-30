package com.mvvm_arch.ui.main.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.mvvm_arch.data.DataState
import com.mvvm_arch.data.model.NewsData
import com.mvvm_arch.data.repositories.NYTimesRepositoryImp

class NewsListFragmentViewModel : ViewModel(), Observer<DataState<List<NewsData>>> {

    private val _apiResponseLiveData: MutableLiveData<DataState<List<NewsData>>> = MutableLiveData()
    val apiResponseLiveData: LiveData<DataState<List<NewsData>>> = _apiResponseLiveData
    private val repository = NYTimesRepositoryImp()

    init {
        repository.apiResponseLiveData.observeForever(this)
    }

    fun fetchNews () {
        repository.getMostViewedNews()
    }

    override fun onChanged(t: DataState<List<NewsData>>) {
        _apiResponseLiveData.value = t
    }

    override fun onCleared() {
        repository.apiResponseLiveData.removeObserver(this)
        super.onCleared()
    }

}