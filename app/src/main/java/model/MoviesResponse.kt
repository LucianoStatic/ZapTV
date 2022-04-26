package model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class MoviesResponse(
    @SerializedName("results")
    val movies: List<Movies>

)