package edu.iesam.repaso.features.songs.data.remote

import edu.iesam.repaso.features.songs.domain.Song

class SongMockRemoteDataSource {

    val songs = listOf(
        Song("1", "sweetener", "Ariana Grande", "3.28", "Sweetener", "https://www.lahiguera.net/musicalia/artistas/ariana_grande/disco/9129/ariana_grande_sweetener-portada.jpg"),
        Song("2", "Into you", "Ariana Grande", "4.04", "Dangerous Woman", "https://www.popelera.net/wp-content/uploads/2016/03/ariana-grande-dangerous.jpg"),
        Song("3", "Safety net", "Ariana Grande", "3.28", "Positions", "https://www.lahiguera.net/musicalia/artistas/ariana_grande/disco/10905/ariana_grande_positions-portada.jpg"),
        Song("4", "Supernatural", "Ariana Grande", "2.43", "eternal sunshine", "https://jenesaispop.com/wp-content/uploads/2024/01/GEDZBaiaQAANXnF.jpeg")

    )


    fun obtainSongs(): List<Song>{
        return songs
    }

    fun getSong(id: String) : Song?{
        return songs.firstOrNull{song ->
            song.id == id
        }
    }

}