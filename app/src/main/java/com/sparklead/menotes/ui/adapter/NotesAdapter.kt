package com.sparklead.menotes.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sparklead.menotes.R
import com.sparklead.menotes.databinding.ItemNotesBinding
import com.sparklead.menotes.ui.model.Notes

class NotesAdapter(val context: Context?, val notesList: List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    inner class NotesViewHolder(val binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val data = notesList[position]

        holder.binding.tvHeading.text = data.Heading
        holder.binding.tvDetails.text = data.details
        holder.binding.tvDate.text = data.date

        holder.binding.cvNotes.setBackgroundResource(R.color.semiTransparentColor)
//        holder.binding.cvNotes.elevation = 20f
    }

    override fun getItemCount(): Int {
        return notesList.size
    }
}