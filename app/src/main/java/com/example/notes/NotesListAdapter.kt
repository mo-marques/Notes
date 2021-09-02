package com.example.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class NotesListAdapter: ListAdapter<Notes, NotesListAdapter.NotesViewHolder>(NotesComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.noteTitle)
    }

    class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val notesItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            notesItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): NotesViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return NotesViewHolder(view)
            }
        }
    }

    class NotesComparator : DiffUtil.ItemCallback<Notes>() {
        override fun areItemsTheSame(oldItem: Notes, newItem: Notes): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Notes, newItem: Notes): Boolean {
            return oldItem.noteTitle == newItem.noteTitle
        }
    }
}