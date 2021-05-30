package com.mvvm_arch.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsData(
    @SerializedName("title")
    val title: String,
    @SerializedName("abstract")
    val _abstract: String,
    @SerializedName("published_date")
    val pDate: String,
    @SerializedName("byline")
    val byline: String,
    @SerializedName("source")
    val source: String
): Parcelable
