package service

import model.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesAPI {

    @GET("/3/movie/{category}?api_key=bbf5a3000e95f1dddf266b5e187d4b21&language=pt-BR")
    fun getMovieList(@Path("category") category: String): Call<MoviesResponse>

}