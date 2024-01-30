package com.example.smyttendemo.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ContentItem(
    @SerializedName("type")
    val type: String,
    @SerializedName("data")
    val data: List<ProductItem>
)
