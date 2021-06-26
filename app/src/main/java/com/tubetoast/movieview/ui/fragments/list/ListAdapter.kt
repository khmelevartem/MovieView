package com.tubetoast.movieview.ui.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tubetoast.movieview.R
import com.tubetoast.movieview.entities.Movie

class ListAdapter(var content: List<Movie>? = null) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        content?.let{
            holder.setContent(it[position])
        }
    }

    override fun getItemCount(): Int {
        return content?.size ?: 0
    }

}