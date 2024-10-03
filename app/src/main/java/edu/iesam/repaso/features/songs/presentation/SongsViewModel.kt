package edu.iesam.repaso.features.songs.presentation

import edu.iesam.repaso.features.songs.domain.GetSongUseCase
import edu.iesam.repaso.features.songs.domain.GetSongsUseCase
import edu.iesam.repaso.features.songs.domain.Song

class SongsViewModel (private val getSongsUseCase: GetSongsUseCase) {

    fun viewCreated(): List<Song>{
        return getSongsUseCase.invoke()
    }


}