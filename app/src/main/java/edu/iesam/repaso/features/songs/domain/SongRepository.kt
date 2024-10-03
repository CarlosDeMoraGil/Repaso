package edu.iesam.repaso.features.songs.domain

interface SongRepository {

    fun getSongs(): List<Song>
    fun getSong(id: String) : Song?

}