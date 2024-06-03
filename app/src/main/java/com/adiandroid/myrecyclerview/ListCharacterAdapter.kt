package com.adiandroid.myrecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ListCharacterAdapter(private val listCharacter: ArrayList<Character>) : RecyclerView.Adapter<ListCharacterAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_character, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, bg, cast, age, listbg) = listCharacter[position]
        val context = holder.itemView.context
        val charbg = ContextCompat.getDrawable(holder.itemView.context, listbg)
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.bgchar.background = charbg
        holder.itemView.setOnClickListener {
            val intent= Intent(context, Details_Character::class.java)
            intent.putExtra(Details_Character.extraname, name)
            intent.putExtra(Details_Character.extradesc, description)
            intent.putExtra(Details_Character.extrapic, photo)
            intent.putExtra(Details_Character.extrabg, bg)
            intent.putExtra(Details_Character.extracast, cast)
            intent.putExtra(Details_Character.extraage, age)
            context.startActivity(intent)
            }
    }

    override fun getItemCount(): Int = listCharacter.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val bgchar: ConstraintLayout = itemView.findViewById(R.id.character_listbg)
    }
}