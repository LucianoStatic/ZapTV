package service

import model.DetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesDetail {

    @GET("/3/movie/{id_movie}?api_key=853d1ab670ddf2e1742e2ba494ba7a8d&language=pt-BR")
    fun getDetail(@Path("id_movie") id: String): Call<DetailResponse>
}