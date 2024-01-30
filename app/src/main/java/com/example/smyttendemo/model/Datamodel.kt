package com.example.smyttendemo.model
import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("content")
    val content: List<ContentItem>
)

