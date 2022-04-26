package ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapp.zaptv.R
import kotlinx.android.synthetic.main.fragment_movie.*
import model.Movies
import model.MoviesResponse
import movieAdapter.AdapterMovies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import service.MoviesAPI
import service.retrofit.RetrofitConfig
import util.Constants.popular



class MovieFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        LinearLayoutManager(this.context).also { rvMovieList.layoutManager = it }
        with(rvMovieList) { rvMovieList.setHasFixedSize(true) }

        srlRefresh.setOnRefreshListener {
            load()
            srlRefresh.isRefreshing = false
        }

        load()
    }


    private fun load() {
        getMovieData { movies: List<Movies> ->
            rvMovieList.adapter = AdapterMovies(movies)
        }
    }


    private fun getMovieData(callback: (List<Movies>) -> Unit) {
        val apiService = RetrofitConfig.getInstanceRetrofit().create(MoviesAPI::class.java)
        apiService.getMovieList(popular).enqueue(object : Callback<MoviesResponse> {

            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {

            }
        })
    }

}