package edu.iesam.repaso.features.songs.presentation

import edu.iesam.repaso.features.songs.domain.GetSongUseCase
import edu.iesam.repaso.features.songs.domain.Song

class SongDetailViewModel (private val getSongUseCase: GetSongUseCase){

    fun viewCreated(id: String): Song?{
        return getSongUseCase.invoke(id)
    }

}