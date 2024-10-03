package edu.iesam.repaso.features.songs.presentation

import android.content.Context
import edu.iesam.repaso.features.songs.data.SongDataRepository
import edu.iesam.repaso.features.songs.data.local.SongXmlLocalDataSource
import edu.iesam.repaso.features.songs.data.remote.SongMockRemoteDataSource
import edu.iesam.repaso.features.songs.domain.GetSongUseCase
import edu.iesam.repaso.features.songs.domain.GetSongsUseCase

class SongFactory (private val context: Context){

    private val local = SongXmlLocalDataSource(context)
    private val remote = SongMockRemoteDataSource()
    private val dataRepository = SongDataRepository(remote, local)
    private val getSongsUseCase = GetSongsUseCase(dataRepository)
    private val getSongUseCase = GetSongUseCase(dataRepository)

    fun buildViewModel(): SongsViewModel{
        return SongsViewModel(getSongsUseCase)
    }

    fun buildDetailViewModel(): SongDetailViewModel {
        return SongDetailViewModel((getSongUseCase))
    }

}