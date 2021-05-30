package com.mvvm_arch.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mvvm_arch.data.DataState
import com.mvvm_arch.data.model.APIResponse
import com.mvvm_arch.data.model.NewsData
import com.mvvm_arch.data.remote.NYTimesAPIInterface
import com.mvvm_arch.utils.AppConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NYTimesRepositoryImp : NYTimesRepository {

    private val _apiResponseLiveData: MutableLiveData<DataState<List<NewsData>>> = MutableLiveData()
    val apiResponseLiveData: LiveData<DataState<List<NewsData>>> = _apiResponseLiveData

    override fun getMostViewedNews() {

        NYTimesAPIInterface.create().getMostViewedNews(AppConstants.API.API_KEY)
            .enqueue(object : Callback<APIResponse> {

                override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {

                    val body: APIResponse? = response.body()
                    _apiResponseLiveData.value = if (response.isSuccessful && body != null) {
                        DataState.success(response.body()!!.newsDataList)
                    } else {
                        DataState.error(response.toString())
                    }
                }

                override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                    _apiResponseLiveData.value = DataState.error(t.toString())
                }
            })
    }
}

