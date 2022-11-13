package com.got.trabajopractico.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.got.trabajopractico.R
import com.got.trabajopractico.model.Book
import com.got.trabajopractico.model.Character

class CharacterAdapter (private val characters: List<Character>) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_home_list, parent, false)
        return ViewHolder(
            view
        )
    }
    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        holder.firstName.text = character.name
        holder.lastName.text = character.culture
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName: TextView = itemView.findViewById(R.id.txtFirts)
        val lastName: TextView = itemView.findViewById(R.id.txtSecond)
    }
}