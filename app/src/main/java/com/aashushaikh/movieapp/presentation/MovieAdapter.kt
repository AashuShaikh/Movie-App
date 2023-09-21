package com.aashushaikh.movieapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aashushaikh.movieapp.R
import com.aashushaikh.movieapp.data.model.Movie
import com.aashushaikh.movieapp.databinding.ListItemBinding
import com.bumptech.glide.Glide

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val movieList = ArrayList<Movie>()

    fun setList(movies: List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }

    inner class MovieViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.titleTextView.text = movie.title
            binding.overviewTextView.text = movie.overview
            val posterUrl = "https://image.tmdb.org/t/p/w500" + movie.posterPath
            Glide.with(binding.imageView.context).load(posterUrl).fitCenter().placeholder(R.drawable.ic_image).into(binding.imageView)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MovieViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}