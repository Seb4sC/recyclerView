package com.sena.listas

import android.content.Intent
import android.icu.text.RelativeDateTimeFormatter.AbsoluteUnit
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sena.listas.adapter.RecyclerViewAdapter
import com.sena.listas.data.DataSource
import com.sena.listas.databinding.ActivityMainBinding
import com.sena.listas.model.Album

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var miRecycler: RecyclerView
    lateinit var miRecycler2: RecyclerView
    val miAdapter: RecyclerViewAdapter = RecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarRecycler()
    }

    fun cargarRecycler(){
        miRecycler = binding.rcvAlbumes
        miRecycler2 = binding.rcvAlbumesHorizontal
        miRecycler.setHasFixedSize(true)
        miRecycler2.setHasFixedSize(true)
        miRecycler.layoutManager = LinearLayoutManager(this)
        miRecycler2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        miAdapter.RecyclerViewAdapter(DataSource().getAlbumes(), this)
        miRecycler.adapter = miAdapter
        miRecycler2.adapter = miAdapter
        // Implementación del click en una de las card
        miAdapter.setOnItemClickListener(object: RecyclerViewAdapter.onItemClickListener{
            override fun onItemClickListener(position: Int) {
                val intent = Intent(this@MainActivity, DetalleAlbumActivity::class.java)
                intent.putExtra("imagen", DataSource().getAlbumes()[position].imagen)
                intent.putExtra("album", DataSource().getAlbumes()[position].nombre)
                intent.putExtra("fecha", DataSource().getAlbumes()[position].fecha)
                startActivity(intent)
                //Log.d("Info Album", DataSource().getAlbumes()[position].toString())
            }
        })
    }
}