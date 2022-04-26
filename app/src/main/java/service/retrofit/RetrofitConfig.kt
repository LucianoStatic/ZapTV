package service.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    companion object {

        private const val BASE_URL = "https://api.themoviedb.org"

        private var retrofit: Retrofit? = null

        fun getInstanceRetrofit(): Retrofit {

            if (retrofit == null) {

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }


    }


}