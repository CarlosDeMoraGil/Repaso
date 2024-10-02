package edu.iesam.repaso.features.songs.data.remote

import edu.iesam.repaso.features.songs.domain.Song

class SongMockRemoteDataSource {

    val songs = listOf(
        Song("1", "sweetener", "Ariana Grande", "3.28", "Sweetener") ,
        Song("2", "Into you", "Ariana Grande", "4.04", "Dangerous Woman"),
        Song("3", "Safety net", "Ariana Grande", "3.28", "Positions"),
        Song("4", "Supernatural", "Ariana Grande", "2.43", "eternal sunshine")

    )

    fun getSongs(): List<Song>{
        return songs
    }

    fun getSong(id: String) : Song?{
        return songs.firstOrNull{song ->
            song.id == id
        }
    }

}