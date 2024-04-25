package com.sena.listas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sena.listas.R
import com.sena.listas.model.Album

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    var albumes: MutableList<Album> = ArrayList()
    lateinit var context: Context

    // Constructor del recyclerViewAdapter
    fun RecyclerViewAdapter(albumes: MutableList<Album>, context: Context){
        this.albumes = albumes
        this.context = context
    }
        class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val albumNombre = view.findViewById<TextView>(R.id.txtName)
            val albumFecha = view.findViewById<TextView>(R.id.txtFecha)
            val albumFoto = view.findViewById<ImageView>(R.id.imvImage)

            fun bind(album: Album, context: Context){
                albumNombre.text = album.nombre
                albumFecha.text = album.fecha
                albumFoto.loadImage(album.imagen)
            }

            fun ImageView.loadImage(url:String){
                Glide.with(context).load(url).into(this)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_album, parent, false))
    }

    override fun getItemCount(): Int {
        return albumes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = albumes.get(position)
        holder.bind(item, context)
    }
}