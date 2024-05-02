package com.sena.listas

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sena.listas.adapter.RecyclerViewAdapter
import com.sena.listas.data.DataSource
import com.sena.listas.databinding.ActivityMainBinding
import com.sena.listas.model.Album

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var miRecycler: RecyclerView
    //lateinit var miRecycler2: RecyclerView
    val miAdapter: RecyclerViewAdapter = RecyclerViewAdapter(DataSource().getAlbumes())
    val miLista: MutableList<Album> = DataSource().getAlbumes()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarRecycler()
    }

    // Crear el menú
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)
        val searchItem = menu!!.findItem(R.id.actionSearch)
        val searchView: SearchView? = searchItem.actionView as SearchView
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText != null){
                    val albumFiltrado = miLista.filter { album -> album.nombre.lowercase().contains(newText) }
                    if (albumFiltrado.isEmpty()){
                        val listaVacia: MutableList<Album> = mutableListOf()
                        miAdapter.actualizarLista(listaVacia)
                        Toast.makeText(this@MainActivity, "No hay concidencias", Toast.LENGTH_SHORT).show()
                    } else {
                        miAdapter.actualizarLista(albumFiltrado.toMutableList())
                    }
                }
                return true
            }

        })
        return true
    }

    fun cargarRecycler(){
        miRecycler = binding.rcvAlbumes
        //miRecycler2 = binding.rcvAlbumesHorizontal
        miRecycler.setHasFixedSize(true)
        //miRecycler2.setHasFixedSize(true)
        miRecycler.layoutManager = LinearLayoutManager(this)
        //miRecycler2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        miAdapter.RecyclerViewAdapter(DataSource().getAlbumes(), this)
        miRecycler.adapter = miAdapter
        //miRecycler2.adapter = miAdapter
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