package movieAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myapp.zaptv.R
import kotlinx.android.synthetic.main.item_movies.view.*
import model.Movies
import util.Constants.urlImage
import util.ConvertData

class AdapterMovies(private val movies: List<Movies>) :
    RecyclerView.Adapter<AdapterMovies.MoviesViewHolder>() {

    private lateinit var context: Context

    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imgBaseURL = urlImage

        fun bindMovie(movie: Movies) {

            itemView.apply {
                tvTitle.text = movie.title
                tvReleaseDate.text = ConvertData.toDate(movie.release)
                Glide.with(this).load(imgBaseURL + movie.poster)
                    .into(this.ivPosterPicture)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        context = parent.context
        return MoviesViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_movies, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bindMovie(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}