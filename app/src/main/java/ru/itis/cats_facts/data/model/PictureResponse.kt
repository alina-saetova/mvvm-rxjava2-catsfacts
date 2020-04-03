package ru.itis.cats_facts.data.model

import com.google.gson.annotations.SerializedName

data class PictureResponseItem(
    @SerializedName("breeds")
    var breeds: List<Any> = listOf(),
    @SerializedName("categories")
    var categories: List<Category> = listOf(),
    @SerializedName("height")
    var height: Int = 0,
    @SerializedName("id")
    var id: String = "",
    @SerializedName("url")
    var url: String = "",
    @SerializedName("width")
    var width: Int = 0
)

data class Category(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String = ""
)
