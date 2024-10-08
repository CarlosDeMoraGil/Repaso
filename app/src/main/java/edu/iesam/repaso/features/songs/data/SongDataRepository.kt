package edu.iesam.repaso.features.songs.data

import edu.iesam.repaso.features.songs.data.local.SongXmlLocalDataSource
import edu.iesam.repaso.features.songs.data.remote.SongMockRemoteDataSource
import edu.iesam.repaso.features.songs.domain.Song
import edu.iesam.repaso.features.songs.domain.SongRepository

class SongDataRepository (val remote: SongMockRemoteDataSource, val local: SongXmlLocalDataSource) : SongRepository{




    override fun getSongs(): List<Song> {
       /** val songsFromLocal = local.findAll()
        if(songsFromLocal.isEmpty()){
            val songsFromRemote = remote.getSongs()
            local.saveAll(songsFromRemote)
            return songsFromRemote
        }else{
            return songsFromLocal
        }
*/      return remote.obtainSongs()
    }

    override fun getSong(id: String): Song? {
        return remote.getSong(id)

    }

}