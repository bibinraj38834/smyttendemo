package com.example.smyttendemo.model
import com.google.gson.annotations.SerializedName

data class ProductItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: String
)