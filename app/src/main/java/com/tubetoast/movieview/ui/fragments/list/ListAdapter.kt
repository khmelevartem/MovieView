package com.tubetoast.movieview.ui.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tubetoast.movieview.R
import com.tubetoast.movieview.entities.Movie

class ListAdapter(
    private val downloadMore: () -> Unit,
) : RecyclerView.Adapter<ViewHolder>() {

    var content: List<Movie>? = null
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        content?.let{
            if (position == it.size-2) downloadMore()
            holder.setContent(it[position])
        }
    }

    override fun getItemCount(): Int {
        return content?.size ?: 0
    }

}