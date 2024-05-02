package com.sena.listas.data

import com.sena.listas.model.Album

class DataSource() {
    fun getAlbumes(): MutableList<Album>{
        var albumes: MutableList<Album> = mutableListOf()
        albumes.add(Album("Invincible Shield","2024","https://upload.wikimedia.org/wikipedia/en/e/e5/Judas_Priest_-_Invincible_Shield.png"))
        albumes.add(Album("Album 1","2024","https://upload.wikimedia.org/wikipedia/en/e/e5/Judas_Priest_-_Invincible_Shield.png"))
        albumes.add(Album("Album 2","2024","https://upload.wikimedia.org/wikipedia/en/e/e5/Judas_Priest_-_Invincible_Shield.png"))
        albumes.add(Album("Album 3","2024","https://upload.wikimedia.org/wikipedia/en/e/e5/Judas_Priest_-_Invincible_Shield.png"))
        albumes.add(Album("Album 4","2024","https://upload.wikimedia.org/wikipedia/en/e/e5/Judas_Priest_-_Invincible_Shield.png"))
        albumes.add(Album("Invincible Shield","2024","https://upload.wikimedia.org/wikipedia/en/e/e5/Judas_Priest_-_Invincible_Shield.png"))
        albumes.add(Album("Invincible Shield","2024","https://upload.wikimedia.org/wikipedia/en/e/e5/Judas_Priest_-_Invincible_Shield.png"))
        albumes.add(Album("Invincible Shield","2024","https://upload.wikimedia.org/wikipedia/en/e/e5/Judas_Priest_-_Invincible_Shield.png"))
        albumes.add(Album("Invincible Shield","2024","https://upload.wikimedia.org/wikipedia/en/e/e5/Judas_Priest_-_Invincible_Shield.png"))
        albumes.add(Album("Invincible Shield","2024","https://upload.wikimedia.org/wikipedia/en/e/e5/Judas_Priest_-_Invincible_Shield.png"))
        albumes.add(Album("Invincible Shield","2024","https://upload.wikimedia.org/wikipedia/en/e/e5/Judas_Priest_-_Invincible_Shield.png"))
        albumes.add(Album("Invincible Shield","2024","https://upload.wikimedia.org/wikipedia/en/e/e5/Judas_Priest_-_Invincible_Shield.png"))
        return albumes
    }

}