package com.tubetoast.movieview.ui.fragments.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tubetoast.movieview.R
import com.tubetoast.movieview.entities.Movie

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.findViewById<TextView>(R.id.title)
    private val description = itemView.findViewById<TextView>(R.id.description)
    private val icon = itemView.findViewById<ImageView>(R.id.icon)

    fun setContent(movie: Movie){
        title.text = movie.title
        description.text = movie.description ?: ""
        movie.icon?.let{
            Glide.with(itemView)
                .load(it)
                .placeholder(R.drawable.placeholder)
                .into(icon)
        }
    }
}