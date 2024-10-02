package edu.iesam.repaso.features.songs.presentation

import android.content.Context
import edu.iesam.repaso.features.songs.data.SongDataRepository
import edu.iesam.repaso.features.songs.data.remote.SongMockRemoteDataSource
import edu.iesam.repaso.features.songs.domain.GetSongUseCase
import edu.iesam.repaso.features.songs.domain.GetSongsUseCase

class SongFactory (private val context: Context){

    private val remote = SongMockRemoteDataSource()
    private val dataRepository = SongDataRepository(remote)
    private val getSongsUseCase = GetSongsUseCase(dataRepository)
    private val getSongUseCase = GetSongUseCase(dataRepository)

    fun buildViewModel(): SongViewModel{
        return SongViewModel(getSongsUseCase, getSongUseCase)
    }

}