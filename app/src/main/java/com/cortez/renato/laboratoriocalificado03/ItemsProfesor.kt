package com.cortez.renato.laboratoriocalificado03

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ItemsProfesor(private val context: Context, private val teachers: List<Profesor>) :
    RecyclerView.Adapter<ItemsProfesor.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.teacher_photo)
        val name: TextView = itemView.findViewById(R.id.teacher_name)
        val lastName: TextView = itemView.findViewById(R.id.teacher_last_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_profesor, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val teacher = teachers[position]
        holder.name.text = teacher.name
        holder.lastName.text = teacher.last_name
        Glide.with(context).load(teacher.image_url).into(holder.photo)

        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${teacher.phone_number}"))
            context.startActivity(intent)
        }

        holder.itemView.setOnLongClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${teacher.email}")
            }
            context.startActivity(intent)
            true
        }
    }

    override fun getItemCount(): Int = teachers.size
}
