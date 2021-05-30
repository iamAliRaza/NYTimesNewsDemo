package com.mvvm_arch.data.model

import com.google.gson.annotations.SerializedName

data class APIResponse(
    @SerializedName("results")
    val newsDataList: List<NewsData>
)
