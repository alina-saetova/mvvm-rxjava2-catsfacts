package ru.itis.cats_facts.data.model

import com.google.gson.annotations.SerializedName

data class FactsResponse(
    @SerializedName("all")
    val items : List<FactItem>
)

data class FactItem(
    @SerializedName("_id") val id : String,
    @SerializedName("text") val text : String,
    @SerializedName("type") val type : String,
    @SerializedName("user") val user : User,
    @SerializedName("upvotes") val upvotes : Int,
    @SerializedName("userUpvoted") val userUpvoted : String
)

data class Name(
    @SerializedName("first") val first : String,
    @SerializedName("last") val last : String
)

data class User(
    @SerializedName("_id") val id : String,
    @SerializedName("name") val name : Name
)
