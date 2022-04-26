package model


import com.google.gson.annotations.SerializedName


data class DetailResponse(
    @SerializedName("original_title")
    val title: String,

    @SerializedName("poster_path")
    val poster: String?,

    @SerializedName("release_date")
    val release: String,

    @SerializedName("overview")
    val overview: String?
)
