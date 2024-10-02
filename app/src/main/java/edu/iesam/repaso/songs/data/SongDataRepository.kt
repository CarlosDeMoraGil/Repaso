package edu.iesam.repaso.features.songs.data

import edu.iesam.repaso.features.songs.data.remote.SongMockRemoteDataSource
import edu.iesam.repaso.features.songs.domain.Song
import edu.iesam.repaso.features.songs.domain.SongRepository

class SongDataRepository (val remote: SongMockRemoteDataSource) : SongRepository{

    override fun getSongs(): List<Song> {
        return remote.getAll()
    }

    override fun getSong(id: String): Song? {
        return remote.getSong(id)
    }

}