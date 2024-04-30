package com.sena.listas

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.sena.listas.databinding.ActivityDetalleAlbumBinding

class DetalleAlbumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalleAlbumBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarDetalle()
    }

    private fun cargarDetalle(){
        var nombre: String = intent.getStringExtra("album").toString()
        var fecha: String = intent.getStringExtra("fecha").toString()
        var imagen = intent.getStringExtra("imagen")

        binding.imvImage.loadImage(imagen.toString())
        binding.txtName.text = nombre
        binding.txtFecha.text = fecha
    }

    fun ImageView.loadImage(url:String){
        Glide.with(context).load(url).into(this)
    }
}