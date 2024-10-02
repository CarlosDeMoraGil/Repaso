package edu.iesam.repaso.features.songs.presentation

import edu.iesam.repaso.features.songs.domain.GetSongUseCase
import edu.iesam.repaso.features.songs.domain.GetSongsUseCase
import edu.iesam.repaso.features.songs.domain.Song

class SongViewModel (private val getSongsUseCase: GetSongsUseCase, private val getSongUseCase: GetSongUseCase) {

    fun viewCreated(): List<Song>{
        return getSongsUseCase.invoke()
    }

    fun itemSelected(id : String): Song?{
        return getSongUseCase.invoke(id)
    }

}